package com.example.testetelaesboo.cadastroAtividade;

import android.os.Bundle;
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
