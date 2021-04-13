package Modelo.Recursividad;

public class Fibonacci {
    int [] array = new int[50];

    private int fibonacciIterativo(int numero){
        int numeroMenosDos, numeroMenosUno = 0, actual = 1;
        if (numero > 1) {
            for (int i = 1; i < numero ; i++) {

                numeroMenosDos = numeroMenosUno;

                numeroMenosUno = actual;

                actual = numeroMenosDos + numeroMenosUno;
            }
            return actual;
        } else if (numero == 1) {  // caso base
            return 1;
        } else if (numero == 0) {  // caso base
            return 0;
        } else {
            return -1;
        }
    }

    private int fibonacciRecursivo(int numero) {
        if (numero > 1) {
            return fibonacciRecursivo(numero - 1) + fibonacciRecursivo(numero - 2);  //recursivo
        } else if (numero == 1) {  // caso base
            return 1;
        } else if (numero == 0) {  // caso base
            return 0;
        } else {
            return -1;
        }
    }

    private int fibonacciOptimizado(int numero){

        if(array[numero] != 0){
            return array[numero];
        } else if( numero == 0 || numero == 1){
            return numero;
        }
        array[numero] = fibonacciOptimizado(numero-1)+fibonacciOptimizado(numero-2);
        return array[numero];
    }

    public String fiboTime(int numero, String metodo) {
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            int recursivo = fibonacciRecursivo(numero);
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return("\nEl fibonacci de "+numero+" f("+numero+") es: "+recursivo+"  " +
                    "\nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n");
        }else if(metodo.equals("ITERATIVO")) {
            long startTimeIterativo = System.nanoTime();
            int iterativo = fibonacciIterativo(numero);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return ("\nEl fibonacci de " + numero + " f(" + numero + ") es: " + iterativo + "  " +
                    "\nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n");
        }

            long startTimeOptimizado = System.nanoTime();
            int optimizado = fibonacciOptimizado(numero);
            long endTimeOptimizado = System.nanoTime() - startTimeOptimizado;
            return ("\n\nBonus: \"\nEl fibonacci de "+numero+" f("+numero+") es: "+optimizado+"  " +
                    "\nEl metodo Optimizado tardo: "+endTimeOptimizado+" nanosegundos");

        //double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(endTimeRecursivo, TimeUnit.NANOSECONDS);
    }

}
