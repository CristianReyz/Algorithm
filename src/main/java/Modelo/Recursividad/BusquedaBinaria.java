package Modelo.Recursividad;

public class BusquedaBinaria {

    private int busquedaBinariaRecursiva(int[] vector, int busqueda, int izquierda, int derecha){

        // Si izquierda es mayor que derecha significa que no encontramos nada
        if(izquierda > derecha){
            return -1;
        }

        // Calculamos las mitades...
        int indiceDelElementoDelMedio = (int) Math.floor((izquierda + derecha) / 2);
        int elementoDelMedio = vector[indiceDelElementoDelMedio];

        // Ver si está en la mitad
        if(elementoDelMedio == busqueda){
            return indiceDelElementoDelMedio;
        }
        // Si no, entonces vemos si está a la izquierda o derecha

        if(busqueda < elementoDelMedio){
            derecha = indiceDelElementoDelMedio - 1;
            return busquedaBinariaRecursiva(vector, busqueda, izquierda, derecha);
        }else{
            izquierda = indiceDelElementoDelMedio + 1;
            return busquedaBinariaRecursiva(vector, busqueda, izquierda, derecha);
        }
    }

    private int busquedaBinariaIterativa(int[] arreglo, int busqueda){
        int izquierda = 0, derecha = arreglo.length - 1;

        while(izquierda <= derecha){
            // Calculamos las mitades...
            int indiceDelElementoDelMedio = (int) Math.floor((izquierda + derecha) / 2);
            int elementoDelMedio = arreglo[indiceDelElementoDelMedio];

            // Ver si está en la mitad y romper aquí el ciclo
            if(elementoDelMedio == busqueda){
                return indiceDelElementoDelMedio;
            }
            // Si no, entonces vemos si está a la izquierda o derecha

            if(busqueda < elementoDelMedio){
                derecha = indiceDelElementoDelMedio - 1;
            }else{
                izquierda = indiceDelElementoDelMedio + 1;
            }
        }
        // Si no se rompió el ciclo ni se regresó el índice, entonces el elemento no existe
        return -1;
    }

    public String busquedaBinariaTime(int[] vector, int busqueda, String metodo){
        if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            int iterativo = busquedaBinariaIterativa(vector,busqueda);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return ("\nEl elemento "+busqueda+" esta en el indice: " + iterativo +
                    "\nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n");
        }else if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            int recursivo = busquedaBinariaRecursiva(vector,busqueda,0, vector.length-1);
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return("\nEl elemento "+busqueda+" esta en el indice: "+ recursivo +"  " +
                    "\nEl metodo Busqueda Binaria Recursiva tardo: "+endTimeRecursivo+" nanosegundos\n");
        }
        return "\nMetodo indefinido\n";
    }

}
