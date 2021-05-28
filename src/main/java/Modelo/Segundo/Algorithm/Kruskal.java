package Modelo.Segundo.Algorithm;

import Modelo.Segundo.Grafo.Arco;
import Modelo.Segundo.Grafo.Grafo;
import Modelo.Segundo.Grafo.Nodo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {


    PriorityQueue<Arco> colaPrioridadMinima = new PriorityQueue<>();
    int i = 0;
    public List<Arco> kruskal (){
        Arco arco;
        List<Arco> procesado = new ArrayList<>();
        colaPrioridadMinima.addAll(Grafo.arcos);
        System.out.println("cola inicial: "+colaPrioridadMinima);
        int j=0;
        for (Nodo auxiliar:Grafo.nodos) {
            makeSet(auxiliar);
            System.out.println("Nodo("+j+"): "+auxiliar);
            j++;
        }

        while (colaPrioridadMinima.peek() != null){
            System.out.println("cola ("+i+"): "+colaPrioridadMinima);
            arco = colaPrioridadMinima.poll();
            System.out.println("arco("+i+")"+arco);
            assert arco != null;
            System.out.println("findset emisor antes "+findSet(arco.getEmisor()));
            System.out.println("findset emisor antes "+findSet(arco.getDestino()));
            if(findSet(arco.getEmisor()) != findSet(arco.getDestino())){
                procesado.add(arco);
                System.out.println(procesado);
                union(arco.getEmisor(),arco.getDestino());
            }
            i++;
        }
            return procesado;
    }


    private void makeSet(Nodo nodo) {
        nodo.setPadreID(nodo.getId());
        nodo.setKey(0);
        nodo.setPadre(nodo);
    }

    private void union(Nodo emisor, Nodo destino) {
        link(findSet(emisor),findSet(destino));
    }


    private void link(Nodo emisor, Nodo destino) {
        if(emisor.getKey() > destino.getKey()) {
            destino.setPadre(emisor);
            //
            destino.setPadreID(emisor.getId());
            //
        }else{
            emisor.setPadre(destino);
            //
            emisor.setPadreID(destino.getId());
            //
            if(emisor.getKey() == destino.getKey()){
                destino.setKey(destino.getKey()+1);
            }
        }
    }

    private Nodo findSet(Nodo nodo) {
        if (nodo.getId() != nodo.getPadreID()) {
            nodo.setPadre(findSet(nodo.getPadre()));


            nodo.setPadreID(nodo.getPadreID());



        }
        return nodo.getPadre();
    }


}
