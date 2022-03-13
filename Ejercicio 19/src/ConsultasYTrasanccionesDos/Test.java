package ConsultasYTrasanccionesDos;

import org.h2.command.Prepared;

import java.sql.*;
import java.time.LocalDate;

public class Test {
    //preparamos querys pre definidas de creacion
    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS PACIENTE; CREATE TABLE PACIENTE"
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL,"
            + " APELLIDO varchar(100) NOT NULL,"
            + " DOMICILIO varchar(100) NOT NULL,"
            + " DNI INT NOT NULL,"
            + " USUARIO varchar(100) NOT NULL,"
            + " PASSWORD varchar(100) NOT NULL"
            + ")";

    //preparamos querys parametrizadas
    private static final String SQL_INSERT = "INSERT INTO PACIENTE (ID, NOMBRE, APELLIDO, DOMICILIO, DNI, USUARIO, PASSWORD) VALUES (?,?,?,?,?,?,?)";
    // private static final String SQL_INSERT = "INSERT INTO USUARIO (ID, NOMBRE, EMAIL, SUELDO) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE PACIENTE SET PASSWORD=? WHERE USUARIO=?";



    public static void main(String[] args) throws Exception {
        Paciente paciente = new Paciente("pablo", "cristaldo", "calle falsa 1234", 3333333, "pablodev", "asd123");

        Connection connection = null;

        try {
            //conectamos y creamos la tabla
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);

            //insertamos datos en la tabla
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, 1);
            psInsert.setString(2, paciente.getNombre());
            psInsert.setString(3, paciente.getApellido());
            psInsert.setString(4, paciente.getDomicilio());
            psInsert.setInt(5, paciente.getDni());
            psInsert.setString(6, paciente.getUsuario());
            psInsert.setString(7, paciente.getPassword());
            psInsert.execute(); //4 horas sin salirme el ejercicio por que no habia ejecutado los insert, de esas cosas que no te olvidas JAMAS.

            connection.setAutoCommit(false);
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, "passwordmejorado");
            psUpdate.setString(2, "pablodev");
            psUpdate.execute();

            //generamos un error para checkear el funcionamiento del rollback
            int a = 4 / 0;

            connection.commit();
            connection.setAutoCommit(true);


        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
        }

        Connection connection1 = getConnection();
        Statement statement = connection1.createStatement();
        String sql = "SELECT * FROM PACIENTE";
        ResultSet rd = statement.executeQuery(sql);
        while (rd.next()) {
            System.out.println(rd.getInt(1)
                    + " " + rd.getString(2)
                    + " " + rd.getString(3)
                    + " " + rd.getString(4)
                    + " " + rd.getInt(5)
                    + " " + rd.getString(6)
                    + " " + rd.getString(7));
        }

    }

    //metodo de Connection
    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:" +
                "~/test", "sa", "");
    }


}
