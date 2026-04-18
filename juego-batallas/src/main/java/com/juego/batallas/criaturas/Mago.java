package com.juego.batallas.criaturas;

import com.juego.batallas.abstractas.Criatura;
import com.juego.batallas.interfaces.Magico;
import java.util.ArrayList;
import java.util.List;

public class Mago extends Criatura implements Magico {

    private List<String> hechizos;

    public Mago(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
        this.hechizos = new ArrayList<>();
    }
    public List<String> getHechizos() {
    return hechizos;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int dano = fuerza;

        if (arma != null) {
            arma.atacarConArma(objetivo);
            dano += arma.getDanoAdicional();
        }

        lanzarHechizo();
        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " con magia y causa " + dano);
        objetivo.defender(dano);
    }

    @Override
    public void defender(int dano) {
        salud -= dano;
        if (salud < 0) salud = 0;

        System.out.println(nombre + " recibió " + dano + ". Salud: " + salud);
    }

    @Override
    public void lanzarHechizo() {
        if (hechizos.isEmpty()) {
            System.out.println(nombre + " lanzó un hechizo básico.");
        } else {
            System.out.println(nombre + " lanzó: " + hechizos.get(0));
        }
    }

    @Override
    public void aprenderHechizo(String hechizo) {
        hechizos.add(hechizo);
        System.out.println(nombre + " aprendió: " + hechizo);
    }
}