package com.example.testetelaesboo.cadastroAtividade;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testetelaesboo.R;
import com.example.testetelaesboo.api.Retrofit_Service;
import com.example.testetelaesboo.cadastro.TelaCadastro;
import com.example.testetelaesboo.usuario.usuario;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class CadastroAtividade extends AppCompatActivity {

    //Day buttons
    private ToggleButton tDomingo;
    private ToggleButton tSegunda;
    private ToggleButton tTerca;
    private ToggleButton tQuarta;
    private ToggleButton tQuinta;
    private ToggleButton tSexta;
    private ToggleButton tSabado;
    private EditText cadastroAtividade_edtTitulo, cadastroAtividade_edtDataInicio, cadastroAtividade_edtDataFim, cadastroAtividade_edtHoraInicio, cadastroAtividade_edtHoraFim;
    private Button cadastroAtividade_btnCadastroAtividade;

    public CadastroAtividade() {
    }

    public CadastroAtividade(EditText cadastroAtividade_edtTitulo, EditText cadastroAtividade_edtDataInicio, EditText cadastroAtividade_edtDataFim, EditText cadastroAtividade_edtHoraInicio, EditText cadastroAtividade_edtHoraFim) {
        this.cadastroAtividade_edtTitulo = cadastroAtividade_edtTitulo;
        this.cadastroAtividade_edtDataInicio = cadastroAtividade_edtDataInicio;
        this.cadastroAtividade_edtDataFim = cadastroAtividade_edtDataFim;
        this.cadastroAtividade_edtHoraInicio = cadastroAtividade_edtHoraInicio;
        this.cadastroAtividade_edtHoraFim = cadastroAtividade_edtHoraFim;
    }

    public EditText getCadastroAtividade_edtTitulo() {
        return cadastroAtividade_edtTitulo;
    }

    public void setCadastroAtividade_edtTitulo(EditText cadastroAtividade_edtTitulo) {
        this.cadastroAtividade_edtTitulo = cadastroAtividade_edtTitulo;
    }

    public EditText getCadastroAtividade_edtDataInicio() {
        return cadastroAtividade_edtDataInicio;
    }

    public void setCadastroAtividade_edtDataInicio(EditText cadastroAtividade_edtDataInicio) {
        this.cadastroAtividade_edtDataInicio = cadastroAtividade_edtDataInicio;
    }

    public EditText getCadastroAtividade_edtDataFim() {
        return cadastroAtividade_edtDataFim;
    }

    public void setCadastroAtividade_edtDataFim(EditText cadastroAtividade_edtDataFim) {
        this.cadastroAtividade_edtDataFim = cadastroAtividade_edtDataFim;
    }

    public EditText getCadastroAtividade_edtHoraInicio() {
        return cadastroAtividade_edtHoraInicio;
    }

    public void setCadastroAtividade_edtHoraInicio(EditText cadastroAtividade_edtHoraInicio) {
        this.cadastroAtividade_edtHoraInicio = cadastroAtividade_edtHoraInicio;
    }

    public EditText getCadastroAtividade_edtHoraFim() {
        return cadastroAtividade_edtHoraFim;
    }

    public void setCadastroAtividade_edtHoraFim(EditText cadastroAtividade_edtHoraFim) {
        this.cadastroAtividade_edtHoraFim = cadastroAtividade_edtHoraFim;
    }

    @Override
    protected void onCreate(Bundle SavedInstance){
        super.onCreate(SavedInstance);
        setContentView(R.layout.activity_main_cadastro_atividade);
        getSupportActionBar().hide();

        tDomingo = (ToggleButton) findViewById(R.id.daypicker_tDomingo);
        tSegunda = (ToggleButton) findViewById(R.id.daypicker_tSegunda);
        tTerca   = (ToggleButton) findViewById(R.id.daypicker_tTerca);
        tQuarta  = (ToggleButton) findViewById(R.id.daypicker_tQuarta);
        tQuinta  = (ToggleButton) findViewById(R.id.daypicker_tQuinta);
        tSexta   = (ToggleButton) findViewById(R.id.daypicker_tSexta);
        tSabado  = (ToggleButton) findViewById(R.id.daypicker_tSabado);

        cadastroAtividade_edtTitulo = findViewById(R.id.cadastroAtividade_edtTitulo);
        cadastroAtividade_edtDataInicio = findViewById(R.id.cadastroAtividade_edtDataInicio);
        cadastroAtividade_edtDataFim = findViewById(R.id.cadastroAtividade_edtDataFim);
        cadastroAtividade_edtHoraInicio = findViewById(R.id.cadastroAtividade_edtHoraInicio);
        cadastroAtividade_edtHoraFim = findViewById(R.id.cadastroAtividade_edtHoraFim);
        cadastroAtividade_btnCadastroAtividade = findViewById(R.id.cadastroAtividade_btnCadastroAtividade);

//        evento do Button (cadastroAtividade_btnCadastroAtividade)
        cadastroAtividade_btnCadastroAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response response = null;
                Call<CadastroAtividade> request = null;
                try  {
                    if(ValidarCampos() == true){
                        // novo cadastro
                        // POST na API sem enviar o id que será gerado no banco
                        request = new Retrofit_Service().getSaraApi().CadastroAtividade(cadastroAtividade_edtTitulo.getText().toString(),
                                cadastroAtividade_edtDataInicio.getText().toString(), cadastroAtividade_edtDataFim.getText().toString(),
                                cadastroAtividade_edtHoraInicio.getText().toString(), cadastroAtividade_edtHoraFim.getText().toString());
                        response = request.execute();
                    }else{
                        Toast.makeText( CadastroAtividade.this,"Problema ao realizar o cadastro!", Toast.LENGTH_LONG).show();
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                    Log.e("ERRO", e.getMessage());
                }
            }
        });


        String markedButtons= "";
        //Check individual items.
        if(tDomingo.isChecked()){
            markedButtons +="Domingo,";
        }
        if(tSegunda.isChecked()){
            markedButtons +="Segunda,";
        }
        if(tTerca.isChecked()){
            markedButtons +="Terca,";
        }
        if(tQuarta.isChecked()){
            markedButtons +="Qarta,";
        }
        if(tQuinta.isChecked()){
            markedButtons +="Quinta,";
        }
        if(tSexta.isChecked()){
            markedButtons +="Sexta,";
        }
        if(tSabado.isChecked()){
            markedButtons +="Sabado";
        }

    }

    private boolean ValidarCampos(){
        boolean resultadoTitulo = false;
        boolean resultadoDataInicio = false;
        boolean resultadoDataFim = false;
        boolean resultadoHoraInicio = false;
        boolean resultadoHoraFim = false;

        String titulo  =  cadastroAtividade_edtTitulo.getText().toString();
        String dataInicio =  cadastroAtividade_edtDataInicio.getText().toString();
        String dataFim =  cadastroAtividade_edtDataFim.getText().toString();
        String horaInicio= cadastroAtividade_edtHoraInicio.getText().toString();
        String horaFim= cadastroAtividade_edtHoraFim.getText().toString();

        //validação do campo titulo
        if(resultadoTitulo = isCampoVazio(titulo)){
            cadastroAtividade_edtTitulo.requestFocus();
            Toast.makeText( CadastroAtividade.this,"digite um nome", Toast.LENGTH_LONG).show();
        }
        // Validação do campo dataInicio
        else if(resultadoDataInicio = isCampoVazio(dataInicio)){
            cadastroAtividade_edtDataInicio.requestFocus();
            Toast.makeText( CadastroAtividade.this,"Por favo digite um e-mail", Toast.LENGTH_LONG).show();
        }
        // Validação dos campos dataFim
        else if(resultadoDataFim = isCampoVazio(dataFim)){
            cadastroAtividade_edtDataFim.requestFocus();
            Toast.makeText( CadastroAtividade.this,"Digite uma senha", Toast.LENGTH_LONG).show();
        }
        // Validação dos campos horaInicio
        else if(resultadoHoraInicio = isCampoVazio(horaInicio)){
            cadastroAtividade_edtHoraInicio.requestFocus();
            Toast.makeText( CadastroAtividade.this,"Digite uma senha", Toast.LENGTH_LONG).show();
        }
        // Validação dos campos horaFim
        else if(resultadoHoraFim = isCampoVazio(horaFim)){
            cadastroAtividade_edtHoraFim.requestFocus();
            Toast.makeText( CadastroAtividade.this,"Digite uma senha", Toast.LENGTH_LONG).show();
        }
//        checa se a validacao esta ok
        if ((resultadoTitulo = true) && (resultadoDataInicio = true) && ( resultadoDataFim =true) && (resultadoHoraInicio = true) && (resultadoHoraFim = true)){
            return true;
        }else{
            return false;
        }
    }

    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }



}
