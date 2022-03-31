package com.example.MVCMapping.daos.Imp;


import com.example.MVCMapping.daos.IDao;
import com.example.MVCMapping.entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOH2 implements IDao<Estudiante> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/estudiantes";
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
            preparedStatement = connection.prepareStatement("INSERT INTO estudiante VALUES (?,?,?)");
            preparedStatement.setLong(1, estudiante.getId());
            preparedStatement.setString(2, estudiante.getNombre());
            preparedStatement.setString(3, estudiante.getApellido());

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
    public void eliminar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 1 levantar el driver y contactarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM estudiante where id=?");
            preparedStatement.setLong(1, id);

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
    public Estudiante buscar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Estudiante estudiante = null;

        // 1 levantar el driver y contactarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiante WHERE id =?");
            preparedStatement.setLong(1, id);

            //3 ejecutamos la sentencia
            ResultSet result = preparedStatement.executeQuery();

            //4 evaluar los resultados
            while (result.next()) {
                int idEstudiante = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                estudiante = new Estudiante(idEstudiante,nombre,apellido);
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
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiante");

            //3 ejecutamos la sentencia
            ResultSet result = preparedStatement.executeQuery();

            //4 evaluar los resultados
            while (result.next()) {
                int idEstudiante = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                Estudiante estudiante = new Estudiante(idEstudiante,nombre,apellido);

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

    public Estudiante update(Estudiante estudiante) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement("UPDATE estudiante SET nombre= ?, apellido= ? where id=?");
            preparedStatement.setLong(3, estudiante.getId());
            preparedStatement.setString(1, estudiante.getNombre());
            preparedStatement.setString(2, estudiante.getApellido());


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
}
