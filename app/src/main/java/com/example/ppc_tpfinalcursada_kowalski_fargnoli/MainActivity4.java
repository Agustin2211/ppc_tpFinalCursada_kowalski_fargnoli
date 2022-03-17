package com.example.ppc_tpfinalcursada_kowalski_fargnoli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioButton SI;
    RadioButton NO;

    Boolean buleano;

    EditText textoPaciente;
    EditText riesgoRecurrente;
    EditText riesgoProgreso;

    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textoPaciente = (EditText)findViewById(R.id.textoPaciente);
        riesgoRecurrente = (EditText)findViewById(R.id.riesgoRecurrente);
        riesgoProgreso = (EditText)findViewById(R.id.riesgoProgeso);

        String textoPacienteString = textoPaciente.getText().toString();
        String riesgoRecurrenteString = riesgoRecurrente.getText().toString();
        String riesgoProgresoString = riesgoProgreso.getText().toString();


        RadioGroup SIoNO = findViewById(R.id.radioGroup);
        SI = findViewById(R.id.si);
        NO = findViewById(R.id.no);

        SIoNO.setOnCheckedChangeListener(this);

        calcular = findViewById(R.id.calcular4);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity4.this, MainActivity5.class);
                i.putExtra("riesgoRecurrente", riesgoRecurrenteString);
                i.putExtra("riesgoProgreso", riesgoProgresoString);
                i.putExtra("buleano", buleano);

                SharedPreferences preferencesBoton = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencesBoton.edit();
                editor.putString("textoPaciente", textoPaciente.getText().toString());
                editor.putString("riesgoRecurrente", riesgoRecurrente.getText().toString());
                editor.putString("riesgoProgreso", riesgoProgreso.getText().toString());

                editor.commit();

                startActivity(i);
            }
        });

        EditText editText = findViewById(R.id.riesgoRecurrente);
        editText.setFilters(new InputFilter[]{ new InputFilterMinMax("1" , "10")});

        EditText editText1 = findViewById(R.id.riesgoProgeso);
        editText1.setFilters(new InputFilter[]{ new InputFilterMinMax("1" , "10")});


        //GUARDAR INFORMACION
        SharedPreferences preferencesPaciente = getSharedPreferences("datos", Context.MODE_PRIVATE);
        textoPaciente.setText(preferencesPaciente.getString("textoPaciente", ""));
        SharedPreferences preferencesRiesgoRecurrente = getSharedPreferences("datos", Context.MODE_PRIVATE);
        riesgoRecurrente.setText(preferencesRiesgoRecurrente.getString("riesgoRecurrente", ""));
        SharedPreferences preferencesRiesgoProgreso = getSharedPreferences("datos", Context.MODE_PRIVATE);
        riesgoProgreso.setText(preferencesRiesgoProgreso.getString("riesgoProgreso", ""));


        /*BOTONES DEL FOOTER*/
        Button inicio = findViewById(R.id.inicioFooter4);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        Button grupoDeRiesgo = findViewById(R.id.grupoDeRiesgoFooter4);
        grupoDeRiesgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity2.class);
                startActivity(i);
            }
        });

        Button infoPaciente = findViewById(R.id.infoPacienteFooter4);
        infoPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity3.class);
                startActivity(i);
            }
        });

    }

    public void onCheckedChanged(RadioGroup arg0, int arg1){
        if (SI.isChecked()){
            buleano = Boolean.TRUE;
        }else{
            buleano = Boolean.FALSE;
        }
    }

}