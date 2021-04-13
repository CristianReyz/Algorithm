package Modelo.Sort.Iterativo;

import java.util.Arrays;

public class Burbuja {

    public static int [] ordenado;

    private int[] burbujaIterativa(int[] vector){
        int auxiliar = 0;
        for (int i = 0; i < (vector.length -1); i++) {
            for (int j = 0; j < (vector.length - i -1); j++) {
                if(vector[j] > vector[j+1]){
                    auxiliar = vector[j+1];
                    vector[j+1] = vector[j];
                    vector[j] = auxiliar;
                }
            }
        }
        return vector;
    }

    public String burbujaTime(int[] vector){
            long startTimeIterativo = System.nanoTime();
            ordenado = burbujaIterativa(vector);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return ("\nEl vector ordenado es: " + Arrays.toString(ordenado) +
                    "\nEl metodo Burbuja tardo: " + endTimeIterativo + " nanosegundos\n");
    }
}
