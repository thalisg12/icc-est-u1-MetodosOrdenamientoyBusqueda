package controllers;

import models.Persona;
import views.View;

import java.util.ArrayList;

public class Controlador {
    private View vista;
    private MetodosOrdenamiento ordenamiento;
    private MetodosBusqueda busqueda;
    private ArrayList<Persona> listaPersonas;

    public Controlador(View vista, MetodosOrdenamiento ordenamiento, MetodosBusqueda busqueda) {
        this.vista = vista;
        this.ordenamiento = ordenamiento;
        this.busqueda = busqueda;
        this.listaPersonas = new ArrayList<>();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1 -> agregarPersonas();
                case 2 -> ordenarPersonas();
                case 3 -> buscarPersona();
                case 4 -> mostrarLista();
                case 0 -> vista.mostrarMensaje("Saliendo del programa...");
                default -> vista.mostrarMensaje("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void agregarPersonas() {
        Persona persona = vista.inputPersona();
        listaPersonas.add(persona);
        vista.mostrarMensaje("Persona agregada correctamente.");
    }

    private void ordenarPersonas() {
        if (listaPersonas.isEmpty()) {
            vista.mostrarMensaje("No hay personas para ordenar.");
            return;
        }

        Persona[] arreglo = listaPersonas.toArray(new Persona[0]);
        int metodo = vista.seleccionarMetodoOrdenamiento();

        switch (metodo) {
            case 1 -> ordenamiento.ordenarPorNombreBurbuja(arreglo);
            case 2 -> ordenamiento.ordenarPorNombreSeleccionDesc(arreglo);
            case 3 -> ordenamiento.ordenarPorEdadInsercion(arreglo);
            case 4 -> ordenamiento.ordenarPorNombreInsercion(arreglo);
            default -> {
                vista.mostrarMensaje("Opción inválida.");
                return;
            }
        }

        listaPersonas.clear();
        for (Persona p : arreglo) {
            listaPersonas.add(p);
        }

        vista.mostrarMensaje("Personas ordenadas correctamente.");
    }

    private void buscarPersona() {
        if (listaPersonas.isEmpty()) {
            vista.mostrarMensaje("No hay personas para buscar.");
            return;
        }

        Persona[] arreglo = listaPersonas.toArray(new Persona[0]);
        int criterio = vista.seleccionarCriterioBusqueda();

        switch (criterio) {
            case 1 -> { // Por edad
                if (!busqueda.estaOrdenadoPorEdad(arreglo)) {
                    ordenamiento.ordenarPorEdadInsercion(arreglo);
                    vista.mostrarMensaje("La lista fue ordenada por edad.");
                }
                int edad = vista.inputEdad();
                Persona resultado = busqueda.busquedaBinariaPorEdad(arreglo, edad);
                vista.mostrarResultadoBusqueda(resultado);
            }

            case 2 -> { // Por nombre
                if (!busqueda.estaOrdenadoPorNombre(arreglo)) {
                    ordenamiento.ordenarPorNombreBurbuja(arreglo);
                    vista.mostrarMensaje("La lista fue ordenada por nombre.");
                }
                String nombre = vista.inputNombre();
                Persona resultado = busqueda.busquedaBinariaPorNombre(arreglo, nombre);
                vista.mostrarResultadoBusqueda(resultado);
            }

            default -> vista.mostrarMensaje("Opción inválida.");
        }
    }

    private void mostrarLista() {
        Persona[] arreglo = listaPersonas.toArray(new Persona[0]);
        vista.mostrarPersonas(arreglo);
    }
}
