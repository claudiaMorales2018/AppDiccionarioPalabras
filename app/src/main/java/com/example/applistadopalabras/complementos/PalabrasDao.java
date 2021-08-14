package com.example.applistadopalabras.complementos;

public class PalabrasDao {


  public int id;
  public String nombre_palabra;
  public String descripcion_palabra;


    public PalabrasDao() {
    }

    public PalabrasDao(int id, String nombre_palabra, String descripcion_palabra) {
        this.id = id;
        this.nombre_palabra = nombre_palabra;
        this.descripcion_palabra = descripcion_palabra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_palabra() {
        return nombre_palabra;
    }

    public void setNombre_palabra(String nombre_palabra) {
        this.nombre_palabra = nombre_palabra;
    }

    public String getDescripcion_palabra() {
        return descripcion_palabra;
    }

    public void setDescripcion_palabra(String descripcion_palabra) {
        this.descripcion_palabra = descripcion_palabra;
    }
}
