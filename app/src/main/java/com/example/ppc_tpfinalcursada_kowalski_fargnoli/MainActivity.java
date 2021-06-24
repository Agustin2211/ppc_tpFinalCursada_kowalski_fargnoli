package com.example.ppc_tpfinalcursada_kowalski_fargnoli;

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

    //Metodo para cambiar a Grupo De Riesgo
    public void grupoDeRiesgo (View view){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }

    //Metodo para cambiar a Informacion Para Pacientes
    public void informacionParaPacientes(View view){
        Intent i = new Intent(this, MainActivity3.class);
        startActivity(i);
    }

    //Metodo para cambiar a "Carga de Datos"
    public void cargaDeDatos(View view){
        Intent i = new Intent(this, MainActivity4.class);
        startActivity(i);
    }
}