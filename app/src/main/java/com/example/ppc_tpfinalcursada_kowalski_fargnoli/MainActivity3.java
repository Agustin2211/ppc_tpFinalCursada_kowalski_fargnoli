package com.example.ppc_tpfinalcursada_kowalski_fargnoli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity3 extends AppCompatActivity {

    Button compartir1, compartir2, compartir3, compartir4, compartir5;
    ImageView imagen1, imagen2, imagen3, imagen4, imagen5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        compartir1 = findViewById(R.id.compartir1);
        imagen1 = findViewById(R.id.imageView);

        compartir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Drawable drawable = imagen1.getDrawable();
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

                try {

                    File file = new File(getApplicationContext().getExternalCacheDir(), bitmap + ".jpg");
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID + ".provider", file);

                    intent.putExtra(Intent.EXTRA_STREAM, photoURI);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setType("image/jpg");

                    startActivity(Intent.createChooser(intent, "Compartir Imagen Via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        compartir2 = findViewById(R.id.compartir2);
        imagen2 = findViewById(R.id.imageView2);

        compartir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Drawable drawable = imagen2.getDrawable();
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

                try {
                    File file = new File(getApplicationContext().getExternalCacheDir(), bitmap + ".jpg");
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID + ".provider", file);

                    intent.putExtra(Intent.EXTRA_STREAM, photoURI);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setType("image/jpg");

                    startActivity(Intent.createChooser(intent, "Compartir Imagen Via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        compartir3 = findViewById(R.id.compartir3);
        imagen3 = findViewById(R.id.imageView3);

        compartir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Drawable drawable = imagen3.getDrawable();
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

                try {
                    File file = new File(getApplicationContext().getExternalCacheDir(), bitmap + ".jpg");
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID + ".provider", file);

                    intent.putExtra(Intent.EXTRA_STREAM, photoURI);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setType("image/jpg");

                    startActivity(Intent.createChooser(intent, "Compartir Imagen Via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        compartir4 = findViewById(R.id.compartir4);
        imagen4 = findViewById(R.id.imageView4);

        compartir4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Drawable drawable = imagen4.getDrawable();
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

                try {
                    File file = new File(getApplicationContext().getExternalCacheDir(), bitmap + ".jpg");
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID + ".provider", file);

                    intent.putExtra(Intent.EXTRA_STREAM, photoURI);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setType("image/jpg");

                    startActivity(Intent.createChooser(intent, "Compartir Imagen Via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        compartir5 = findViewById(R.id.compartir5);
        imagen5 = findViewById(R.id.imageView5);

        compartir5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = imagen5.getDrawable();
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

                try {
                    File file = new File(getApplicationContext().getExternalCacheDir(), bitmap + ".jpg");
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID + ".provider", file);

                    intent.putExtra(Intent.EXTRA_STREAM, photoURI);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setType("image/jpg");

                    startActivity(Intent.createChooser(intent, "Compartir Imagen Via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        /*BOTONES DEL FOOTER*/
        Button inicio = findViewById(R.id.inicioFooter3);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        Button grupoDeRiesgo = findViewById(R.id.grupoDeRiesgoFooter3);
        grupoDeRiesgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity2.class);
                startActivity(i);
            }
        });

        Button infoPaciente = findViewById(R.id.cargaDeDatos3);
        infoPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity4.class);
                startActivity(i);
            }
        });

    }
}