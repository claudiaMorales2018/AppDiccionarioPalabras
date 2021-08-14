package com.example.applistadopalabras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.applistadopalabras.complementos.MetodosSW;
import com.example.applistadopalabras.complementos.PalabrasDao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivityMostrarDiccionario extends AppCompatActivity  implements Response.Listener<JSONObject>, Response.ErrorListener{

    ListView listView;
    ArrayList<String> listaDatos;
    ArrayList<PalabrasDao> listaPalabrasVO;
    MetodosSW metodosSW = new MetodosSW();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar_diccionario);



        listView = findViewById(R.id.lvLitaPalabras);
        metodosSW.consultarSW(this, this, this);


//llenar los datos para la lista


   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           trasladarDatos(position);
       }
   });
    }


    private void resultadoConsultaCompleta(JSONObject response){
        //ClienteVO clienteVO;
        JSONArray jsonArray = response.optJSONArray("tbl_palabras");
        listaPalabrasVO = new ArrayList<>();
        try {
            for(int i=0;i < jsonArray.length(); i++){
                PalabrasDao  palabrasDao = new PalabrasDao();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                palabrasDao.setId(jsonObject.optInt("id"));
                palabrasDao.setNombre_palabra(jsonObject.optString("nombre_palabra"));
                palabrasDao.setDescripcion_palabra(jsonObject.optString("descripcion_palabra"));

                listaPalabrasVO.add(palabrasDao);
            }

            listaDatos = new ArrayList<>();
            for(int i=0;i < listaPalabrasVO.size();i++){
                if(listaPalabrasVO.get(i).getId() != 0) {
                    listaDatos.add(listaPalabrasVO.get(i).getNombre_palabra());
                }
                else {
                    Toast.makeText(this, "Lista Vacia", Toast.LENGTH_SHORT).show();
                }
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
            listView.setAdapter(arrayAdapter);
        }
        catch (Exception e){
            Toast.makeText(this, "Error referente a C****", Toast.LENGTH_LONG).show();
            System.err.println("C----- "+e.getCause()+" --- "+e.getMessage());
        }
    }
    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsultaCompleta(response);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error respuesta a C "+error, Toast.LENGTH_LONG).show();
        System.err.println("C***** "+error);
    }
public void trasladarDatos( int position ){
        String nombre,descripcion;
        nombre= listaPalabrasVO.get(position).getNombre_palabra();
        descripcion = listaPalabrasVO.get(position).getDescripcion_palabra();

        Intent intent = new Intent(getApplicationContext(),MainActivityInformacion.class);
        intent.putExtra("nombre",nombre);
        intent.putExtra("descripcion",descripcion);
        startActivity(intent);
}

}


