package com.example.testetelaesboo.cadastroAtividade;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testetelaesboo.R;

public class CadastroAtividade extends AppCompatActivity {

    //Day buttons
    private ToggleButton tDomingo;
    private ToggleButton tSegunda;
    private ToggleButton tTerca;
    private ToggleButton tQuarta;
    private ToggleButton tQuinta;
    private ToggleButton tSexta;
    private ToggleButton tSabado;
    private EditText Titulo,DataInicio,DataFim,HoraInicio,HoraFim;

    public CadastroAtividade() {
    }

    public CadastroAtividade(EditText titulo, EditText dataInicio, EditText dataFim, EditText horaInicio, EditText horaFim) {
        Titulo = titulo;
        DataInicio = dataInicio;
        DataFim = dataFim;
        HoraInicio = horaInicio;
        HoraFim = horaFim;
    }

    public EditText getTitulo() {
        return Titulo;
    }

    public void setTitulo(EditText titulo) {
        Titulo = titulo;
    }

    public EditText getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(EditText dataInicio) {
        DataInicio = dataInicio;
    }

    public EditText getDataFim() {
        return DataFim;
    }

    public void setDataFim(EditText dataFim) {
        DataFim = dataFim;
    }

    public EditText getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(EditText horaInicio) {
        HoraInicio = horaInicio;
    }

    public EditText getHoraFim() {
        return HoraFim;
    }

    public void setHoraFim(EditText horaFim) {
        HoraFim = horaFim;
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

        Toast.makeText(this, markedButtons, Toast.LENGTH_SHORT).show();

    }



}
