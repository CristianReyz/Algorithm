package Modelo.Sort.Iterativo;

import java.util.Arrays;

public class Seleccion {
    public static int[] ordenado;

    private int[] ordenarPorSeleccion(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] > vector[j]) {
                    int temporal = vector[i];
                    vector[i] = vector[j];
                    vector[j] = temporal;
                }
            }
        }
        return vector;
    }

    public String seleccionTime(int[] vector){
            long startTimeIterativo = System.nanoTime();
            ordenado = ordenarPorSeleccion(vector);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return "\nEl vector ordenado es: " + Arrays.toString(ordenado) +
                    "\nEl metodo por seleccion tardo: " + endTimeIterativo + " nanosegundos\n";
    }
}
