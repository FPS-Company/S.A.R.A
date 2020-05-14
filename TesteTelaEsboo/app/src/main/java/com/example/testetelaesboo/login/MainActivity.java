package com.example.testetelaesboo.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import com.example.testetelaesboo.R;
import com.example.testetelaesboo.api.Retrofit_Service;
import com.example.testetelaesboo.cadastro.TelaCadastro;
import com.example.testetelaesboo.telaPrincipal.TelaPrincipal;
import com.example.testetelaesboo.usuario.usuario;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private Button btnLogin,btn_background_ems_confirma;
    private EditText telaLogin_edtEmail;
    private EditText telaLogin_edtSenha;
    private EditText telaLogin_edtEmail_background_ems;
    private TextView telaLogin_txtEMS,telaLogin_txtCadastro;
    private LinearLayout main_backgound_ems_login,main_backgound_model_ems_login;
    private Animation fromsmall,fromnothing;

    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //Main Activity Componentes
        telaLogin_edtEmail = findViewById(R.id.main_Login_editEmail);
        telaLogin_edtSenha = findViewById(R.id.main_Login_editSenha);
        telaLogin_txtEMS = findViewById(R.id.main_EMS_Login);
        telaLogin_txtCadastro = findViewById(R.id.main_Cadastro_Login);
        btnLogin = findViewById(R.id.main_btnLogin);

       //Esqueci minha senha
        telaLogin_edtEmail_background_ems = findViewById(R.id.main_background_model_ems_editEmail_login);
        btn_background_ems_confirma = findViewById(R.id.main_background_model_ems_btnConfirma_login);
        main_backgound_ems_login = findViewById(R.id.main_background_ems_login);
        main_backgound_model_ems_login = findViewById(R.id.main_background_model_ems_login);
        fromnothing = AnimationUtils.loadAnimation(this,R.anim.fromnothing);
        fromsmall = AnimationUtils.loadAnimation(this,R.anim.fromsmall);
        main_backgound_ems_login.setAlpha(0);
        main_backgound_model_ems_login.setAlpha(0);

        //Eventos
        //Text View
        telaLogin_txtEMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //background EMS
                main_backgound_ems_login.setAlpha(1);
                main_backgound_ems_login.startAnimation(fromnothing);
                //model EMS
                main_backgound_model_ems_login.setAlpha(1);
                main_backgound_model_ems_login.startAnimation(fromsmall);
                //Evento do Confirmar no model
                btn_background_ems_confirma.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewCompat.animate(main_backgound_ems_login).setStartDelay(1000).alpha(0).start();
                        ViewCompat.animate(main_backgound_model_ems_login).setStartDelay(1000).alpha(0).start();
                    }
                });
            }
        });
        telaLogin_txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent Cadastro
                Intent telacadastro = new Intent(MainActivity.this, TelaCadastro.class);
                //ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.anim.fade_in,R.anim.fade_out);
               // ActivityCompat.startActivity(MainActivity.this, telacadastro,compat.toBundle());
               startActivity(telacadastro);
            }
        });
        //Button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                Response response = null;
                    Call<usuario> request = new Retrofit_Service().getSaraApi().selectUsuario(
                        telaLogin_edtEmail.getText().toString(),telaLogin_edtSenha.getText().toString());
                if(ValidarCampos() == true) {
                    request.enqueue(new Callback<usuario>() {
                        @Override
                        public void onResponse(Call<usuario> call, Response<usuario> response) {
                            if(response.isSuccessful()) {
                                Intent Telaprincipal = new Intent(MainActivity.this, TelaPrincipal.class);
                                startActivity(Telaprincipal);
                            }else{
                                Toast.makeText(MainActivity.this,"Há campos inválidos ou usuário não existe!", Toast.LENGTH_LONG).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<usuario>call, Throwable t) {
                            Log.e("GET_ERROR  ", "Erro ao buscar o e-mail e senha:" + t.getMessage());
                        }
                    });
//                        request = new Retrofit_Service().getSaraApi().selectUsuario(telaLogin_edtEmail.getText().toString(),
//                                telaLogin_edtSenha.getText().toString());
//                        response = request.execute();
//    Intent Telaprincipal = new Intent(MainActivity.this, TelaPrincipal.class);
//    startActivity(Telaprincipal);
                    }else{
                        Toast.makeText( MainActivity.this,"Problema ao realizar o cadastro!", Toast.LENGTH_LONG).show();
                    }
            }

        });
    }



    private boolean ValidarCampos(){
        String email =  telaLogin_edtEmail.getText().toString();
        String senha =  telaLogin_edtSenha.getText().toString();

//        if(resultado = isCampoVazio(email)){
//            telaLogin_edtEmail.requestFocus();
//        }else if(resultado = !isEmailValidado(email)){
//            telaLogin_edtEmail.requestFocus();
//        }else if(resultado = isCampoVazio(senha)){
//            telaLogin_edtSenha.requestFocus();
//        }else if(resultado = senha.length()<6){
//            telaLogin_edtSenha.requestFocus(); }
//        if(resultado){
//            Toast.makeText(MainActivity.this,"Há campos inválidos ou em branco!", Toast.LENGTH_LONG).show();

        boolean resultadoEmail = false;
        boolean resultadoSenha = false;

        if(resultadoEmail = isCampoVazio(email)){
            telaLogin_edtEmail.requestFocus();
            Toast.makeText( MainActivity.this,"Por favo digite um e-mail", Toast.LENGTH_LONG).show();
        }else if(resultadoEmail = !isEmailValidado(email)){
            telaLogin_edtEmail.requestFocus();
            Toast.makeText( MainActivity.this,"email invalido", Toast.LENGTH_LONG).show();
        }
        // Validação dos campos Senha e CSena
        else if(resultadoSenha = isCampoVazio(senha)){
            telaLogin_edtSenha.requestFocus();
            Toast.makeText( MainActivity.this,"Digite uma senha", Toast.LENGTH_LONG).show();
        }else if(resultadoSenha = senha.length()<6){
            telaLogin_edtSenha.requestFocus();
            Toast.makeText( MainActivity.this, "Senha muito fraca" , Toast.LENGTH_LONG).show();
        }
        if ((resultadoEmail = true) && ( resultadoSenha =true)){
            return true;
        }else{
            return false;
        }
        }


    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }
    private  boolean isEmailValidado(String email){
        boolean resultado = (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());//Patterns testa padrões
        // específicos(como ips, nome de domínio e afins) utilizando o regex
        return resultado;
    }

}

