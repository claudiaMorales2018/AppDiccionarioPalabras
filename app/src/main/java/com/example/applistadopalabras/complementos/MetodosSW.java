package com.example.applistadopalabras.complementos;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MetodosSW {


    public static final String IP_SERVER = "http://192.168.0.9/";

    //Implementar variables para la conexion y obtencion de informacion
    Context context;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public MetodosSW() {
    }

    public void consultarSW(Context context, Response.Listener listener,
                            Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"buscadorPalabras/mostrarPalabras.php";
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoC "+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("C----- "+e.getCause()+" --- "+e.getMessage());
        }
    }

}
