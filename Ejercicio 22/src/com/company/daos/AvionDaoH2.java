package com.company.daos;

import com.company.entidades.Avion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionDaoH2 implements IDao<Avion>{

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_estudiantes";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";
    private final static String DB_CREATE = "CREATE TABLE AVION(ID INT PRIMARY KEY, MARCA VARCHAR(255), MODELO VARCHAR(255), MATRICULA VARCHAR(255))";
    private final static String DB_DROP = "DROP TABLE IF EXISTS AVION";
    private final static String DB_EDIT_MATRICULA = "UPDATE AVION SET MATRICULA = ? WHERE ID = ?";


    @Override
    public Avion registrar(Avion avion) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 1 levantar el driver y contactarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO avion VALUES (?,?,?,?)");
            preparedStatement.setLong(1,avion.getId());
            preparedStatement.setString(2,avion.getMarca());
            preparedStatement.setString(3,avion.getModelo());
            preparedStatement.setString(4,avion.getMatricula());



            //3 ejecutamos la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avion;

    }

    @Override
    public void modificar(Long id, String marca) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 1 levantar el driver y contactarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement(DB_EDIT_MATRICULA);
            preparedStatement.setString(1,marca);
            preparedStatement.setLong(2,id);

            //3 ejecutamos la sentencia
            ResultSet result = preparedStatement.executeQuery();

            //4 evaluar los resultados
            while (result.next()){
                System.out.println("\n Avion modificado con nueva matricula: ");
                System.out.println(result.getLong(1)
                        + " " + result.getString(2)
                        + " " + result.getString(3)
                        + " " + result.getString(4));

            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void darBaja(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 1 levantar el driver y contactarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM AVION WHERE ID=?");
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
    public List<Avion> verFlota() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Avion> list_avion = new ArrayList<>();

        // 1 levantar el driver y contactarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2 crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM AVION");

            //3 ejecutamos la sentencia
            ResultSet result = preparedStatement.executeQuery();

            //4 evaluar los resultados
            while (result.next()){
                Long idAvion = result.getLong("id");
                String marca = result.getString("marca");
                String modelo = result.getString("modelo");
                String matricula = result.getString("matricula");

                Avion avion = new Avion();
                avion.setId(idAvion);
                avion.setMarca(marca);
                avion.setModelo(modelo);
                avion.setMatricula(matricula);


                list_avion.add(avion);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_avion;
    }
}
