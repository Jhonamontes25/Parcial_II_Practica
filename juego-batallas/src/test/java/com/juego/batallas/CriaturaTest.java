package com.juego.batallas;

import com.juego.batallas.criaturas.Dragon;
import com.juego.batallas.criaturas.Guerrero;
import com.juego.batallas.criaturas.Mago;
import com.juego.batallas.modelos.Arma;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CriaturaTest {

    @Test
    public void testEstaViva() {
        Guerrero g = new Guerrero("Thor", 100, 15, "Pesada");
        assertTrue(g.estaViva());
    }

    @Test
    public void testDefenderReduceSalud() {
        Guerrero g = new Guerrero("Thor", 100, 15, "Pesada");
        g.defender(30);
        assertEquals(70, g.getSalud());
    }

    @Test
    public void testEquiparArma() {
        Guerrero g = new Guerrero("Thor", 100, 15, "Pesada");
        Arma espada = new Arma("Espada", 10);

        g.equiparArma(espada);

        assertNotNull(g.getArma());
        assertEquals("Espada", g.getArma().getNombre());
    }

    @Test
    public void testDragonHaceDanio() {
        Dragon d = new Dragon("Draco", 120, 20, "Rojas");
        Guerrero g = new Guerrero("Thor", 100, 15, "Pesada");

        d.atacar(g);

        assertTrue(g.getSalud() < 100);
    }

    @Test
    public void testMagoAprendeHechizo() {
        Mago m = new Mago("Merlin", 90, 18);

        m.aprenderHechizo("Fuego");

        assertEquals(1, m.getHechizos().size());
    }
}