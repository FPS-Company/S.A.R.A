package com.example.testetelaesboo.telaPrincipal;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.testetelaesboo.R;
import com.google.android.material.navigation.NavigationView;

public class TelaPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tela_principal);

        //Configuração do fragment do menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // tirar o título da toolbar

        drawer = findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //NavigationView eventos dos fragmentos
        NavigationView Navigationview = findViewById(R.id.nav_view);
        Navigationview.setNavigationItemSelectedListener(this);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_menu_tela_principal, new fragment_inicio()).commit();
            Navigationview.setCheckedItem(R.id.inicio);
        }

        //Intent da tela de Login
        Intent recebetelaprincipal = getIntent();
    }

    //NavigationView event
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.inicio:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_menu_tela_principal, new fragment_inicio()).commit();
                break;
            case R.id.perfil:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_menu_tela_principal, new fragment_perfil()).commit();
                break;
            case R.id.atividades:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_menu_tela_principal, new fragment_atividade()).commit();
                break;
            case R.id.configuracao:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_menu_tela_principal, new fragment_configuracao()).commit();
                break;
            case R.id.contatos:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_menu_tela_principal, new fragment_contatos()).commit();
                break;
            case R.id.grupos:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_menu_tela_principal, new fragment_grupo()).commit();
                break;
            case R.id.sobre:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_menu_tela_principal, new fragment_sobre()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Configuração do fragment do menu evento de saída e entrada
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
