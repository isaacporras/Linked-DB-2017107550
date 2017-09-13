package paquete1;
public class Nodo {
    private Nodo siguiente;
    private Nodo anterior;
    private Object dato;
    private Documentos dato_Store;
    private String nombre;

    public Nodo(Object dat,Documentos dato_str, Nodo ant, Nodo sig,String nom) {
        dato_Store = dato_str;
        nombre = nom;
        dato = dat;
        anterior = ant;
        siguiente = sig;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Object getDato() {
        return dato;
    }

    public Documentos getDato_Store() {
        return dato_Store;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public void setNombre(String nombre) {
        this.dato = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setDato_Store(Documentos doc){
        this.dato_Store = doc;
    }
}




