package Modelo.Recursividad;

import java.util.ArrayList;

public class Hanoi {
    class Pila {
        int capacidad;
        int top;
        int[] vector;
    }

    Pila crearPila(int capacidad) {
        Pila pila = new Pila();
        pila.capacidad = capacidad;
        pila.top = -1;
        pila.vector = new int[capacidad];
        return pila;
    }

    boolean pilaLlena(Pila pila){
        return (pila.top == pila.capacidad - 1);
    }

    boolean pilaVacia(Pila pila) {
        return (pila.top == -1);
    }

    void push(Pila pila, int item){
        if (pilaLlena(pila)) {
            return;
        }
        pila.vector[++pila.top] = item;
    }

    int pop(Pila pila) {
        if (pilaVacia(pila))
            return Integer.MIN_VALUE;

        return pila.vector[pila.top--];
    }

    void moverDiscosEntreDos(Pila salida, Pila destino, char a, char c) {
        int barra1 = pop(salida);
        int barra2 = pop(destino);

        if (barra1 == Integer.MIN_VALUE) {
            push(salida, barra2);
            mueveDisco(c, a, barra2);
        } else if (barra2 == Integer.MIN_VALUE) {
            push(destino, barra1);
            mueveDisco(a, c, barra1);
        }else if (barra1 > barra2) {
            push(salida, barra1);
            push(salida, barra2);
            mueveDisco(c, a, barra2);
        }else {
            push(destino, barra2);
            push(destino, barra1);
            mueveDisco(a, c, barra1);
        }
    }

    ArrayList<String> mensajesIterativo = new ArrayList<>();
    void mueveDisco(char barraEmisor, char barraDestino, int disco) {
        mensajesIterativo.add("Mueve de: "+barraEmisor+" a "+barraDestino);
    }

    void hanoiIterativo(int cantidad, Pila salida, Pila auxiliar, Pila destino) {
        int i, totalDeMovimientos;
        char a = 'A', c = 'C', b = 'B';

        if (cantidad % 2 == 0) {
            char temp = c;
            c = b;
            b = temp;
        }
        totalDeMovimientos = (int) (Math.pow(2, cantidad) - 1);
        for (i = cantidad; i >= 1; i--) {
            push(salida, i);
        }

        for (i = 1; i <= totalDeMovimientos; i++) {
            if (i % 3 == 1) {
                moverDiscosEntreDos(salida, destino, a, c);
            }else if (i % 3 == 2) {
                moverDiscosEntreDos(salida, auxiliar, a, b);
            }else if (i % 3 == 0) {
                moverDiscosEntreDos(auxiliar, destino, b, c);
            }
        }
    }
    ArrayList<String> mensajes = new ArrayList<>();
    private void hanoiRecursivo(int cantidad, String A, String B, String C){
        if(cantidad == 1){
            mensajes.add("Mueve de "+A+" a "+C);
        }else{
            hanoiRecursivo(cantidad-1,A,B,C);
            mensajes.add("Mueve de "+A+" a "+C);
            hanoiRecursivo(cantidad-1,B,C,A);
        }
    }


    public String hanoiTime(int cantidad, String metodo){
        if(metodo.equals("RECURSIVO")){
            long startTimeRecursivo = System.nanoTime();
            hanoiRecursivo(cantidad,"A","B","C");
            long endTimeRecursivo = System.nanoTime() - startTimeRecursivo;

            return("\n"+ mensajes+" \nfinalizado en: " +mensajes.size()+
                        " movimientos \nEl metodo Recursivo tardo: "+endTimeRecursivo+" nanosegundos\n");

        } else if(metodo.equals("ITERATIVO")){
            long startTimeIterativo = System.nanoTime();
            Pila salida,auxiliar,destino;
            salida = crearPila(cantidad);
            auxiliar = crearPila(cantidad);
            destino = crearPila(cantidad);
            hanoiIterativo(cantidad,salida,auxiliar,destino);
            long endTimeIterativo = System.nanoTime() - startTimeIterativo;
            return "\n" + mensajesIterativo + "\n finalizado en: " +mensajesIterativo.size()+
                    " movimientos \nEl metodo Iterativo tardo: " + endTimeIterativo + " nanosegundos\n";
        }
        return "\nmetodo indefinido\n";
    }

}
