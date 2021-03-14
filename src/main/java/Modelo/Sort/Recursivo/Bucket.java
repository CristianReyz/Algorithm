package Modelo.Sort.Recursivo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bucket {

    public static int[] ordenado;

    private static int[] bucketSort(int[] vector) {
        final int[] codigo = hash(vector);

        List[] buckets = new List[codigo[1]];
        for (int i = 0; i < codigo[1]; i++) {
            buckets[i] = new ArrayList();
        }
        for (int i : vector) {
            buckets[hash(i, codigo)].add(i);
        }

        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        int auxiliar = 0;
        for (int b = 0; b < buckets.length; b++) {
            for (Object v : buckets[b]) {
                vector[auxiliar++] = (int) v;
            }
        }
        return vector;
    }

    private static int[] hash(int[] input) {
        int m = input[0];
        for (int i = 1; i < input.length; i++) {
            if (m < input[i]) {
                m = input[i];
            }
        }
        return new int[] { m, (int) Math.sqrt(input.length) };
    }

    private static int hash(int i, int[] code) {
        return (int) ((double) i / code[0] * (code[1] - 1));
    }



    public String bucketTime(int[] vector){
        long startTimeRecursivo = System.nanoTime();
        ordenado = bucketSort(vector);
        long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;

        return ("\nEl vector ordenado es: " + Arrays.toString(ordenado) + "  " +
                "\nEl metodo Bucket tardo: " + endTimeRecursivo + " nanosegundos\n");
    }
}
