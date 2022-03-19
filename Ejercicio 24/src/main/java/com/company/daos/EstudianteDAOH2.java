package com.company.daos;

import com.company.entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOH2 implements IDao<Estudiante> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_estudiantes";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 1 levantar el driver y contactarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO estudiantes VALUES (?,?,?)");
            preparedStatement.setLong(1,estudiante.getId());
            preparedStatement.setString(2,estudiante.getNombre());
            preparedStatement.setString(3,estudiante.getApellido());

            //3 ejecutamos la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estudiante;


    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 1 levantar el driver y contactarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM estudiantes where id=?");
            preparedStatement.setLong(1,id);

            //3 ejecutamos la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Estudiante estudiante = null;

        // 1 levantar el driver y contactarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes WHERE id =?");
            preparedStatement.setLong(1,id);

            //3 ejecutamos la sentencia
            ResultSet result = preparedStatement.executeQuery();

            //4 evaluar los resultados
            while (result.next()){
                Long idEstudiante = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                estudiante = new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estudiante;
            }

    @Override
    public List<Estudiante> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Estudiante> list_estudiantes = new ArrayList<>();

        // 1 levantar el driver y contactarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes");

            //3 ejecutamos la sentencia
            ResultSet result = preparedStatement.executeQuery();

            //4 evaluar los resultados
            while (result.next()){
                Long idEstudiante = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                Estudiante estudiante = new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);

                list_estudiantes.add(estudiante);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_estudiantes;
    }
}
