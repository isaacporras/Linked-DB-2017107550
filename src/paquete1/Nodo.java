package paquete1;

import javafx.scene.layout.Pane;
import org.json.simple.JSONObject;

/**
 * Es la clase nodo que crea los nodos para las listas de documentos, objetos y store
 */
public class Nodo {
    private Nodo siguiente;
    private Nodo anterior;
    private Object dato;
    private Documentos dato_Store;
    private String nombre;
    private  Objetos dato_objetos;
    private JSONObject objeto_JSON;
    private String Padre;
    private String nombre_atributo;
    private String tipo_atributo;
    private String llave_primaria;
    private String llave_foranea;
    private  String nombre_del_atr;

    /**
     * inicializa la estructura del nodo
     * @param dat el dato del nodo
     * @param dato_str lista documento
     * @param obj_documentos lista de objetos
     * @param objeto_json JSON object que se ingresa en el nodo
     * @param ant el anterior del nodo
     * @param sig el siguiente del nodo
     * @param nom el nombre del nodo
     * @param padre el padre del nodo
     * @param nombre_atr el nombre del atributo del nodo
     * @param tipo_atr el tipo del atributo del nodo
     * @param llave_prim la llave primaria del nodo
     * @param llave_fora la llave foranea del nodo
     * @param nombre_del_atributo el nombre del atributo del nodo
     */
    public Nodo(Object dat, Documentos dato_str, Objetos obj_documentos, JSONObject objeto_json, Nodo ant, Nodo sig, String nom ,String padre, String nombre_atr , String tipo_atr , String llave_prim , String llave_fora, String nombre_del_atributo) {
        dato_Store = dato_str;
        nombre = nom;
        dato = dat;
        anterior = ant;
        siguiente = sig;
        dato_objetos = obj_documentos;
        objeto_JSON = objeto_json;
        Padre = padre;
        nombre_atributo = nombre_atr;
        tipo_atributo = tipo_atr;
        llave_primaria = llave_prim;
        llave_foranea = llave_fora;
        nombre_del_atr = nombre_del_atributo;

    }
    /**
     * da el siguiente de algun nodo
     */

    public Nodo getSiguiente() {
        return siguiente;

    }
    /**
     * crea el siguiente de un nodo
     * @param siguiente el nodo siguiente
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * crea el anterior de un nodo
     * @param anterior el anterior del nodo
     */

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    /**
     * da el dato del nodo
     * @return el dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * da el dato del store
     * @return el dato del store
     */

    public Documentos getDato_Store() {
        return this.dato_Store;
    }

    /**
     * mete una lista de documentos al store
     * @param doc
     */

    public void setDato_Store(Documentos doc){
        this.dato_Store = doc;
    }

    /**
     * da el dato del documento
     * @return el dato del documento
     */


    public Objetos getDato_Documento() {
        return dato_objetos;
    }

    /**
     * da el nombre del nodo
     * @return nombre
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * da el dato del JSON
     * @return OBJECT JSON
     */

    public JSONObject getDato_JSON(){
        return this.objeto_JSON;
    }


    /**
     * Da el nombre del atributo
     * @return el nombre del atributo
     */
    public String getNombre_atributo() {
        return nombre_atributo;
    }

    /**
     * da la llave foranea
     * @return llave foranea
     */


    public String getLlave_foranea() {
        return llave_foranea;
    }


    /**
     * da el tipo del atributo
     * @return el tipo del atributo
     */

    public String getTipo_atributo(){
        return this.tipo_atributo;
    }

    /**
     * da la llave primaria del atributo
     * @return llave primaria
     */

    public String getLlave_primaria(){
        return this.llave_primaria;
    }

    /**
     * da el nombre del atributo
     * @return nombre del atributo
     */

    public String getNombre_del_atr() {
        return nombre_del_atr;
    }

}