package com.example.ppc_tpfinalcursada_kowalski_fargnoli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        String url = "http://ppc2021.edit.com.ar/service/api/info";
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

