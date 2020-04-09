package com.example.testetelaesboo.cadastro;


import com.example.testetelaesboo.usuario.usuario;

import java.util.List;

    public interface genericDAO<T> {

        void inserir(T elemento);
        void alterar(T elemento);
        List<T> listar();
        void deletar(T elemento);
    }

