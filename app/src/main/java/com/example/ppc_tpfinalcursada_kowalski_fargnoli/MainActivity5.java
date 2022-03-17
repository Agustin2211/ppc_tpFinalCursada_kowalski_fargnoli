package com.example.ppc_tpfinalcursada_kowalski_fargnoli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.BuildConfig;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity5 extends AppCompatActivity {

    RequestQueue mRequestQueue;
    ImageLoader mImageLoader;
    NetworkImageView imagenDeLaApi;
    Double riesgoRecurrente;
    Double riesgoProgreso;
    Boolean buleano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        recibirDatos();

        String url = "https://ppc2021.edit.com.ar/service/api/imagen/" + riesgoRecurrente + "/" + riesgoProgreso + "/" + buleano;
        String urlQueDaLaApi = "https://ppc2021.edit.com.ar/resources/images/Calculadora1.jpeg";

        //FORMA 1 (RequestQueue)
        mRequestQueue = Volley.newRequestQueue(MainActivity5.this);
        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
            @Override
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
        });

        imagenDeLaApi = findViewById(R.id.imagenDeLaAPI);
        imagenDeLaApi.setImageUrl(urlQueDaLaApi, mImageLoader);


        /*FORMA 2 (ImageLoader)
        imagenDeLaApi = (NetworkImageView) findViewById(R.id.imagenDeLaAPI);
        mImageLoader = MySingleton.getInstance(this).getImageLoader();
        imagenDeLaApi.setImageUrl(url, mImageLoader);

         */

        /*FORMA 3 (ImageRequest)
        ImageView mImageView = (ImageView) findViewById(R.id.imageView6);
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    public void onResponse(Bitmap bitmap) {
                        mImageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        //mImageView.setImageResource(R.drawable.image_load_error);
                    }});
        MySingleton.getInstance(this).addToRequestQueue(request);
        */

        Button compatir = findViewById(R.id.compartir_layout5);
        compatir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = imagenDeLaApi.getDrawable();
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

        Button atras = findViewById(R.id.atras5);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity4.class);
                startActivity(i);
            }
        });

        /*BOTONES DEL FOOTER*/
        Button inicio = findViewById(R.id.inicioFooter5);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        Button grupoDeRiesgo = findViewById(R.id.grupoDeRiesgoFooter5);
        grupoDeRiesgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity2.class);
                startActivity(i);
            }
        });

        Button infoPaciente = findViewById(R.id.infoPacienteFooter5);
        infoPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity3.class);
                startActivity(i);
            }
        });
    }

    private void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        riesgoRecurrente = extras.getDouble("riesgoRecurrente");
        riesgoProgreso = extras.getDouble("riesgoProgreso");
        buleano = extras.getBoolean("buleano");
    }

}