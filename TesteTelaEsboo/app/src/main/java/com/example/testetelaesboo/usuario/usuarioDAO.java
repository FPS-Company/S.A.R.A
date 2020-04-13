package com.example.testetelaesboo.usuario;

import com.example.testetelaesboo.banco_de_dados.connectionFactory;
import com.example.testetelaesboo.banco_de_dados.genericDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuarioDAO implements genericDAO<usuario> {

    
    @Override
    public void inserir(usuario elemento) {

        String sql = "INSERT INTO pessoa_fisica (nome, email,senha) VALUES (?,?,?,?,?)";

        try(Connection conn = new connectionFactory().getConnection()){
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, elemento.getNome());
            psmt.setString(2, elemento.getEmail());
            psmt.setString(5, elemento.getSenha());
            psmt.execute();
            System.out.println("Inseriu com sucesso uma pessoa física!");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao inserir uma pessoa física!");
        }

    }

    @Override
    public void alterar(usuario elemento) {
        String sql = "UPDATE usuarios SET nome=?, email=? WHERE emai=?";
        try(Connection conn = new connectionFactory().getConnection()){
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, elemento.getNome());
            psmt.setString(3, elemento.getEmail());
            psmt.execute();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao alterar uma pessoa");
        }

    }

    @Override
    public List<usuario> listar() {
        List<usuario> usuarios = new ArrayList<usuario>();
        String sql = "SELECT * FROM usuarios";
        try(Connection conn = new connectionFactory().getConnection()) {
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()) {
                usuario us = new usuario();
                us.setNome(rs.getString("nome"));
                us.setEmail(rs.getString("email"));
                usuarios.add(us);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao listar pessoas!");
        }


        return usuarios;
    }

    @Override
    public void deletar(usuario elemento) {
        String sql = "DELETE FROM usuarios WHERE email=?";
        try(Connection conn = new connectionFactory().getConnection()){
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.execute();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao deletar uma pessoa");
        }

    }
}




