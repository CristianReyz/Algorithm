package Modelo.Recursividad;

import java.util.ArrayList;

public class Hanoi {

    ArrayList<String> mensajesIterativo = new ArrayList<>();
    void hanoiIterativo(int cantidad){
        for (int i = 1; i <(1<< cantidad) ; i++) {
            mensajesIterativo.add("Mueve el bloque "+ cantidad+" de la torre "+
                    ((i&i-1)%3)+1+" a la "+(((i|i-1)+1)%3)+1);
        }
    }
    ArrayList<String> mensajes = new ArrayList<>();
    private void hanoiRecursivo(int cantidad, String origen, String destino, String auxiliar){ //num, char origen, char destino, char aux
        if(cantidad == 1){
            mensajes.add("Mueve el bloque "+cantidad+" de la torre "+origen+" a la "+destino);
        }else{
            hanoiRecursivo(cantidad-1,origen,auxiliar,destino);
            mensajes.add("Mueve el bloque "+cantidad+" de la torre "+origen+ " a la "+destino);
            hanoiRecursivo(cantidad-1,auxiliar,destino,origen);
        }
    }


    public String hanoiTime(int cantidad, String metodo){
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            hanoiRecursivo(cantidad,"A","C","B");
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;
            return("\n"+ mensajes+" \nfinalizado en: " +mensajes.size()+
                        " movimientos \nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n");
        } else if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            hanoiIterativo(cantidad);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return "\n" + mensajesIterativo + "\n finalizado en: " +mensajesIterativo.size()+
                    " movimientos \nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n";
        }
        return "\nmetodo indefinido\n";
    }

}
