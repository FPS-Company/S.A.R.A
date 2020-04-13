package com.example.testetelaesboo.banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectionFactory {

    public Connection getConnection() {
        Connection conn = null;
        String urlSchema = "jdbc:mysql://localhost:3306/S.A.R.A";
        try {
            conn = DriverManager.getConnection(urlSchema, "root", "1234");
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}