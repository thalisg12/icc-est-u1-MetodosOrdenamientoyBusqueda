package controllers;

import models.Persona;

public class MetodosOrdenamiento {

    public void ordenarPorNombreBurbuja(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            for (int j = 0; j < personas.length - 1 - i; j++) {
                if (personas[j].getNombre().compareToIgnoreCase(personas[j + 1].getNombre()) > 0) {
                    Persona temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }

    public void ordenarPorNombreSeleccionDesc(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < personas.length; j++) {
                if (personas[j].getNombre().compareToIgnoreCase(personas[maxIdx].getNombre()) > 0) {
                    maxIdx = j;
                }
            }
            Persona temp = personas[i];
            personas[i] = personas[maxIdx];
            personas[maxIdx] = temp;
        }
    }

    public void ordenarPorEdadInsercion(Persona[] personas) {
        for (int i = 1; i < personas.length; i++) {
            Persona actual = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getEdad() > actual.getEdad()) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = actual;
        }
    }

    public void ordenarPorNombreInsercion(Persona[] personas) {
        for (int i = 1; i < personas.length; i++) {
            Persona actual = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getNombre().compareToIgnoreCase(actual.getNombre()) > 0) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = actual;
        }
    }
}
