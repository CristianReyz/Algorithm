package Modelo.Segundo;

import java.util.Scanner;

public class grafoDemo {
    public static int cantidadVertices = 4;
    public static class Grafo{
        public int [] vertices = new int[grafoDemo.cantidadVertices];
        public int [][] arcos = new int[grafoDemo.cantidadVertices][grafoDemo.cantidadVertices];
    }

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Grafo grafo = new Grafo();
        Scanner entrada = new Scanner(System.in);
        int opcion,vertice,vertice2;

        do{
            System.out.println("Menú");
            System.out.println("1.- insertar vertice");
            System.out.println("2.- insertar arco");
            System.out.println("3.- eliminar vertice");
            System.out.println("4.- eliminar arco");
            System.out.println("5.- Desplegar matriz");
            System.out.println("6.- Salir");
            System.out.println("Ingresa una opción: ");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingresa el vertice");
                    vertice = entrada.nextInt();
                    insertarVertice(vertice,grafo);
                    break;
                case 2:
                    System.out.println("Ingresa el primer vértice a unir");
                    vertice = entrada.nextInt();
                    System.out.println("ingresa segundo vertice a unir");
                    vertice2 = entrada.nextInt();
                    insertarArco(vertice,vertice2,grafo);
                    break;
                case 3:
                    System.out.println("ingresa el vertice a eliminar");
                    vertice = entrada.nextInt();
                    eliminarVertice(vertice,grafo);
                    break;
                case 4:
                    System.out.println("ingresa primer vertice del arco");
                    vertice = entrada.nextInt();
                    System.out.println("ingresa segundo vertice del arco");
                    vertice2 = entrada.nextInt();
                    eliminarArco(vertice,vertice2,grafo);
                    break;
                case 5:
                    System.out.println("Vertices: ");
                    for(int i = 0; i<cantidadVertices; i++){
                        System.out.println("["+grafo.vertices[i]+"]");
                    }

                    System.out.println("Arcos: ");
                    for(int i = 0; i<cantidadVertices;i++){
                        for(int j = 0; j<cantidadVertices; j++){
                            System.out.println("["+grafo.arcos[i][j]+"]");
                        }

                    }
                    break;
                case 6:
                    break;

            }

        }while(opcion != 6);
    }

    public void inicializar(Grafo grafo){
        for(int i = 0; i<cantidadVertices;i++){
            grafo.vertices[i] = 0;
            for(int j = 0; j<cantidadVertices; j++){
                grafo.arcos[i][j] = 0;
            }
        }
    }

    public static void insertarVertice(int vertice, Grafo grafo){
        if(vertice >= 0 && vertice < cantidadVertices){
            grafo.vertices[vertice] = 1;
        }
    }


    public static int buscarVertice(int vertice,Grafo grafo){
        for(int i = 0; i<cantidadVertices; i++){
            if(grafo.vertices[vertice] == 1){
                return vertice;
            }
        }
        return -1;
    }

    public static void insertarArco(int v1, int v2, Grafo grafo){
        int vertice1, vertice2;
        vertice1 = buscarVertice(v1,grafo);
        if(vertice1 != -1){
            vertice2 = buscarVertice(v2,grafo);
            if(vertice2 != -1){
                grafo.arcos[v1][v2] = 1;
            }
            else{
                System.out.println("El vertice 2 no existe");
            }
        }
        else{
            System.out.println("El vertice 1 no existe");
        }
    }

    public static void eliminarArco(int v1, int v2, Grafo grafo){
        int vertice1, vertice2;
        vertice1 = buscarVertice(v1,grafo);
        if(vertice1 != -1){
            vertice2 = buscarVertice(v2,grafo);
            if(vertice2 != -1){
                grafo.arcos[v1][v2] = 0;
            }
            else{
                System.out.println("El vertice 2 no existe");
            }
        }
        else{
            System.out.println("El vertice 1 no existe");
        }
    }

    public static void eliminarVertice(int v1, Grafo grafo){
        int vertice1;
        vertice1 = buscarVertice(v1,grafo);
        if(vertice1 != -1){
            grafo.vertices[vertice1] = 0;
            for(int i = 0; i<cantidadVertices; i++){
                grafo.arcos[vertice1][i] = 0;
                grafo.arcos[i][vertice1] = 0;
            }
        }
        else{
            System.out.println("El vertice no existe");
        }
    }




}
