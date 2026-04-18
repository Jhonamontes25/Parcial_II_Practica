# Parcial II - Práctica de Programación Orientada a Objetos

Este proyecto fue desarrollado como parte del Parcial II de la asignatura de Programación II. La idea principal es aplicar los conceptos vistos en clase mediante la simulación de combates entre distintas criaturas.

Más que un programa simple, se buscó construir una pequeña lógica de juego donde cada criatura tiene características propias y donde el sistema gestiona los turnos, ataques y estados de vida.

---

## ¿De qué trata el proyecto?

El sistema permite simular batallas entre criaturas como guerreros, magos y dragones, cada uno con habilidades y estadísticas diferentes.

Durante la ejecución se puede:

- Ver las estadísticas iniciales de cada criatura  
- Simular combates por turnos  
- Mostrar la vida actual después de cada acción  
- Representar visualmente la vida (por ejemplo, con bloques o "cubos")  
- Equipar objetos a las criaturas  
- Seleccionar diferentes combinaciones de batalla  

La idea fue hacerlo lo más dinámico posible, no solo cumplir con el punto, sino que se sintiera como un sistema real.

---

## Objetivo del trabajo

Aplicar de manera práctica los siguientes conceptos:

- Programación Orientada a Objetos (POO)  
- Uso de clases y objetos  
- Herencia entre clases de criaturas  
- Polimorfismo en ataques y comportamientos  
- Encapsulamiento de atributos  
- Organización del código en un proyecto Maven  

---

## ¿Cómo está pensado el sistema?

El sistema gira alrededor de una clase base llamada **Criatura**, de la cual heredan los distintos tipos:

- Guerrero 
- Mago 
- Dragón 

Cada uno redefine su forma de atacar o comportarse en combate.

También se implementan interfaces para representar habilidades especiales como:

- Magia  
- Vuelo  

Además, existe una lógica de batalla que controla:

- Turnos  
- Daño aplicado  
- Estado de vida  
- Fin del combate  

---

## Diagrama de clases

```mermaid
classDiagram
    class Criatura {
        +nombre
        +vida
        +ataque
        +defensa
        +atacar()
        +mostrarEstadisticas()
    }

    class Dragon {
        +atacar()
    }

    class Guerrero {
        +atacar()
    }

    class Mago {
        +atacar()
    }

    class Magico {
        <<interface>>
    }

    class Voladora {
        <<interface>>
    }

    class Main {
        +main(String[] args)
    }

    Criatura <|-- Dragon
    Criatura <|-- Guerrero
    Criatura <|-- Mago

    Mago ..|> Magico
    Dragon ..|> Voladora

    Main --> Criatura