package Modelo.Sort.Recursivo;

import java.util.Arrays;

public class Merge {

    public static int[] ordenado;

    void divide(int[] vector, int minimo, int mitad, int maximo){
        int []arrayTemporal1 = new int[vector.length];
        int []arrayTemporal2 = new int[vector.length];

        int n1,n2,i,j,k;
        n1 = mitad - minimo + 1;
        n2 = maximo - mitad;

        for(i = 0; i < n1;i++){
            arrayTemporal1[i] = vector[minimo + i];
        }
        for(j = 0;j < n2;j++){
            arrayTemporal2[j] = vector[mitad + j + 1];
        }
        arrayTemporal1[i]=Integer.MAX_VALUE;
        arrayTemporal2[j]=Integer.MAX_VALUE;
        i = 0; j = 0;
        for(k = minimo ;k <= maximo ; k++){
            if(arrayTemporal1[i] <= arrayTemporal2[j]){
                vector[k] = arrayTemporal1[i++];
            }
            else{
                vector[k] = arrayTemporal2[j++];
            }
        }
    }

    private int[] ordena(int[] vector, int minimo, int maximo){
        int mitad;
        if(minimo < maximo){
            mitad = (minimo + maximo)/2;
            ordena(vector,minimo,mitad);
            ordena(vector,mitad+1,maximo);
            divide(vector,minimo,mitad,maximo);
        }
        return vector;
    }

    public String mergeTime(int[] vector){
        long startTimeRecursivo = System.nanoTime();
        ordenado = ordena(vector, 0, vector.length - 1);
        long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
        return ("\nEl vector ordenado es: " + Arrays.toString(ordenado) + "  " +
                "\nEl metodo MergeSort tardo: " + endTimeRecursivo + " nanosegundos\n");
    }
}
