import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

public class TestLog {
    public static void main(String[] args) throws Exception {

        Empleado empleado1 = new Empleado(1, "pablo", 33, "DH", LocalDate.of(2021, 11, 17));

        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:" +
                "./Database/my", "root", "myPassword");
        Statement stmt = con.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la
        //vuelve a crear
        String createSql = "DROP TABLE IF EXISTS EMPLEADO;\n" +
                "CREATE TABLE EMPLEADO(ID INT PRIMARY KEY, NOMBRE VARCHAR(255), EDAD INT, EMPRESA VARCHAR(255), FECHA DATE);\n" +
                "INSERT INTO EMPLEADO VALUES(" + empleado1.getId() + ",'" + empleado1.getNombre() + "'," + empleado1.getEdad() + ",'" + empleado1.getEmpresa() + "','"+empleado1.getFechaComienzo() + "');\n";
        stmt.execute(createSql);

        //Codigo para consultar todos los registros de la tabla TEST
        String sql = "select * from EMPLEADO";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        while (rd.next()) {
            System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getString(3) + " " + rd.getString(4)+" "+ rd.getString(5));
        }
    }
}
