package com.juego.batallas.criaturas;

import com.juego.batallas.abstractas.Criatura;

public class Guerrero extends Criatura {

    private String tipoArmadura;

    public Guerrero(String nombre, int salud, int fuerza, String tipoArmadura) {
        super(nombre, salud, fuerza);
        this.tipoArmadura = tipoArmadura;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int dano = fuerza;

        if (arma != null) {
            arma.atacarConArma(objetivo);
            dano += arma.getDanoAdicional();
        }

        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " con espada y causa " + dano);
        objetivo.defender(dano);
    }

    @Override
    public void defender(int dano) {
        salud -= dano;
        if (salud < 0) salud = 0;

        System.out.println(nombre + " recibió " + dano + ". Salud: " + salud);
    }
}