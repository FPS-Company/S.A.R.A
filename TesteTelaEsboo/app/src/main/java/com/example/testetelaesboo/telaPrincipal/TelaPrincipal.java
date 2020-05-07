package com.example.testetelaesboo.telaPrincipal;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testetelaesboo.R;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tela_principal);
       getSupportActionBar().hide();


        Intent recebetelaprincipal = getIntent();
    }
}
