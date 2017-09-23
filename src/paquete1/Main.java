package paquete1;

import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        String nombre = "Nombre";
        JSONObject objeto = new JSONObject();
        objeto.put(nombre, "");
        objeto.put("Atributo","");

        System.out.println(objeto);
        objeto.replace(nombre,"", "Isaac");
        System.out.println(objeto);


    }
}