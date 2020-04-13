package com.example.testetelaesboo.banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class gerenciarBanco{

    private static String uri = "localhost";//Do meu computador a senha é vazio
    private static String port = "3306";
    private static String schema = "S.A.R.A";
    private static String login = "root";
    private static String senha = "1234";
    private static String url = "jdbc:mysql://localhost:3306/";


    private static void criarSchema() {
        String sql = "CREATE SCHEMA IF NOT EXISTS " + schema + ";";

        try(Connection conn = DriverManager.getConnection(url, login, senha)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Schema concluido");
        }catch (SQLException e) {
            System.out.println("Erro ao criar o Schema");
            e.printStackTrace();
        }
    }

    private static void criarTabelas() {
        String sql = "CREATE TABLE IF NOT EXISTS usuario("
                + "nome varchar(100) NOT NULL ,"
                + "email varchar(150) NOT NULL,"
                + "senha varchar(15) NOT NULL,"
                + "PRIMARY KEY(email))";

        try(Connection conn = DriverManager.getConnection(url+schema, login, senha)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Tabela concluida");
        }catch (SQLException e) {
            System.out.println("Erro ao criar a tabela pessoa");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        criarSchema();
        criarTabelas();
    }

}
