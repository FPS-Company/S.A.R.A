package com.example.testetelaesboo.telaPrincipal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testetelaesboo.R;
import com.example.testetelaesboo.cadastroAtividade.CadastroAtividade;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class fragment_inicio extends Fragment {

    private FloatingActionButton fragment_FloatingActionButton;

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_tela_principal_menu_inicio,container,false);

       fragment_FloatingActionButton = view.findViewById(R.id.fragment_menu_tela_principal_inicio_floatingAction);
       fragment_FloatingActionButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Intent intent = new Intent(getActivity(), CadastroAtividade.class);
               startActivity(intent);
            }
        });
       return view;
    }
}
