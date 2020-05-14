package com.example.testetelaesboo.api;

import com.example.testetelaesboo.cadastroAtividade.CadastroAtividade;
import com.example.testetelaesboo.usuario.usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Sara_Api {
//    @POST("Usuarios")
//    Call<usuario> CadastroUsuario(String cadastroUsuario);

    @FormUrlEncoded
    @POST("Usuarios")
    Call<usuario> CadastroUsuario(@Field("nome") String nome, @Field("email") String email, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("Atividade")
    Call<CadastroAtividade> CadastroAtividade(@Field("titulo") String titulo, @Field("dataInicio") String dataInicio, @Field("dataFim") String dataFim, @Field("horaInicio") String horaInicio, @Field("horaFim") String horaFim);


}

