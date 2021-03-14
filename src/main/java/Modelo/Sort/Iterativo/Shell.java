package Modelo.Sort.Iterativo;

import java.util.Arrays;

public class Shell {
public static int[] ordenado;

    private int[] shellIterativo(int[] vector){
        int salto, aux, i;
        boolean cambios;

        for (salto = vector.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (i = salto; i < vector.length; i++)
                {
                    if (vector[i - salto] > vector[i]) {
                        aux = vector[i];
                        vector[i] = vector[i - salto];
                        vector[i - salto] = aux;
                        cambios = true;
                    }
                }
            }
        }
        return vector;
    }

    public String shellTime(int[] vector){
            long startTimeIterativo = System.nanoTime();
            ordenado = shellIterativo(vector);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return ("\nEl vector ordenado es: " + Arrays.toString(ordenado) +
                    "\nEl metodo Shell tardo: " + endTimeIterativo + " nanosegundos\n");
    }
}
