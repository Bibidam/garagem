package com.example.garagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirTelaUsu(View view) {
        Intent intent = new Intent(getApplicationContext(),CadastrarUsuario.class);
        startActivity(intent);
    }

    public void abrirTelaSit(View view) {
        Intent intent = new Intent(getApplicationContext(),ListagemUsuarios.class);
        startActivity(intent);
    }
    public void abrirTelaCarro(View view){
        Intent intent = new Intent(getApplicationContext(), ListagemCarro.class);
        startActivity(intent);
    }

    public void abrirTelaMoto(View view) {
        Intent intent = new Intent(getApplicationContext(), ListagemMotos.class);
        startActivity(intent);

    }

    public void abrirCadastroAut(View view) {
        Intent intent = new Intent(getApplicationContext(), CadastroCarroMoto.class);
        startActivity(intent);
    }

    public void abrirDelete(View view) {
        Intent intent = new Intent(getApplicationContext(),Deletar_Algo.class);
        startActivity(intent);

    }
}
