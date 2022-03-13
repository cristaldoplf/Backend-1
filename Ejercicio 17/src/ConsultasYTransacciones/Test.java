package ConsultasYTransacciones;

import org.h2.command.Prepared;

import java.sql.*;
import java.time.LocalDate;

public class Test {
    // preparo varriable statica constante con la creacion de la tabla usuario con sus respectivas columnas.
    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS USUARIO; CREATE TABLE USUARIO"
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL,"
            + " EMAIL varchar(100) NOT NULL,"
            + " SUELDO numeric(15,2) NOT NULL"
            + ")";

    // preparo varriables estaticas constantes con el string premoldeado de creacion para nuevos usuarios y otra para modificarlos.
    private static final String SQL_INSERT = "INSERT INTO USUARIO (ID, NOMBRE, EMAIL, SUELDO) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE USUARIO SET SUELDO=? WHERE EMAIL=?";

    public static void main(String[] args) throws Exception {
        //creamos un usuario
        Usuario usuario = new Usuario("Pablo", "pablo@pablo.com", 10d);

        //creamos la conexion como null para hacer la creacion dentro de un try catch
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);

            //una vez creada la table (linea 28) hacemos un PreparedStatement para hacer el inserte parametrizado.
            //siempre vamos al metodo del tipo de dato y en los parametros va a posicion en como definimos la entrada de parametros
            // y despues valor
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, 1);
            psInsert.setString(2, usuario.getNombre());
            psInsert.setString(3, usuario.getEmail());
            psInsert.setDouble(4, usuario.getSueldo());
            psInsert.execute();

            //Antes de empezar la transaccion necesitamos establecer el autocommit false. De otro modo cada vez que hacemos algo, se va a commitear automaticamente.
            connection.setAutoCommit(false);

            //preparamos el statement del update.
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1, usuario.subirSueldo(10d));
            psUpdate.setString(2, usuario.getEmail());
            psUpdate.execute();

            //generamos una excepcion aritmetica para comprobar el rollback ( linea 77 )
            int a = 4 / 0;

            //commiteamos ya que esta apagado el autocommit y volvemos a prender el automatico despues de esto, de fallar algo, el TRY/CATCH
            //podran detectarlo y haremos un rollback previo a la desactivacion del autocommit, para mantener la integridad de los datos.
            connection.commit();
            connection.setAutoCommit(true);

            String sql = "SELECT * FROM USUARIO";
            ResultSet rd = statement.executeQuery(sql);
            while (rd.next()) {
                System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getString(3) + " " + rd.getDouble(4));
            }

        } catch (Exception e) {
            // de fallar imprimimos que paso por pantalla y hacemos el rollback
            e.printStackTrace();
            connection.rollback();
        } finally {
            //finalizar la conexion
            connection.close();

        }

        // si el rollback fue exitoso, no deberia efectuarse el update con lo cual en esta nueva consulta,
        // el sueldo debe ser el original de 10, en vez del updateado de 20.
        Connection connection1 = getConnection();
        Statement statement = connection1.createStatement();
        String sql = "SELECT * FROM USUARIO";
        ResultSet rd = statement.executeQuery(sql);
        while (rd.next()) {
            System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getString(3) + " " + rd.getDouble(4));
        }

    }

    //creo un metodo para conectarme a la base de datos. que me devuelve  un objeto de clase Connection.
    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "myPassword");
    }
}
