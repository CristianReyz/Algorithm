package Modelo.Recursividad;

import java.util.ArrayList;

public class TrianguloPascal {

    int[][] vector = new int[100][100];

    private int pascalRecursivo(int i, int j){
        if(i==j || j==1){
           vector[i][j] = 1;
        } if(vector[i][j]==0){
            vector[i][j] = pascalRecursivo(i-1,j) + pascalRecursivo(i-1,j-1);
        }
        return vector[i][j];
    }

    private ArrayList<Integer> triangulo = new ArrayList<>();
    private void pascalIterativo(int limite) {
        triangulo.add(0,1);
        for(int i =0;i<limite;i++) {
            int numero = 1;
            for(int j=0;j<=i;j++) {
                numero = numero * (i - j) / (j + 1);
                if(j!=i && i==(limite-1)){
                    triangulo.add(j+1,numero);
                }
            }
        }
    }

    public String pascalTime(int primero, int segundo, String metodo) {
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            int recursivo = pascalRecursivo(primero,segundo);
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return("\nLa posicion["+primero+"]["+ segundo +"] es: "+recursivo+"  " +
                    "\nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n");
        } else if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            pascalIterativo(segundo+1);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;

            return ("\nLa ultima fila del triangulo es:  " + triangulo + "  " +
                    "\nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n");
        }
        return "\nmetodo indefinido\n";
    }
}
