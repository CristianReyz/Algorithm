package Modelo.Sort.Iterativo;

import java.util.Arrays;

public class Radix {

    public static int[] ordenado;

    private void countingSort(int[] vector, int tamanio, int posicion){

        int[] salida = new int[tamanio + 1];

        int maximo = vector[0];

        for (int i = 1; i < tamanio; i++){
            if (vector[i] > maximo)
                maximo = vector[i];
        }

        int[] count = new int[maximo + 1];

        for (int i = 0; i < maximo; ++i) {
            count[i] = 0;
        }

        for (int i = 0; i < tamanio; i++) {
            count[(vector[i] / posicion) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = tamanio - 1; i >= 0; i--) {
            salida[count[(vector[i] / posicion) % 10] - 1] = vector[i];
            count[(vector[i] / posicion) % 10]--;
        }

        for (int i = 0; i < tamanio; i++) {
            vector[i] = salida[i];
        }
    }

    private int maximo(int[] vector, int tamanio) {
        int maximo = vector[0];
        for (int i = 1; i < tamanio; i++)
            if (vector[i] > maximo)
                maximo = vector[i];
        return maximo;
    }

    private int[] radixSort(int[] vector, int tamanio) {
        int maximo = maximo(vector, tamanio);
        for (int posicion = 1; maximo / posicion > 0; posicion *= 10) {
            countingSort(vector, tamanio, posicion);
        }
        return vector;
    }

    public String radixTime(int[] vector){
        long startTimeIterativo = System.nanoTime();
        ordenado = radixSort(vector, vector.length);
        long endTimeIterativo = System.nanoTime() - startTimeIterativo;
        return "\nEl vector ordenado es: " + Arrays.toString(ordenado) +
                "\nEl metodo radix tardo: " + endTimeIterativo + " nanosegundos\n";
    }
}