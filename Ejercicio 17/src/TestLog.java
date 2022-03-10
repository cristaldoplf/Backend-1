import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import org.apache.log4j.Logger;

public class TestLog {
    private static final Logger logger = Logger.getLogger(TestLog.class);
    public static void main(String[] args) throws Exception {

        Empleado empleado1 = new Empleado(1, "la momia", 55, "Titanes", LocalDate.of(2021, 2, 6));
        Empleado empleado2 = new Empleado(2, "tufimeme", 55, "desierto", LocalDate.of(2010, 1, 15));
        Empleado empleado3 = new Empleado(3, "kato", 55, "Ring", LocalDate.of(1998, 5, 17));
        Empleado empleado4 = new Empleado(4, "el hombre de la barra de hielo", 55, "Ring", LocalDate.of(1998, 5, 17));
        Empleado empleado5 = new Empleado(5, "apolo", 55, "sarasa", LocalDate.of(1996, 5, 15));
        Empleado empleado6 = new Empleado(6, "william boo", 55, "214142", LocalDate.of(1998, 2, 17));
        GeneradorInsert insertador = new GeneradorInsert();


        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:" +
                "~/test", "sa", "");
        Statement stmt = con.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la
        //vuelve a crear
        String createSql = "DROP TABLE IF EXISTS EMPLEADO;\n" +
                "CREATE TABLE EMPLEADO(ID INT PRIMARY KEY, NOMBRE VARCHAR(255), EDAD INT, EMPRESA VARCHAR(255), FECHA DATE);\n" +
                insertador.insertEmpleado(empleado1)+
                insertador.insertEmpleado(empleado2)+
                insertador.insertEmpleado(empleado3)+
                insertador.insertEmpleado(empleado4)+
                insertador.insertEmpleado(empleado5)+
                insertador.insertEmpleado(empleado6)+
                "UPDATE EMPLEADO SET NOMBRE = 'caradagian' WHERE ID LIKE '1'; \n" +
                "DELETE FROM EMPLEADO WHERE ID = 5";
        stmt.execute(createSql);

        //Codigo para consultar todos los registros de la tabla TEST
        String sql = "select * from EMPLEADO";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        while (rd.next()) {
            System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getString(3) + " " + rd.getString(4) + " " + rd.getString(5));
        }


    }
}
//      "INSERT INTO EMPLEADO VALUES(" + empleado1.getId() + ",'" + empleado1.getNombre() + "'," + empleado1.getEdad() + ",'" + empleado1.getEmpresa() + "','"+empleado1.getFechaComienzo() + "');\n";