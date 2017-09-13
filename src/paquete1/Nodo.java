package paquete1;

import org.json.simple.JSONObject;

public class Nodo {
    private Nodo siguiente;
    private Nodo anterior;
    private Object dato;
    private Documentos dato_Store;
    private String nombre;
    private  Objetos dato_objetos;
    private JSONObject objeto_JSON;

    public Nodo(Object dat, Documentos dato_str, Objetos obj_documentos, JSONObject objeto_json, Nodo ant, Nodo sig, String nom) {
        dato_Store = dato_str;
        nombre = nom;
        dato = dat;
        anterior = ant;
        siguiente = sig;
        dato_objetos = obj_documentos;
        objeto_JSON = objeto_json;
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
    public Objetos getDato_Documento() {
        return dato_objetos;
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
    public void setDato_Documento(Objetos objet){
        this.dato_objetos = objet;
    }
    public void setDato_objetos(JSONObject objt){
        this.objeto_JSON = objt;
    }
}




