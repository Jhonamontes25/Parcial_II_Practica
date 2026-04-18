package com.juego.batallas.criaturas;

import com.juego.batallas.abstractas.Criatura;
import com.juego.batallas.interfaces.Volador;

public class Dragon extends Criatura implements Volador {

    private String escamas;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int dano = fuerza * 2;

        if (arma != null) {
            arma.atacarConArma(objetivo);
            dano += arma.getDanoAdicional();
        }

        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " con fuego y causa " + dano + " de daño.");
        objetivo.defender(dano);
    }

    @Override
    public void defender(int dano) {
        salud -= dano;
        if (salud < 0) salud = 0;

        System.out.println(nombre + " recibió " + dano + " de daño. Salud: " + salud);
    }

    @Override
    public void volar() {
        System.out.println(nombre + " está volando ");
    }

    @Override
    public void aterrizar() {
        System.out.println(nombre + " aterrizó.");
    }
}