package Modelo.Segundo.Grafo;

public class Nodo implements Comparable<Nodo>{
    private int id;
    private int valor; //esto se puede reemplazar por un genérico

    //para algoritmos y armar árbol
    private String color;
    private int d;
    private int f;
    private int padreID;
    private Nodo padre;
    private int key;

    public Nodo(int valor){
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getPadreID() {
        return padreID;
    }

    public void setPadreID(int padreID) {
        this.padreID = padreID;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }






        @Override
        public boolean equals(Object objeto) {
            if (!(objeto instanceof Nodo)) {
                return false;
            }
            Nodo nodo = (Nodo) objeto;
            return this.id == nodo.getId();
        }

        @Override
        public int hashCode() {
            return this.id;
        }

        @Override
        public String toString() {
        // "ID \t padre \t color \t D \t F \tKey \n");
            return id+" \t "+ padreID +" \t "+color+" \t "+d+" \t "+f+" \t "+key+ "\n";
        }

        //para la cola de prioridad por valor del nodo
        @Override
        public int compareTo(Nodo comparable) {
            return Integer.compare(this.getKey(), comparable.getKey());
        }
}
