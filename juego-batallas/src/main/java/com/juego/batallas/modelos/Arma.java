package com.juego.batallas.modelos;

import com.juego.batallas.abstractas.Criatura;

public class Arma {
    private String nombre;
    private int danoAdicional;

    public Arma(String nombre, int danoAdicional) {
        this.nombre = nombre;
        this.danoAdicional = danoAdicional;
    }

    public void atacarConArma(Criatura objetivo) {
        System.out.println("El arma " + nombre + " causa " + danoAdicional + " de daño adicional a " + objetivo.getNombre());
    }

    public int getDanoAdicional() {
        return danoAdicional;
    }

    public String getNombre() {
        return nombre;
    }
}