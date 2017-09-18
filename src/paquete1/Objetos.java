package paquete1;


import org.json.simple.JSONObject;

public class Objetos {
    private Object dato;
    private Nodo fin;
    private Nodo inicio;

    public Objetos() {
        inicio =  null;
        fin = null;
    }
    public void ingresarDato(JSONObject dato) {
        if (inicio == null) {
            inicio = new Nodo(null,null,null,dato,null,null,null, null);
            fin = inicio;

        }
        else {
            Nodo nuevo = new Nodo(null,null,null,dato, null,null, null, null);
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
    public void eliminarObjeto(String llave) {
        System.out.println("El objeto buscado es: " + llave);
        Nodo actual = inicio;
        Nodo temporal = inicio.getSiguiente();
        System.out.println("--------------------");
        System.out.println("El dato del primer nodo es: "+ actual.getDato_JSON().get("Llave: ").toString());
        if (inicio == fin &&  llave.equals(inicio.getDato_JSON().get("Llave: ").toString())){
            inicio = fin = null;
            System.out.println("El objeto fue eliminado");
            return;
        }
        else if (llave.equals(inicio.getDato_JSON().get("Llave: ").toString())) {
            inicio = inicio.getSiguiente();
            System.out.println("El objeto fue eliminado");
        }
        else {
            while(temporal != null && !temporal.getDato_JSON().get("Llave: ").toString().equals(llave)) {
                System.out.println(temporal.getDato_JSON().get("Llave: ").toString());
                actual = actual.getSiguiente();
                temporal = temporal.getSiguiente();
            }
            if (temporal != null) {
                actual.setSiguiente(temporal.getSiguiente());
                if (temporal == fin) {
                    fin = actual;
                    System.out.println("El objeto fue eliminado");
                }
            }
            if (temporal == null) {
                System.out.println("No se encontro el dato :( ");
            }
        }
    }
    public void buscarObj(Object dato) {
        Nodo actual = inicio;
        Nodo temporal = inicio.getSiguiente();
        if (dato == inicio.getDato()){
            System.out.println("El resultado fue encontrado:"+ dato);
        }
        else {
            while(temporal != null && temporal.getDato() != dato) {
                actual = actual.getSiguiente();
                temporal = temporal.getSiguiente();
            }
            if (temporal != null) {
                System.out.println("El dato fue encontrado:" +  dato);
            }
        }
        if (temporal == null) {
            System.out.println("No se encontro el dato :( ");
        }
    }
    public void imprimirObjectos(){
        Nodo actual = inicio;

        while(actual!= null){
            System.out.println(actual.getDato_JSON());
            actual = actual.getSiguiente();
        }
    }
    public Nodo dar_inicio(){
        return this.inicio;

    }
    public void eliminar_todos_los_Objetos(){
        inicio = null;
        fin = null;
        inicio = fin;
    }
}