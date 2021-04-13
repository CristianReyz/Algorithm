package Modelo.Recursividad;

public class sumaUnidades {

    private int auxiliar = 0;

    private int descomponerRecursivo(int numero){
        if((numero%10) != 0){
            auxiliar += (numero % 10);
            descomponerRecursivo(numero/10);
        }
        return auxiliar;
    }

    private int descomponerIterativo(int numero){
        int suma = 0;
        for (int i = 0; i < 3; i++) {
            if((numero%10)!=0){
                suma += (numero%10);
                numero/=10;
            }
        }
        return suma;
    }
    public String sumaUnidadesTime(int numero, String metodo){
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            int recursivo = descomponerRecursivo(numero);
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return("\nLa suma de unidades de "+numero+" f("+numero+") es: "+recursivo+"  " +
                    "\nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n");
        } else if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            int iterativo = descomponerIterativo(numero);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return ("\nLa suma de unidades de " + numero + " f(" + numero + ") es: " + iterativo + "  " +
                    "\nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n");
        }
        return "\nmetodo indefinido\n";
    }
}
