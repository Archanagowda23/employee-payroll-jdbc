package com.bridgelabz.jdbcemployeepayroll;

/**
 * @author : Archana
 * @Since :18-04-2022
 * @purpose : Test Database Connectivity and Demonstrate JDBC Statement
 */

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBDemo {
    public static void main(String[] args) {
        System.out.println("welcome to employee-payroll mysql");

        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "Archana@123";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find driver in classpath");
        }
        listDrivers();
        try {
            System.out.println("Connecting to database: " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection successful: " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void listDrivers() {

        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println("   " + driverClass.getClass().getName());
        }
    }
}



