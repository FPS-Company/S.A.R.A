package com.example.testetelaesboo.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectionFactory {

    public Connection getConnection() {
        Connection conn = null;
        String urlSchema = "jdbc:mysql://localhost:3306/pessoas";
        try {
            conn = DriverManager.getConnection(urlSchema, "root", "1234");
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}