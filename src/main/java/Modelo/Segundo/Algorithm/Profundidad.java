package Modelo.Segundo.Algorithm;

import Modelo.Segundo.Grafo.Arco;
import Modelo.Segundo.Grafo.Grafo;
import Modelo.Segundo.Grafo.Nodo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Profundidad {

    private int time;
    int i = 0;
    List<ArrayList<Nodo>> adyacentes = new ArrayList<>();

    public void DephtFirst() {
        for (Nodo auxiliar : Grafo.nodos) {
            auxiliar.setColor("WHITE");
            auxiliar.setPadreID(0);
            auxiliar.setKey(0);
        }
        time = 0;
        for (Nodo auxiliar : Grafo.nodos) {
            if (auxiliar.getColor().equals("WHITE")) {
                DephtFirstVisit(auxiliar);
            }
        }
    }

    private void DephtFirstVisit(Nodo auxiliar) {
        time++;
        auxiliar.setD(time);
        auxiliar.setColor("GRAY");
        getAdyacentes(auxiliar);
        i++;
        System.out.println("adyacentes de ("+time+"): "+adyacentes);
        try{
            for (ArrayList<Nodo> lista : adyacentes) {
                for (Nodo recursivo: lista) {
                    if (recursivo.getColor().equals("WHITE")) {
                        recursivo.setPadreID(auxiliar.getId());
                        DephtFirstVisit(recursivo);
                    }
                }
                adyacentes.remove(0);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        auxiliar.setColor("BLACK");
        time++;
        auxiliar.setF(time);
    }

    private void getAdyacentes(Nodo actual) {
        adyacentes.add(new ArrayList<>());

        for (Arco auxiliar: Grafo.arcos) {
            if(auxiliar.getEmisor().getId() == actual.getId()){
                adyacentes.get(i).add(auxiliar.getDestino());
            }
        }
    }

}
