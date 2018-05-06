package com.salad.storage;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DatabaseStorage implements StorageSource {

    private static final String URL = "jdbc:mysql://localhost:3306/salad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection databaseConnection;

    public DatabaseStorage() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            databaseConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвера");
        }
    }

    @Override
    public int getTomatoAmount() {
        return getVegetableAmount(1);
    }

    @Override
    public int getCucumberAmount() {
        return getVegetableAmount(2);
    }

    @Override
    public int getPepperAmount() {
        return getVegetableAmount(3);
    }

    private int getVegetableAmount(int typeIndex) {
        try {
            String query = "select amount from vegetable_amount";
            Statement statement = databaseConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.absolute(typeIndex)) {
                return resultSet.getInt("amount");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public void cleanUp() {
        try {
            databaseConnection.close();
        } catch (SQLException e) {
            System.out.println("Проблемы при закрытии соединения с БД");
        }
    }
}
