package com.example.navdrawer;

import java.io.Serializable;

public class Ubicacion implements Serializable {
    private float longitud;
    private float latitud;
    private String nombre;

    Ubicacion(float longitud, float latitud, String nombre) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.nombre = nombre;
    }


    public float getLon() {
        return longitud;
    }

//    public void setLon(float longitud) {
//        this.longitud = longitud;
//    }

    public float getLat() {
        return latitud;
    }

//    public void setLat(float latitud) {
//        this.latitud = latitud;
//    }

    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }
}