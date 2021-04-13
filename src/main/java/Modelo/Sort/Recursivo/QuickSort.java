package Modelo.Sort.Recursivo;
import java.util.Arrays;
public class QuickSort {

    public static int[] ordenado;

    private int[] quickSortRecursivo(int[] vector, int izquierda, int derecha){
        int i = izquierda, j = derecha, temporal;
        int p = vector[(izquierda+derecha)/2];
        while (i <= j){
            while (vector[i] < p) i++;
            while (vector[j] > p) j--;
            if(i <= j){
                temporal = vector[i];
                vector[i] = vector[j];
                vector[j] = temporal;
                i++; j--;
            }
        }
        if(izquierda < j) quickSortRecursivo(vector,izquierda,j);
        if(i < derecha) quickSortRecursivo(vector,i,derecha);

        return vector;
    }



    public String quickTime(int[] vector) {
        long startTimeRecursivo = System.nanoTime();
        ordenado = quickSortRecursivo(vector, 0, vector.length - 1);
        long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
        return ("\nEl vector ordenado es: " + Arrays.toString(ordenado) + "  " +
                "\nEl metodo QuickSort tardo: " + endTimeRecursivo + " nanosegundos\n");
    }

}
