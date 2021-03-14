package Modelo.Recursividad;

import java.util.Arrays;

public class VectorDoble {

    private int[] dobleRecursivo(int[] vector,int posicion){
        if(posicion == vector.length){
            return vector;
        }
        vector[posicion] = vector[posicion]*2;
        return dobleRecursivo(vector,posicion+1);
    }

    private int[] dobleIterativo(int[] vector){
        for(int i = 0; i < vector.length ;i++){
            vector[i] = vector[i]*2;
        }
        return vector;
    }

    public String dobleTime(int[] vector, String metodo){
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            int[] recursivo = dobleRecursivo(vector, 0);
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return "\nLos elementos dobles del vector son: "+ Arrays.toString(recursivo) +"  " +
                    "\nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n";
        } else if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            int[] iterativo = dobleIterativo(vector);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return "\nLos elementos dobles del vector son: " + Arrays.toString(iterativo) + "  " +
                    "\nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n";
        }
        return "metodo inválido";
    }
}
