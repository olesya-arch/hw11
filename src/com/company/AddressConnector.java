package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {
    private static final String INSERT = "INSERT INTO addresses (id, city, street, number_house, house_building, flat) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM addresses";
    private static final String DELETE = "DELETE FROM addresses WHERE id = ?";
    private static final String UPDATE = "UPDATE addresses " +
            "SET city = ?, street = ?, number_house = ?, house_building = ?, flat = ? " +
            "WHERE id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM addresses WHERE id = ?";



       private static Connection connection;

       private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/address_db?useUnicode=true&serverTimezone=UTC";
       private static final String USER = "root";
       private static final String PASS = "user";

       public static Connection getConnection() {
        if ( connection== null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return connection;
       }

      public static void add (Addresses addresses) {
          Connection connection = AddressConnector.getConnection();
          try (
                  PreparedStatement statement = connection.prepareStatement(INSERT)
          ) {
              statement.setInt(1, addresses.getId());
              statement.setString(2, addresses.getCity());
              statement.setString(3, addresses.getStreet());
              statement.setInt(4, addresses.getNumberHouse());
              statement.setInt(5, addresses.getHouseBuilding());
              statement.setInt(6, addresses.getFlat());


               statement.executeUpdate();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
    public List<Addresses> readAll() {
        List<Addresses> res = new ArrayList<>();

        Connection connection = AddressConnector.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Addresses addresses = AddressConnector.toObject(result);

                res.add(addresses);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }
    public static Addresses toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String city = resultSet.getString("city");
        String street = resultSet.getString("street");
        int numberHouse = resultSet.getInt("number_house");
        int houseBuilding = resultSet.getInt("house_building");
        int flat = resultSet.getInt("flat");

        return new Addresses(id, city, street, numberHouse, houseBuilding, flat);
    }


    public static void delete(int id) {
        Connection connection = AddressConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(DELETE)
        ) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean update(Addresses addresses) {
        Connection connection = AddressConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setString(1,addresses.getCity());
            statement.setString(2, addresses.getStreet());
            statement.setInt(3, addresses.getNumberHouse());
            statement.setInt(4, addresses.getHouseBuilding());
            statement.setInt(5, addresses.getFlat());
            statement.setInt(6, addresses.getId());

            int changed = statement.executeUpdate();

            return changed != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public static Addresses byId(int id) {
        Connection connection = AddressConnector.getConnection();

        Addresses result = null;

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            result = AddressConnector.buildPerson(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public static Addresses buildPerson(ResultSet resultSet) {
        Addresses result = null;

        try {
            int id = resultSet.getInt("id");
            String city = resultSet.getString("city");
            String street = resultSet.getString("street");
            int numberHouse = resultSet.getInt("number_house");
            int houseBuilding = resultSet.getInt("house_building");
            int flat = resultSet.getInt("flat");

            result = new Addresses(id, city, street, numberHouse, houseBuilding, flat);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }



}





