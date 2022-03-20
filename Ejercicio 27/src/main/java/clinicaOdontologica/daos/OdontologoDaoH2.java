package clinicaOdontologica.daos;

import clinicaOdontologica.entidades.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Se crea una conexion a la base de datos en el metodo Guardar");
            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGO VALUES (?,?,?,?)");
            preparedStatement.setLong(1, odontologo.getId());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setString(4, odontologo.getNumeroMatricula());

            preparedStatement.executeUpdate();
            logger.info("El odontologo con el id " + odontologo.getId() + " fue guardado en la base de datos");
            logger.info("Se cierra la conexion a la base de datos en el metodo Guardar");
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return odontologo;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Se crea una conexion a la base de datos en el metodo Eliminar");
            Odontologo odontologoParaEliminar = buscar(id);
            System.out.println(
                    "Se procede a eliminar el usuario con el id: " + odontologoParaEliminar.getId() + "\n" +
                            "con la matricula: " + odontologoParaEliminar.getNumeroMatricula()
            );
            preparedStatement = connection.prepareStatement("DELETE FROM ODONTOLOGO where id=?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            logger.info("El odontologo con el id " + id + " fue eliminado en la base de datos");
            logger.info("Se cierra la conexion a la base de datos en el metodo Eliminar");
            preparedStatement.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Odontologo buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Se crea una conexion a la base de datos en el metodo Buscar");
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologo WHERE id =?");
            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Long idOdontologo = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String matricula = result.getString("matricula");
                odontologo = new Odontologo(idOdontologo, nombre, apellido, matricula);
//                odontologo.setId(idOdontologo);
//                odontologo.setNombre(nombre);
//                odontologo.setApellido(apellido);
//                odontologo.setNumeroMatricula(matricula);
            }
            logger.info("El odontologo con el id " + id + " fue buscado en la base de datos en el metodo Buscar");
            logger.info("Se cierra la conexion a la base de datos");
            preparedStatement.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> list_odontologo = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Se crea una conexion a la base de datos en el metodo buscarTodos");
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologo");

            ResultSet result = preparedStatement.executeQuery();
//            preparedStatement.setLong(4, odontologo.getId());
//            preparedStatement.setString(2, odontologo.getNombre());
//            preparedStatement.setString(3, odontologo.getApellido());
//            preparedStatement.setString(1, odontologo.getNumeroMatricula());
            while (result.next()) {
                Long idOdontologo = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String matricula = result.getString("matricula");
                Odontologo odontologo = new Odontologo(idOdontologo, nombre, apellido, matricula);
//                odontologo.setId(idOdontologo);
//                odontologo.setNombre(nombre);
//                odontologo.setApellido(apellido);
//                odontologo.setNumeroMatricula(matricula);

                list_odontologo.add(odontologo);
            }
            logger.info("Fue requerida la lista de odontologos a la base de datos buscarTodos");
            logger.info("Se cierra la conexion a la base de datos");
            preparedStatement.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_odontologo;
    }
}
