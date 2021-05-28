package Modelo.Segundo.Algorithm;

import Modelo.Segundo.Grafo.Arco;
import Modelo.Segundo.Grafo.Grafo;
import Modelo.Segundo.Grafo.Nodo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Anchura {

    private final List<Nodo> adyacentes = new ArrayList<>();

    public void breadthFrist(Nodo root){
        Nodo actual;
        Queue<Nodo> cola = new LinkedList<>();
        for (Nodo auxiliar: Grafo.nodos) {
            if(root.getId() != auxiliar.getId()){
                auxiliar.setColor("WHITE");
                auxiliar.setD(Integer.MAX_VALUE);
                auxiliar.setPadreID(0);
            }
        }
        root.setColor("GRAY");
        root.setD(0);
        cola.add(root);
        while(cola.size()!=0){
            actual = cola.poll();
            getAdyacentes(actual);
            for (Nodo auxiliar:adyacentes) {
                if(auxiliar.getColor().equals("WHITE")){
                    auxiliar.setColor("GRAY");
                    auxiliar.setD(actual.getD()+1);
                    auxiliar.setPadreID(actual.getId());
                    cola.add(auxiliar);
                }
            }
            actual.setColor("BLACK");
        }
    }

    private void getAdyacentes(Nodo actual) {
        for (Arco auxiliar: Grafo.arcos) {
            if(auxiliar.getEmisor().getId() == actual.getId()){
                adyacentes.add(auxiliar.getDestino());
            }
        }
    }

}
