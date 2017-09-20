package paquete1;

import org.json.simple.JSONObject;
import org.json.simple.*;


public class Main {
    public String nombre;
    public int edad;

    public static void main(String[] args) {
        Objetos objetos = new Objetos();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Llave: ","Oscar");
        objetos.ingresarDato(jsonObject);

        System.out.println("La lista de objetos es:");
        objetos.imprimirObjectos();
        objetos.eliminarObjeto("Oscar");
        System.out.println("La lista de objetos es:");
        objetos.imprimirObjectos();
//        Store stor = new Store();
//        stor.insertar(null,"Isaac");
//        stor.insertar(null,"oscar");
//        stor.insertar(null,"pamela");
//        stor.insertar(null,"jason");
//
//    public static Object EncodeJSON(String nombre, int edad) {
//        JSONObject obj = new JSONObject();
//        obj.put("Name:",nombre);
//        obj.put("Edad:",edad);
//
//        return obj;
//        Documentos doc = new Documentos();
//        doc.ingresarDato("Dato 1");
//        doc.ingresarDato("Dato 2");
//        doc.ingresarDato("Dato 3");
//        doc.ingresarDato("Dato 4");
//
//        System.out.println("------------------------");
//        System.out.println("------------------------");
//        System.out.println("------------------------");
//
//        Store store = new Store();
//        store.insertar(doc,"Documento");
//        store.buscar_por_nombre("Documento").getDato_Store().imprimir();
    }
}

