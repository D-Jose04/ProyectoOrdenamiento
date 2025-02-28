package ordenamiento;

import java.util.List;

public class BubbleSort {

    public static void ordenar(List<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
        System.out.println("✅ ¡Éxito! Lista ordenada con Bubble Sort.");
    }

    public static void opcionBubbleSort(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("⚠️ ¡Advertencia! No hay datos cargados. Cargue datos primero.");
            return;
        }
        ordenar(lista);
        System.out.println("📊 Lista ordenada: " + lista);
    }
}