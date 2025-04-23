package views;

import java.util.Scanner;
import models.Persona;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Ordenar personas");
        System.out.println("3. Buscar persona");
        System.out.println("4. Mostrar lista de personas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Persona inputPersona() {
        System.out.print("Ingrese el nombre: ");
        scanner.nextLine(); // Limpia el buffer
        String nombre = scanner.nextLine();
        int edad = inputEdad();
        return new Persona(nombre, edad);
    }

    public int inputEdad() {
        System.out.print("Ingrese la edad: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Edad inválida. Intente de nuevo: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String inputNombre() {
        System.out.print("Ingrese el nombre a buscar: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public void mostrarPersonas(Persona[] personas) {
        if (personas.length == 0) {
            System.out.println("No hay personas registradas.");
            return;
        }
        System.out.println("\n--- Lista de Personas ---");
        for (Persona p : personas) {
            System.out.println(p);
        }
    }

    public void mostrarResultadoBusqueda(Persona persona) {
        if (persona != null) {
            System.out.println("Persona encontrada: " + persona);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public int seleccionarMetodoOrdenamiento() {
        System.out.println("\nSeleccione el método de ordenamiento:");
        System.out.println("1. Burbuja (por nombre)");
        System.out.println("2. Selección descendente (por nombre)");
        System.out.println("3. Inserción (por edad)");
        System.out.println("4. Inserción (por nombre)");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public int seleccionarCriterioBusqueda() {
        System.out.println("\nSeleccione el criterio de búsqueda:");
        System.out.println("1. Por edad");
        System.out.println("2. Por nombre");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
