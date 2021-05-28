package Modelo.Segundo.Algorithm;

import Modelo.Segundo.Grafo.Arco;
import Modelo.Segundo.Grafo.Grafo;
import Modelo.Segundo.Grafo.Nodo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

    PriorityQueue<Nodo> colaPrioridadMinima = new PriorityQueue<>();
    private List<Nodo> adyacentes = new ArrayList<>();
    private List<Arco> arcosAdyacentes = new ArrayList<>();

    int i = 0;
    public void MSTPrim(Nodo root){
        Nodo actual;
        for (Nodo auxiliar: Grafo.nodos) {
            auxiliar.setKey(Integer.MAX_VALUE);
            auxiliar.setPadreID(0);
        }
        root.setKey(0);
        colaPrioridadMinima.addAll(Grafo.nodos);
        colaPrioridadMinima.add(nodooo());


        while (colaPrioridadMinima.peek() != null) {
            System.out.println("Cola("+i+")"+colaPrioridadMinima);
            actual = colaPrioridadMinima.poll();
            adyacentes.clear();
            arcosAdyacentes.clear();
            System.out.println("actual:("+i+") "+actual);
            getAdyacentes(actual);
            System.out.println("\n break \n");
            int posicionArco = 0;
            for (Nodo auxiliar:adyacentes) {
                if(colaPrioridadMinima.contains(auxiliar)
                        && arcosAdyacentes.get(posicionArco).getPeso() < auxiliar.getKey() ){
                    auxiliar.setPadreID(actual.getId());
                    auxiliar.setKey(arcosAdyacentes.get(posicionArco).getPeso());
                    posicionArco++;
                }
            }
            i++;

        }
    }

    private void getAdyacentes(Nodo actual) {
        for (Arco auxiliar: Grafo.arcos) {
            if(auxiliar.getEmisor().getId() == actual.getId()){
                adyacentes.add(auxiliar.getDestino());
                arcosAdyacentes.add(auxiliar);
            }
        }
        System.out.println("nodos Adyacentes de ("+i+")"+adyacentes);
        System.out.println("arcos Adyacentes de ("+i+")"+arcosAdyacentes);
    }



    private Nodo nodooo(){
        Nodo ajja = new Nodo(-1);
        ajja.setPadre(null);
        ajja.setKey(Integer.MAX_VALUE);
        return ajja;
    }
}
