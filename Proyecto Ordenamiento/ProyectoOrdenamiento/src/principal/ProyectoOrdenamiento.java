package principal;

import busqueda.BinarySearch;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ordenamiento.BubbleSort;
import utilidades.CargarDatosCSV;

public class ProyectoOrdenamiento {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
        List<Integer> listaDatos = new ArrayList<>();
        mostrarInformacion(scanner);
        mostrarMenu(scanner, listaDatos);
        scanner.close();}
    }
    
    
    public static void mostrarInformacion(Scanner scanner){
        System.out.println("========================================");
        System.out.println("          Proyecto Ordenamiento          ");
        System.out.println("========================================");
        System.out.println("Desarrollador: José Jolón");
        System.out.println("Contacto: jm@murting.com");
        System.out.println("Este programa permite ordenar y buscar números.");
        System.out.println("Para comenzar, carga un archivo CSV con números.");
    }

    public static void mostrarMenu(Scanner scanner, List<Integer> listaDatos){
        int opcion = 0;
        do {
            // Mostrar opciones
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Cargar datos desde un archivo CSV");
            System.out.println("2. Ordenar datos usando Bubble Sort");
            System.out.println("7. Buscar un número con Binary Search");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");
            // Leer opción del usuario con validación
            try {
                opcion = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("⚠️ ¡Advertencia! Entrada inválida. Debe ingresar un número.");
                scanner.next(); // Limpiar la entrada inválida
                continue; // Volver a mostrar el menú
            }
            scanner.nextLine(); // Limpiar el buffer
            //codigo del switch
            switch (opcion) {
                case 1 -> CargarDatosCSV.opcionCargarDatos(listaDatos);
                case 2 -> BubbleSort.opcionBubbleSort(listaDatos);
                case 7 -> {
                    if (listaDatos.isEmpty()) {
                        System.out.println("⚠️ ¡Advertencia! No hay datos cargados. Cargue datos primero.");
                    } else {
                        BinarySearch.opcionBinarySearch(listaDatos);
                    }
                }
                case 8 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 8);
    }
}