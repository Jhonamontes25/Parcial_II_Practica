package com.juego.batallas.abstractas;

import com.juego.batallas.modelos.Arma;

public abstract class Criatura {
    protected String nombre;
    protected int salud;
    protected int fuerza;
    protected Arma arma;

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    public abstract void atacar(Criatura objetivo);

    public abstract void defender(int dano);

    public boolean estaViva() {
        return salud > 0;
    }

    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(nombre + " equipó el arma: " + arma.getNombre());
    }

    public String getNombre() {
        return nombre;
    }
}