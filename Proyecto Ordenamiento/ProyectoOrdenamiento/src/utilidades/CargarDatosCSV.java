package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CargarDatosCSV {

    public static List<Integer> cargarDesdeCSV(String archivo) {
        List<Integer> lista = new ArrayList<>();

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(archivo)))) {
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                try {
                    lista.add(Integer.valueOf(scanner.next().trim()));
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ ¡Advertencia! Dato inválido en el archivo: " + e.getMessage() + ". Será ignorado.");
                }
            }
        } catch (IOException e) {
            System.out.println("❌ ¡Error! No se pudo leer el archivo: " + e.getMessage());
        }

        return lista;
    }

    public static void opcionCargarDatos(List<Integer> lista) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese la ruta del archivo CSV: ");
            String archivo = scanner.nextLine();
    
            lista.clear();
    
            try {
                List<Integer> datosCargados = cargarDesdeCSV(archivo);
    
                if (datosCargados.isEmpty()) {
                    System.out.println("❌ ¡Advertencia! No se cargaron datos del archivo.");
                } else {
                    lista.addAll(datosCargados);
                    System.out.println("✅ ¡Éxito! Datos cargados correctamente.");
                    System.out.println("📊 Datos cargados: " + lista);
                }
            } catch (Exception e) { // Captura cualquier excepción
                System.out.println("❌ ¡Error! No se pudo leer el archivo: " + e.getMessage());
            }
        }
    }
}
//                 case 8 -> System.out.println("👋 ¡Hasta luego! Gracias por usar el programa!");