package com.juego.batallas;

import java.util.Scanner;

import com.juego.batallas.abstractas.Criatura;
import com.juego.batallas.criaturas.Dragon;
import com.juego.batallas.criaturas.Guerrero;
import com.juego.batallas.criaturas.Mago;
import com.juego.batallas.modelos.Arma;

public class Main {

    public static String generarBarraVida(int salud) {
        int cubos = (int) Math.ceil(salud / 20.0);
        String barra = "";

        for (int i = 0; i < cubos; i++) {
            barra += "■ ";
        }

        return barra.trim();
    }

    public static void mostrarEstadoCriatura(Criatura criatura) {
        String tipo = criatura.getClass().getSimpleName();
        String armaEquipada = (criatura.getArma() != null)
                ? criatura.getArma().getNombre()
                : "Sin arma";

        System.out.println("Clase: " + tipo);
        System.out.println("Nombre: " + criatura.getNombre());
        System.out.println("Salud: " + criatura.getSalud() + " " + generarBarraVida(criatura.getSalud()));
        System.out.println("Fuerza: " + criatura.getFuerza());
        System.out.println("Arma equipada: " + armaEquipada);
        System.out.println("-----------------------------------");
    }

    public static void mostrarVidaActual(Criatura c1, Criatura c2) {
        System.out.println("\nEstado actual:");
        System.out.println(c1.getNombre() + ": " + c1.getSalud() + " " + generarBarraVida(c1.getSalud()));
        System.out.println(c2.getNombre() + ": " + c2.getSalud() + " " + generarBarraVida(c2.getSalud()));
    }

    public static void simularBatalla(Criatura c1, Criatura c2) {

        System.out.println("\n===== INICIO DE LA BATALLA =====");

        System.out.println("\n--- ESTADISTICAS ---");
        mostrarEstadoCriatura(c1);
        mostrarEstadoCriatura(c2);

        int turno = 1;

        while (c1.estaViva() && c2.estaViva()) {
            System.out.println("\n--- TURNO " + turno + " ---");

            c1.atacar(c2);

            if (c2.estaViva()) {
                c2.atacar(c1);
            }

            mostrarVidaActual(c1, c2);

            turno++;
        }

        System.out.println("\n===== FIN =====");

        if (c1.estaViva()) {
            System.out.println("GANADOR: " + c1.getNombre());
        } else {
            System.out.println("GANADOR: " + c2.getNombre());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SISTEMA DE BATALLAS =====");
        System.out.println("1. Dragon vs Guerrero");
        System.out.println("2. Mago vs Dragon");
        System.out.println("3. Guerrero vs Mago");
        System.out.print("Seleccione una opcion: ");

        int opcion = sc.nextInt();

        Criatura c1 = null;
        Criatura c2 = null;

        // Crear armas
        Arma espada = new Arma("Espada", 10);
        Arma baston = new Arma("Baston", 8);
        Arma garra = new Arma("Garra", 6);

        switch (opcion) {

            case 1:
                c1 = new Dragon("Draco", 120, 20, "Escamas rojas");
                c2 = new Guerrero("Thor", 110, 15, "Pesada");

                c1.equiparArma(garra);
                c2.equiparArma(espada);

                break;

            case 2:
                c1 = new Mago("Merlin", 90, 18);
                c2 = new Dragon("Draco", 120, 20, "Escamas rojas");

                c1.equiparArma(baston);
                c2.equiparArma(garra);

                ((Mago) c1).aprenderHechizo("Bola de fuego");

                break;

            case 3:
                c1 = new Guerrero("Thor", 110, 15, "Pesada");
                c2 = new Mago("Merlin", 90, 18);

                c1.equiparArma(espada);
                c2.equiparArma(baston);

                ((Mago) c2).aprenderHechizo("Rayo");

                break;

            default:
                System.out.println("Opcion invalida");
                sc.close();
                return;
        }

        simularBatalla(c1, c2);

        sc.close();
    }
}