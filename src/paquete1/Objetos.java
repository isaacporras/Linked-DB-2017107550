package paquete1;

import org.json.simple.JSONObject;

/**
 * Clase que hace la lista de objetos
 */

public class Objetos {
    private Object dato;
    private Nodo fin;
    private Nodo inicio;

    /**
     * inicializa la lista de objetos
     */
    public Objetos() {
        inicio =  null;
        fin = null;
    }

    /**
     * ingresa un dato (nodo) a la lista de objetos
     * @param dato el dato que se quiere ingresar
     */
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

    /**
     * Elimina un nodo de la lista de objetos por llave
     * @param llave la llave primaria del nodo a buscar
     */
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

    /**
     * imprime todos los datos de la lista de objetos
     */
    public void imprimirObjectos(){
        Nodo actual = inicio;

        while(actual!= null){
            System.out.println(actual.getDato_JSON());
            actual = actual.getSiguiente();
        }
    }

    /**
     * da el nodo inicial de la lista de objetos
     * @return el inicio de la lista
     */
    public Nodo dar_inicio(){
        return this.inicio;

    }

    /**
     * elimina todos los objetos de la lista
     */
    public void eliminar_todos_los_Objetos(){
        inicio = null;
        fin = null;
        inicio = fin;
    }
}