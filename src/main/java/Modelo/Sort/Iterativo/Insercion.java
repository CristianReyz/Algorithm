package Modelo.Sort.Iterativo;

import java.util.Arrays;

public class Insercion {

    public static int[] ordenado;

    private int[] insercionIterativa(int[] vector){
        int posicion, auxiliar;
        for (int i = 0; i < vector.length; i++) {
            posicion = i;
            auxiliar = vector[i];
            while ((posicion>0)&&(vector[posicion-1]>auxiliar)){
                vector[posicion] = vector[posicion - 1];
                posicion--;
            }
            vector[posicion] = auxiliar;
        }
        return vector;
    }


    public String insercionTime(int[] vector) {
        long startTimeIterativo = System.nanoTime();
        ordenado = insercionIterativa(vector);
        long endTimeIterativo = System.nanoTime() - startTimeIterativo;
        return ("\nEl vector ordenado es: " + Arrays.toString(ordenado) +
                "\nEl metodo por Insercion tardo: " + endTimeIterativo + " nanosegundos\n");
    }
}
