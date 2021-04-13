package Modelo.Recursividad;

import java.util.ArrayList;

public class Newton {

    private ArrayList<Integer> triangulo = new ArrayList<>();

    private void pascalIterativo(int limite) {
        triangulo.add(0,1);
        for(int i =0;i<limite;i++) {
            int number = 1;
            for(int j=0;j<=i;j++) {
                number = number * (i - j) / (j + 1);
                if(j!=i && i==(limite-1)){
                    triangulo.add(j+1,number);
                }
            }
        }
    }

    int[][] vector = new int[100][100];
    private int pascalRecursivo(int i, int j){
        if(i==j || j==1){
            vector[i][j] = 1;
        } if(vector[i][j]==0){
            vector[i][j] = pascalRecursivo(i-1,j) + pascalRecursivo(i-1,j-1);
        }
        return vector[i][j];
    }


    private ArrayList<String> binomio = new ArrayList<>();
    private void newtonRecursivo(int potencia){
        int coeficientes = potencia+1;
        int auxiliar  = potencia;
        binomio.add("a^"+auxiliar+"\n");
        for (int i = 1; i < auxiliar; i++) {
            binomio.add(pascalRecursivo(coeficientes,i+1)+"a^"+(potencia-1)+"b^"+(i)+"\n");
            potencia--;
        }
        binomio.add("b^"+auxiliar);
    }

    private void newtonIterativo(int potencia){
        int auxiliar  = potencia;
        binomio.add("a^"+auxiliar+"\n");
        for (int i = 1; i < triangulo.size()-1; i++) {
            binomio.add(triangulo.get(i)+"a^"+(potencia-1)+"b^"+(i)+"\n");
            potencia--;
        }
        binomio.add("b^"+auxiliar);
    }



    public String newtonTime(int potencia, String metodo){
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            newtonRecursivo(potencia);
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return("\n(a+b)^"+potencia+" es: "+binomio+
                    "\nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n");
        } else if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            pascalIterativo(potencia+1);
            newtonIterativo(potencia);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return ("\n(a+b)^" + potencia + " es: " +binomio+
                    "\nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n");
        }
        return "\nmetodo indefinido\n";
    }
}
