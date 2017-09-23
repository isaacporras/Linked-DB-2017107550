package paquete1;

import javafx.scene.layout.Pane;
import org.json.simple.JSONObject;

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

    public Nodo(Object dat, Documentos dato_str, Objetos obj_documentos, JSONObject objeto_json, Nodo ant, Nodo sig, String nom ,String padre, String nombre_atr , String tipo_atr , String llave_prim , String llave_fora) {
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
        return this.dato_Store;
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
    public JSONObject getDato_JSON(){
        return this.objeto_JSON;
    }
    public String get_Padre_documento(){
        return this.Padre;
    }
    public void set_padre_documento(String padre){
        this.Padre = padre;
    }

    public String getNombre_atributo() {
        return nombre_atributo;
    }

    public void setNombre_atributo(String nombre_atributo) {
        this.nombre_atributo = nombre_atributo;
    }

    public String getLlave_foranea() {
        return llave_foranea;
    }

    public void setLlave_foranea(String llave_foranea) {
        this.llave_foranea = llave_foranea;
    }
    public String getTipo_atributo(){
        return this.tipo_atributo;
    }
    public String getLlave_primaria(){
        return this.llave_primaria;
    }
}