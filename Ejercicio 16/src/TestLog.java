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
        Empleado empleado2 = new Empleado(2, "tufimeme", 44, "desierto", LocalDate.of(2010, 1, 15));
        Empleado empleado3 = new Empleado(3, "kato", 24, "Ring", LocalDate.of(1998, 5, 17));
        Empleado empleado4 = new Empleado(4, "el hombre de la barra de hielo", 55, "Ring", LocalDate.of(1998, 5, 17));
        Empleado empleado5 = new Empleado(5, "apolo", 25, "sarasa", LocalDate.of(1996, 5, 15));
        Empleado empleado6 = new Empleado(6, "william boo", 222, "214142", LocalDate.of(1998, 2, 17));
        GeneradorInsert insertador = new GeneradorInsert();


        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:" +
                "~/test", "sa", "");
        Statement stmt = con.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la
        //vuelve a crear
        String createSql = "DROP TABLE IF EXISTS EMPLEADO;\n" +
                "CREATE TABLE EMPLEADO(ID INT PRIMARY KEY, NOMBRE VARCHAR(255), EDAD INT, EMPRESA VARCHAR(255), FECHA DATE);\n" +
                insertador.insertEmpleado(empleado1) +
                insertador.insertEmpleado(empleado2) +
                insertador.insertEmpleado(empleado3) +
                insertador.insertEmpleado(empleado4) +
                insertador.insertEmpleado(empleado5) +
                insertador.insertEmpleado(empleado6);
        stmt.execute(createSql);

        // updateamos info de un empleado
        String updateSql = "UPDATE EMPLEADO SET NOMBRE = 'Caradagian' WHERE ID = '3';";
        stmt.execute(updateSql);
        // consultamos el empleado de la tabla para ver si se cambio correctamente y lo mostramos en los logs como .debug.
        String sqlUpdate = "SELECT * FROM EMPLEADO WHERE ID = 3";
        ResultSet empleadoUpdateado = stmt.executeQuery(sqlUpdate);
        if (empleadoUpdateado.next()) {
            logger.debug("Ha sido actualizada la informacion del siguiente empleado" + ": " +
                    empleadoUpdateado.getInt(1) + " " +
                    empleadoUpdateado.getString(2) + " " +
                    empleadoUpdateado.getInt(3) + " " +
                    empleadoUpdateado.getString(4) + " " +
                    empleadoUpdateado.getString(5));
        }

        // consultamos si existe un empleado especifico, si es asi mostramos la informacion en los logs como .info y despues lo borramos de la base de datos.
        String sqlDelete = "SELECT * FROM EMPLEADO WHERE ID = 5";
        ResultSet empleadoDeleteado = stmt.executeQuery(sqlDelete);
        if (empleadoDeleteado.next()) {
            logger.info("Ha sido borrada la informacion del empleado" + ": " +
                    empleadoDeleteado.getInt(1) + " " +
                    empleadoDeleteado.getString(2) + " " +
                    empleadoDeleteado.getInt(3) + " " +
                    empleadoDeleteado.getString(4) + " " +
                    empleadoDeleteado.getString(5));

            // Borramos el empleado en caso de que existiera
            String deleteRow =
                    "DELETE FROM EMPLEADO WHERE ID = 5";
            stmt.execute(deleteRow);
        }

        // consultamos si existe un empleado especifico pero esta vez lo buscamos por nombre, si existe,
        // mostramos la informacion en los logs como .info y despues lo borramos de la base de datos.
        sqlDelete = "SELECT * FROM EMPLEADO WHERE NOMBRE = 'el hombre de la barra de hielo'";
        empleadoDeleteado = stmt.executeQuery(sqlDelete);
        if (empleadoDeleteado.next()) {
            logger.info("Ha sido borrada la informacion del empleado" + ": " +
                    empleadoDeleteado.getInt(1) + " " +
                    empleadoDeleteado.getString(2) + " " +
                    empleadoDeleteado.getInt(3) + " " +
                    empleadoDeleteado.getString(4) + " " +
                    empleadoDeleteado.getString(5));

            // Borramos el empleado en caso de que existiera
            String deleteRow =
                    "DELETE FROM EMPLEADO WHERE NOMBRE = 'el hombre de la barra de hielo'";
            stmt.execute(deleteRow);
        }

        //Codigo para consultar todos los registros de la tabla TEST
        String sql = "SELECT * FROM EMPLEADO";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        System.out.println("");
        System.out.println("Lista de Empleados:");
        while (rd.next()) {
            System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getInt(3) + " " + rd.getString(4) + " " + rd.getString(5));
//            logger.debug(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getString(3) + " " + rd.getString(4) + " " + rd.getString(5));
        }


    }
}
//      "INSERT INTO EMPLEADO VALUES(" + empleado1.getId() + ",'" + empleado1.getNombre() + "'," + empleado1.getEdad() + ",'" + empleado1.getEmpresa() + "','"+empleado1.getFechaComienzo() + "');\n";