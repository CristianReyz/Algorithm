package Modelo.Recursividad;

public class MCD {

    private int MCDRecursivo(int numero1, int numero2){
        if(numero2==0) {
            return numero1;
        }else {
            return MCDRecursivo(numero2, numero1 % numero2);
        }
    }

    private int MCDIterativo(int numero1, int numero2){
        int temporal;
        while (numero2 != 0) {
            temporal = numero2;
            numero2 = numero1 % numero2;
            numero1 = temporal;
        }
        return numero1;
    }

    public String MCDTime(int numero1, int numero2, String metodo){
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            int recursivo = MCDRecursivo(numero1,numero2);
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return("\nEl MCD de "+numero1+" y "+numero2+" es: "+recursivo+"  " +
                    "\nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n");
        } else if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            int iterativo = MCDIterativo(numero1,numero2);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return ("\nEl MCD de " + numero1 + " y " + numero2 + " es: " + iterativo + "  " +
                    "\nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n");
        }
        return "\nmetodo indefinido\n";
    }
}
