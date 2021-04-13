package Modelo.Sort.Recursivo;

import java.util.Arrays;

public class Heap {

    public static int[] ordenado;

    private int[] heap(int[] vector)
    {
        int tamanio = vector.length;

        for (int i = tamanio / 2 - 1; i >= 0; i--)
            heapify(vector, tamanio, i);

        for (int i = tamanio - 1; i > 0; i--) {
            int auxiliar = vector[0];
            vector[0] = vector[i];
            vector[i] = auxiliar;
            heapify(vector, i, 0);
        }
        return vector;
    }

    void heapify(int[] arr, int n, int i)
    {
        int largo = i;
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;
        if (izquierda < n && arr[izquierda] > arr[largo])
            largo = izquierda;
        if (derecha < n && arr[derecha] > arr[largo])
            largo = derecha;
        if (largo != i) {
            int swap = arr[i];
            arr[i] = arr[largo];
            arr[largo] = swap;
            heapify(arr, n, largo);
        }
    }


    public String heapTime(int[] vector){
        long startTimeRecursivo = System.nanoTime();
        ordenado = heap(vector);
        long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;

        return ("\nEl vector ordenado es: " + Arrays.toString(ordenado) + "  " +
                "\nEl metodo Heap tardo: " + endTimeRecursivo + " nanosegundos\n");
    }
}
