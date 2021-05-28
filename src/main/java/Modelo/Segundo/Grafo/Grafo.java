package Modelo.Segundo.Grafo;

import Vista.SegundoParcial;

import java.util.*;

public class Grafo {
    public static List<Nodo> nodos = new LinkedList<>();
    public static List<Arco> arcos = new ArrayList<>();

    public static List<ArrayList<Integer>> matrix = new ArrayList<>();

   public void buildInitialMatrix(){
        for (int i = 0; i < nodos.size(); i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < nodos.size(); j++) {
                matrix.get(i).add(j,0);
            }
        }
    }
    public static int autoIncrementId = 1;

    //
    public void addNodo(int valor){
        Nodo nodo = new Nodo(valor);
        //primero se crea la fila vacia
        matrix.add(new ArrayList<>());
        for (int j = 0; j <= nodos.size(); j++) {
            matrix.get(nodos.size()).add(j,0);
        }
        for (int i = 0; i <= nodos.size()-1; i++) {
            matrix.get(i).add(nodos.size(),0);
        }
        nodos.add(nodo);
        nodo.setId(autoIncrementId);
        autoIncrementId++;
    }

    public void deshabilitarNodo(int id){
        //se recorre el array para buscar el nodo
        for (Nodo auxiliar: nodos) {
            //en caso de encontrarlo
            if(auxiliar.getId() == id){
                // se cambian (columnas)
                for (int i = 0; i <= nodos.size()-1; i++) {
                    if(matrix.get(i).get(id-1) == 1){
                        matrix.get(i).set(id-1,7);
                    }else if(matrix.get(i).get(id-1) == 0){
                        matrix.get(i).set(id-1,9);
                    }
                }
                //se cambia la fila
                for (int j = 0; j < nodos.size(); j++) {
                    if(matrix.get(id-1).get(j) == 1){
                        matrix.get(id-1).set(j,7);
                    }else if(matrix.get(id-1).get(j) == 0){
                        matrix.get(id-1).set(j,9);
                    }
                }
                //se cambia el id multiplicando x -1 para marcar como inhabil
                nodos.get(id-1).setId(nodos.get(id-1).getId() * -1);
                //nodos.remove(auxiliar);
                break;
            }
        }
    }



    public void deleteNodo(int id) {
        //se recorre el array para buscar el nodo
        for (Nodo auxiliar: nodos) {
            //en caso de encontrarlo
            if(auxiliar.getId() == id){
                // se eliminan (columnas)

                for (int i = 0; i <= nodos.size()-1; i++) {
                    matrix.get(i).remove(nodos.size()-1);
                }
                //se elimina la fila
                matrix.remove(id-1);
                nodos.remove(auxiliar);
                autoIncrementId--;
                break;
            }else{
                System.out.println("no existe"+ auxiliar.getId()+" id: "+id);
            }
        }

    }

    public String addArcoDirigidoPesado(int emisor, int destino, int peso){
        Arco arco = new Arco();
        boolean banderaEmisor = false;
        boolean banderaDestino = false;
        //buscar si existen los nodos a unirse

        for (Nodo auxiliar : nodos) {
            if(auxiliar.getId() == destino){
                arco.setDestino(auxiliar);
                banderaDestino = true;
                break;
            }
        }
        for (Nodo auxiliar: nodos) {
            if(auxiliar.getId() == emisor){
                arco.setEmisor(auxiliar);
                banderaEmisor = true;
                break;
            }
        }
        if(banderaEmisor){
            if(banderaDestino){
                //armar arco si y solo si los dos nodos existen, se hizo anidado para retornar un mensaje mas detallado

                arco.setPeso(peso);
                arcos.add(arco);
                matrix.get(emisor-1).set(destino-1,1);
                return "\n"+arco;

            }else{
                return ("No se encontro el nodo destino");
            }
        }else{
            return ("No se encontro el nodo emisor");
        }
    }

    public String addArcoDirigidoNoPesado(int emisor, int destino){
        Arco arco = new Arco();
        boolean banderaEmisor = false;
        boolean banderaDestino = false;
        //buscar si existen los nodos a unirse

        for (Nodo auxiliar : nodos) {
            if(auxiliar.getId() == destino){
                arco.setDestino(auxiliar);
                banderaDestino = true;
                break;
            }
        }
        for (Nodo auxiliar: nodos) {
            if(auxiliar.getId() == emisor){
                arco.setEmisor(auxiliar);
                banderaEmisor = true;
                break;
            }
        }
        if(banderaEmisor){
            if(banderaDestino){
                //armar arco si y solo si los dos nodos existen, se hizo anidado para retornar un mensaje mas detallado
                Grafo.arcos.add(arco);
                matrix.get(emisor-1).set(destino-1,1);
                return arco+" ";
            }else{
                return ("No se encontro el nodo destino");
            }
        }else{
            return ("No se encontro el nodo emisor");
        }
    }

    public String addArcoNoDirigidoPesado(int emisor, int destino, int peso){
        Arco arco = new Arco();
        Arco arcoInverso = new Arco();
        boolean banderaEmisor = false;
        boolean banderaDestino = false;
        //buscar si existen los nodos a unirse

        for (Nodo auxiliar : nodos) {
            if(auxiliar.getId() == destino){
                arco.setDestino(auxiliar);
                arcoInverso.setEmisor(auxiliar);
                banderaDestino = true;
                break;
            }
        }
        for (Nodo auxiliar: nodos) {
            if(auxiliar.getId() == emisor){
                arco.setEmisor(auxiliar);
                arcoInverso.setDestino(auxiliar);
                banderaEmisor = true;
                break;
            }
        }
        if(banderaEmisor){
            if(banderaDestino){
                //armar arco si y solo si los dos nodos existen, se hizo anidado para retornar un mensaje mas detallado

                arco.setPeso(peso);
                arcoInverso.setPeso(peso);
                Grafo.arcos.add(arco);
                Grafo.arcos.add(arcoInverso);
                matrix.get(emisor-1).set(destino-1,1);
                matrix.get(destino-1).set(emisor-1,1);
                return arco+" "+arcoInverso;
            }else{
                return ("No se encontro el nodo destino");
            }
        }else{
            return ("No se encontro el nodo emisor");
        }
    }

    public String addArcoNoDirigidoNoPesado(int emisor, int destino){
        Arco arco = new Arco();
        Arco arcoInverso = new Arco();
        boolean banderaEmisor = false;
        boolean banderaDestino = false;
        //buscar si existen los nodos a unirse

        for (Nodo auxiliar : nodos) {
            if(auxiliar.getId() == destino){
                arco.setDestino(auxiliar);
                arcoInverso.setEmisor(auxiliar);
                banderaDestino = true;
                break;
            }
        }
        for (Nodo auxiliar: nodos) {
            if(auxiliar.getId() == emisor){
                arco.setEmisor(auxiliar);
                arcoInverso.setEmisor(auxiliar);
                banderaEmisor = true;
                break;
            }
        }
        if(banderaEmisor){
            if(banderaDestino){
                //armar arco si y solo si los dos nodos existen, se hizo anidado para retornar un mensaje mas detallado
                arco.setPeso(0);
                arcoInverso.setPeso(0);
                Grafo.arcos.add(arco);
                Grafo.arcos.add(arcoInverso);
                matrix.get(emisor-1).set(destino-1,1);
                matrix.get(destino-1).set(emisor-1,1);
                return arco + arcoInverso.toString();
            }else{
                return ("No se encontro el nodo destino");
            }
        }else{
            return ("No se encontro el nodo emisor");
        }
    }

    public String deleteArcoNoPesado(int emisor, int destino){
        int i = 0;
        for (Arco auxiliar: arcos) {
            if(SegundoParcial.digrafo){
                if(auxiliar.getEmisor().getId() == emisor && auxiliar.getDestino().getId() == destino){
                    arcos.remove(i);
                    matrix.get(emisor-1).set(destino-1,0);
                    break;
                }
            }else{
                if(auxiliar.getEmisor().getId() == emisor && auxiliar.getDestino().getId() == destino){
                    arcos.remove(i);
                    arcos.remove(i);
                    matrix.get(emisor-1).set(destino-1,0);
                    matrix.get(destino-1).set(emisor-1,0);
                    break;
                }
            }
            i++;
        }
        return arcos.toString();
    }






    private int busquedaBinaria(int busqueda){
        int izquierda = 0, derecha = nodos.size() - 1;

        while(izquierda <= derecha){
            // Calculamos las mitades...
            int indiceDelElementoDelMedio = (int) Math.floor((izquierda + derecha) / 2);
            Nodo elementoDelMedio = nodos.get(indiceDelElementoDelMedio);

            // Ver si está en la mitad y romper aquí el ciclo
            if(elementoDelMedio.getId() == busqueda){
                return indiceDelElementoDelMedio;
            }
            // Si no, entonces vemos si está a la izquierda o derecha

            if(busqueda < elementoDelMedio.getId()){
                derecha = indiceDelElementoDelMedio - 1;
            }else{
                izquierda = indiceDelElementoDelMedio + 1;
            }
        }
        // Si no se rompió el ciclo ni se regresó el índice, entonces el elemento no existe
        return -1;
    }

}
