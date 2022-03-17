package com.example.ppc_tpfinalcursada_kowalski_fargnoli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textoTraidoDeLaAPI);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://ppc2021.edit.com.ar/service/api/info";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    textView.setText("El Textro Traido De La API Es: " + response);
                    System.out.println(response.toString());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    textView.setText("Error, parece que algo falló");
                }
            });

        queue.add(stringRequest);

        /*BOTONES DEL FOOTER*/
        Button inicio = findViewById(R.id.inicioFooter2);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        Button cargarDatos = findViewById(R.id.cargaDeDatos2);
        cargarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity4.class);
                startActivity(i);
            }
        });

        Button infoPaciente = findViewById(R.id.infoPacienteFooter2);
        infoPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity3.class);
                startActivity(i);
            }
        });
    }


    public void Calcular (View view){
        Intent i = new Intent(this, MainActivity4.class);
        startActivity(i);
    }



    public void Atras (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}

