package com.example.testetelaesboo.cadastro;


import java.util.List;

public interface genericDAO {



    public interface GenericDAO<T> {

        void inserir(T elemento);
        void alterar(T elemento);
        List<T> listar();
        void deletar(T elemento);

    }
}
