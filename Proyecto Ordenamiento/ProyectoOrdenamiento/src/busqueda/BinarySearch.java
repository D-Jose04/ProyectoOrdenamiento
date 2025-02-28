package busqueda;

import java.util.List;
import java.util.Scanner;

public class BinarySearch {

    public static int buscar(List<Integer> lista, int objetivo) {
        int inicio = 0;
        int fin = lista.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (lista.get(medio) == objetivo) {
                return medio;
            }

            if (lista.get(medio) < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    public static void opcionBinarySearch(List<Integer> lista) {
                    if (lista.isEmpty()) {
                System.out.println("⚠️ ¡Advertencia! No hay datos cargados. Cargue datos primero.");
                return;
            }
    
try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el número a buscar: ");
            int objetivo = scanner.nextInt();
            scanner.nextLine();
    
            int resultado = buscar(lista, objetivo);
    
            if (resultado == -1) {
                System.out.println("❌ ¡Advertencia! El número no está en la lista.");
            } else {
                System.out.println("✅ ¡Éxito! El número " + objetivo + " se encuentra en el índice: " + resultado);
            }
        } // Scanner se cierra automáticamente aquí
}
    }