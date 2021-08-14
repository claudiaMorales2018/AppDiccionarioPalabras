package com.example.applistadopalabras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.applistadopalabras.complementos.PalabrasDao;

import java.util.ArrayList;

public class MainActivityInformacion extends AppCompatActivity {

    private TextView palabra,contenido;
    private PalabrasDao lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_informacion);

     //   lista= getIntent().getParcelableExtra("lista");

       palabra= findViewById(R.id.palabra);
       contenido=findViewById(R.id.contenido);

     obtenerDatos();

     //  palabra.setText(lista.getNombre_palabra());
    //   contenido.setText(lista.getDescripcion_palabra());



    }
    public void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        String descripcion = bundle.getString("descripcion");

        palabra.setText(nombre);
        contenido.setText(descripcion);

    }
}