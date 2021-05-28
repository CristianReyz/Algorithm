package Modelo.Segundo.Algorithm;

import Modelo.Segundo.Grafo.Arco;
import Modelo.Segundo.Grafo.Grafo;
import Modelo.Segundo.Grafo.Nodo;

public class BellmanFord {

    public boolean bellmanFordA(Nodo root){
        inicializar(root);

        for (int i = 1; i <Grafo.arcos.size()-1 ; i++) {
            for (Arco auxiliar: Grafo.arcos) {
                relax(auxiliar.getEmisor(),auxiliar.getDestino(), auxiliar);
            }
        }

        for (Arco auxiliar: Grafo.arcos) {
            if(auxiliar.getDestino().getD() > auxiliar.getEmisor().getD() +auxiliar.getPeso() ){
                return false;
            }
        }
        return true;
    }

    private void inicializar(Nodo root){
        for (Nodo auxiliar: Grafo.nodos) {
            auxiliar.setD(Integer.MAX_VALUE);
            auxiliar.setPadreID(0);
        }
        root.setD(0);
    }

    private void relax(Nodo emisor, Nodo destino, Arco arco){
        if(destino.getD() > emisor.getD() +arco.getPeso() ){
            destino.setD(emisor.getD() +arco.getPeso());
            destino.setPadreID(emisor.getId());
        }
    }

    public String costo(){
        int costo = Grafo.nodos.get(Grafo.nodos.size()-1).getD();
        return " \n \t Costo: "+costo;
    }
}
