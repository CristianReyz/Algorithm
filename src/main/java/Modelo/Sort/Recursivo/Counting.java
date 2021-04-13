package Modelo.Sort.Recursivo;

import java.util.Arrays;

public class Counting {

    public static int[] ordenado;

        private int[] countSort(int[] vector)
        {
            int maximo = Arrays.stream(vector).max().getAsInt();
            int minimo = Arrays.stream(vector).min().getAsInt();
            int rango = maximo - minimo + 1;
            int[] count = new int[rango];
            int[] salida = new int[vector.length];
            for (int i = 0; i < vector.length; i++) {
                count[vector[i] - minimo]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = vector.length - 1; i >= 0; i--) {
                salida[count[vector[i] - minimo] - 1] = vector[i];
                count[vector[i] - minimo]--;
            }

            for (int i = 0; i < vector.length; i++) {
                vector[i] = salida[i];
            }
            return vector;
        }



    public String countingTime(int[] vector){
        long startTimeRecursivo = System.nanoTime();
        ordenado = countSort(vector);
        long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;

        return ("\nEl vector ordenado es: " + Arrays.toString(ordenado) + "  " +
                "\nEl metodo Count tardo: " + endTimeRecursivo + " nanosegundos\n");
    }

}
