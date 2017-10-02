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
            inicio = new Nodo(null,null,null,dato,null,null,null, null, null, null, null ,null, null);
            fin = inicio;

        }
        else {
            Nodo nuevo = new Nodo(null,null,null,dato, null,null, null, null, null, null, null ,null, null);
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
    public void eliminarObjeto(String llave) {
        System.out.println("El objeto buscado es: " + llave);
        Nodo actual = inicio;
        Nodo temporal = inicio.getSiguiente();
        System.out.println("--------------------");
        System.out.println("El dato del primer nodo es: " + actual.getDato_JSON().get("Llave: ").toString());

        if (inicio == fin &&  llave.equals(inicio.getDato_JSON().get("Llave: ").toString()) || inicio == fin && llave.equals(inicio.getDato_JSON().get("Tipo").toString())){
            inicio = fin = null;
            System.out.println("El objeto fue eliminado");
            return;
        }
        if (llave.equals(inicio.getDato_JSON().get("Llave: ").toString()) || llave.equals(inicio.getDato_JSON().get("Tipo").toString())) {
            inicio = inicio.getSiguiente();
            System.out.println("El objeto fue eliminado");
        }
        else {
            while(temporal != null ) {

                if (temporal.getDato_JSON().get("Llave: ").toString().equals(llave) || temporal.getDato_JSON().get("Tipo").toString().equals(llave)){

                    actual.setSiguiente(temporal.getSiguiente());
                    temporal = null;
                }
                else{
                    temporal = temporal.getSiguiente();
                }
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