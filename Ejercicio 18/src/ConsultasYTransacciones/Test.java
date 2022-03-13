package ConsultasYTransacciones;
import java.sql.*;
import java.time.LocalDate;

public class Test {
    // preparo varriable statica constante con la creacion de la tabla usuario con sus respectivas columnas.
    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXIST USUARIO; CREATE TABLE USUARIO"
            +"("
            +" ID INT PRIMARY KEY,"
            +" NOMBRE varchar(100) NOT NULL"
            +" EMAIL varchar(100) NOT NULL"
            +" SUELDO numeric(15,2) NOT NULL"
            +")";

    // preparo varriables estaticas constantes con el string premoldeado de creacion para nuevos usuarios y otra para modificarlos.
    private static final String SQL_INSERT = "INSERT INTO USUARIO (ID, NOMBRE, EMAIL, SUELDO) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE USUARIO SET SUELDO=? WHERE EMAIL=?";

    public static void main(String[] args) {


    }

    //creo un metodo para conectarme a la base de datos. que me devuelve  un objeto de clase Connection.
    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:" + "./Database/my","root","myPassword");
    }
}
