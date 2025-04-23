package controllers;

import models.Persona;

public class MetodosBusqueda {

    public Persona busquedaBinariaPorEdad(Persona[] personas, int edad) {
        int izquierda = 0;
        int derecha = personas.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int edadMedio = personas[medio].getEdad();

            if (edadMedio == edad) {
                return personas[medio];
            } else if (edad < edadMedio) {
                derecha = medio - 1;
            } else {
                izquierda = medio + 1;
            }
        }

        return null;
    }

    public Persona busquedaBinariaPorNombre(Persona[] personas, String nombre) {
        int izquierda = 0;
        int derecha = personas.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            String nombreMedio = personas[medio].getNombre();

            int comparacion = nombre.compareToIgnoreCase(nombreMedio);

            if (comparacion == 0) {
                return personas[medio];
            } else if (comparacion < 0) {
                derecha = medio - 1;
            } else {
                izquierda = medio + 1;
            }
        }

        return null;
    }

    public boolean estaOrdenadoPorEdad(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            if (personas[i].getEdad() > personas[i + 1].getEdad()) {
                return false;
            }
        }
        return true;
    }

    public boolean estaOrdenadoPorNombre(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            if (personas[i].getNombre().compareToIgnoreCase(personas[i + 1].getNombre()) > 0) {
                return false;
            }
        }
        return true;
    }
}
