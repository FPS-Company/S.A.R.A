package com.example.testetelaesboo.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testetelaesboo.R;
import com.example.testetelaesboo.cadastro.TelaCadastro;


public class MainActivity extends AppCompatActivity {
    private Button btnLogin,btnteste;
    private EditText telaLogin_edtEmail;
    private EditText telaLogin_edtSenha;
    private TextView telaLogin_txtEMS,telaLogin_txtCadastro;

    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        telaLogin_edtEmail = findViewById(R.id.main_Login_editEmail);
        telaLogin_edtSenha = findViewById(R.id.main_Login_editSenha);
        telaLogin_txtEMS = findViewById(R.id.main_EMS_Login);
        telaLogin_txtCadastro = findViewById(R.id.main_Cadastro_Login);
        btnLogin = findViewById(R.id.main_btnLogin);

        telaLogin_txtEMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Vai criar um Model de mudar senha", Toast.LENGTH_LONG).show();
            }
        });
        telaLogin_txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent Cadastro
                Intent telacadastro = new Intent(MainActivity.this, TelaCadastro.class);
                startActivity(telacadastro);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarCampos();
            }
        });
    }

    private void ValidarCampos(){
        boolean resultado = false;
        String email =  telaLogin_edtEmail.getText().toString();
        String senha =  telaLogin_edtSenha.getText().toString();

        if(resultado = isCampoVazio(email)){
            telaLogin_edtEmail.requestFocus();
        }else if(resultado = !isEmailValidado(email)){
            telaLogin_edtEmail.requestFocus();
        }else if(resultado = isCampoVazio(senha)){
            telaLogin_edtSenha.requestFocus();
        }else if(resultado = senha.length()<6){
            telaLogin_edtSenha.requestFocus(); }
        if(resultado){
            Toast.makeText(MainActivity.this,"Há campos inválidos ou em branco!", Toast.LENGTH_LONG).show();
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
