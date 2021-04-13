package Modelo.Recursividad;

public class Factorial {

    public int factorialRecursivoDemo(int numero){
        int fminus1;
        //System.out.println(numero);
        if(numero == 0){
            return 1; //caso base
        }
        fminus1 = factorialRecursivoDemo(numero-1);
        //System.out.println("numero: "+numero+ "factorial menos uno "+fminus1);
        return fminus1*numero;
    }

    private int factorialIterativo(int numero){
        int factorial = 1;
        if(numero==0){
            return 1;
        }else {
            for(int i = numero;i>0;i--){
                factorial *= i;
            }
            return factorial;
        }
    }
    public String factorialTime(int numero, String metodo){
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            int recursivo = factorialRecursivoDemo(numero);
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return("\nEl factorial de "+numero+" f("+numero+") es: "+recursivo+"  " +
                    "\nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n");
        }else if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            int iterativo = factorialIterativo(numero);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return ("\nEl fibonacci de " + numero + " f(" + numero + ") es: " + iterativo + "  " +
                    "\nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n");
        }

        return "\n\nMetodo indefinido\n";
    }
}
