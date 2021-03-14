package Modelo.Recursividad;

import java.util.Arrays;

public class SumaVector {
    static int contador = 0;

    private int vectorRecursivo(int[] vector, int posicion){
        int suma = vector[0];
        if(posicion > 0){
            suma = vector[posicion] + vectorRecursivo(vector, posicion -1);
            contador++;
        }
        return suma;
    }

    private int vectorIterativo(int[] vector){
        int suma = 0;
        for (int j : vector) {
            suma = suma + j;
        }
        return suma;
    }

    public String vectorTime(int[] vector, String metodo){
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            int recursivo = vectorRecursivo(vector,vector.length-1);
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return "\nLa suma de los elementos del vector "+ Arrays.toString(vector) +" es: "+recursivo+"  " +
                    "\nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n";
        } else if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            int iterativo = vectorIterativo(vector);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return "\nLa suma de los elementos del vector "+ Arrays.toString(vector) +" es: " + iterativo + "  " +
                    "\nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n";
        }
        return "\nmetodo indefinido\n";
    }

}
