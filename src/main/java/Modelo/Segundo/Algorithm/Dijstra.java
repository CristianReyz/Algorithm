package Modelo.Segundo.Algorithm;

import Modelo.Segundo.Grafo.Arco;
import Modelo.Segundo.Grafo.Grafo;
import Modelo.Segundo.Grafo.Nodo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijstra {

    PriorityQueue<Nodo> colaPrioridadMinima = new PriorityQueue<>();
    private List<Nodo> adyacentes = new ArrayList<>();
    private List<Arco> arcosAdyacentes = new ArrayList<>();

    private void inicializar(Nodo root){
        for (Nodo auxiliar: Grafo.nodos) {
            auxiliar.setKey(Integer.MAX_VALUE);
            auxiliar.setPadreID(0);
        }
        root.setKey(0);
        colaPrioridadMinima.addAll(Grafo.nodos);
    }

    int i = 0;
    public void DijstraA(Nodo root){
        Nodo actual;
        inicializar(root);
        while (colaPrioridadMinima.peek() != null) {
            //System.out.println("Cola(" + i + ")" + colaPrioridadMinima);
            actual = colaPrioridadMinima.poll();
            arcosAdyacentes.clear();
            adyacentes.clear();
            //System.out.println("actual:(" + i + ") " + actual);
            getAdyacentes(actual);
            for (Arco auxiliar : arcosAdyacentes) {
                relax(auxiliar);
            }
            i++;
            //System.out.println("\n break \n");
        }
    }

    private void relax(Arco arco){
        System.out.println("Relax: arco: "+arco);
        System.out.println("key del nodo destino: "+arco.getDestino().getKey());
        System.out.println("key del nodo emisor: "+arco.getEmisor().getKey());
        if(arco.getDestino().getKey() > arco.getEmisor().getKey() + arco.getPeso() ){
            arco.getDestino().setKey(arco.getEmisor().getKey() + arco.getPeso());
            arco.getDestino().setPadreID(arco.getEmisor().getId());
            System.out.println("nodos Adyacentes de ("+i+") en relax: "+adyacentes);
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
}
