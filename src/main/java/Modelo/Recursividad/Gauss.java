package Modelo.Recursividad;

public class Gauss {

    private int GaussIterativo(int limite){
        int iterativo = 0;
        for(int i = limite; i>0; i--){
            iterativo += i;
        }
        return iterativo;
    }

    private int GaussRecursivo(int limite){
        if(limite == 0){
            return limite;
        }
        limite += GaussRecursivo(limite-1);
        return limite;
    }

    public String GaussTime(int limite, String metodo){
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            int recursivo = GaussRecursivo(limite);
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return("\nLa suma hasta "+limite+" es: "+recursivo+"  " +
                    "\nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n");
        } else if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            int iterativo = GaussIterativo(limite);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return "\nLa suma hasta " + limite + " es: " + iterativo + "  " +
                    "\nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n";
        }else{
            long startTimeF = System.nanoTime();
            int formula = (limite * (limite+1))/2;
            long endTimeF = System.nanoTime() - startTimeF;
            return "\nLa suma hasta"+limite+" es: "+formula+
                    " El método con la fórmula tardó: "+endTimeF+" nanosegundos\n";

        }

    }
}
