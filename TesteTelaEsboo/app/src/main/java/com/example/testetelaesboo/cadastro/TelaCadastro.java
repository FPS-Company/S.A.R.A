package com.example.testetelaesboo.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testetelaesboo.R;

public class TelaCadastro extends  AppCompatActivity {

        private EditText telaCadastro_edtNome;
        private EditText telaCadastro_edtEmail;
        private EditText telaCadastro_edtSenha, telaCadastro_edtCSenha;
        private Button telaCadastro_btnCadastro;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_cadastro);
            getSupportActionBar().hide();

            //obter o objeto intent que está clicando em se cadastrar
            Intent recebeTelaLogin = getIntent();

            telaCadastro_edtNome = findViewById(R.id.telaCadastro_edtNome);
            telaCadastro_edtEmail = findViewById(R.id.telaCadastro_edtEmail);
            telaCadastro_edtSenha = findViewById(R.id.telaCadastro_edtSenha);
            telaCadastro_edtCSenha = findViewById(R.id.telaCadastro_edtCSenha);
            telaCadastro_btnCadastro = findViewById(R.id.telaCadastro_btnCadastro);

            telaCadastro_btnCadastro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ValidarCampos();
                }

            });

        }
        private void ValidarCampos(){
            boolean resultadoNome = false;
            boolean resultadoEmail = false;
            boolean resultadoSenha = false;
            boolean resultadoCSenha = false;
            String nome  =  telaCadastro_edtNome.getText().toString();
            String email =  telaCadastro_edtEmail.getText().toString();
            String senha =  telaCadastro_edtSenha.getText().toString();
            String cSenha= telaCadastro_edtCSenha.getText().toString();

            //validação do campo nome
            if(resultadoNome = isCampoVazio(nome)){
                telaCadastro_edtNome.requestFocus();
                Toast.makeText( TelaCadastro.this,"digite um nome", Toast.LENGTH_LONG).show();
            }
//      Validação do campo email
            else if(resultadoEmail = isCampoVazio(email)){
                telaCadastro_edtEmail.requestFocus();
                Toast.makeText( TelaCadastro.this,"Por favo digite um e-mail", Toast.LENGTH_LONG).show();
            }else if(resultadoEmail = !isEmailValidado(email)){
                telaCadastro_edtEmail.requestFocus();
                Toast.makeText( TelaCadastro.this,"email invalido", Toast.LENGTH_LONG).show();
            }
//       Validação dos campos Senha e CSena
            else if(resultadoSenha = isCampoVazio(senha)){
                telaCadastro_edtSenha.requestFocus();
                Toast.makeText( TelaCadastro.this,"Digite uma senha", Toast.LENGTH_LONG).show();
            } else if(resultadoSenha = senha.length()<6){
                telaCadastro_edtSenha.requestFocus();
                Toast.makeText( TelaCadastro.this, "Senha muito fraca" , Toast.LENGTH_LONG).show();
            }
//         Validação do campo cSenha
            else if (!cSenha.equals(senha)) {
                telaCadastro_edtCSenha.requestFocus();
                Toast.makeText( TelaCadastro.this,"Senhas não conferem!", Toast.LENGTH_LONG).show();
                resultadoCSenha = true;
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


