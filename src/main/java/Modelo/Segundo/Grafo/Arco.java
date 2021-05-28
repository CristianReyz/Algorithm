package Modelo.Segundo.Grafo;

public class Arco implements Comparable<Arco>{
    private int peso;
    private Nodo emisor;
    private Nodo destino;

    public Nodo getEmisor() {
        return emisor;
    }

    public void setEmisor(Nodo emisor) {
        this.emisor = emisor;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object objeto) {
        if (!(objeto instanceof Arco)) {
            return false;
        }
        Arco arco = (Arco) objeto;
        return this.peso == arco.getPeso();
    }

    @Override
    public int hashCode() {
        return this.peso;
    }

    @Override
    public String toString() {
        return "emisor=" + emisor.getId() + ", destino=" + destino.getId()+", peso=" + peso+"\n";
    }

    @Override
    public int compareTo(Arco comparable) {
        return Integer.compare(this.getPeso(), comparable.getPeso());
    }
}
