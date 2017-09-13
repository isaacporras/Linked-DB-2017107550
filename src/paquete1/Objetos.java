package paquete1;



public class Objetos {
    private Object dato;
    private Nodo fin;
    private Nodo inicio;

    public Objetos() {
        inicio =  null;
        fin = null;
    }
    public void ingresarDato(Object dato) {
        if (inicio == null) {
            inicio = new Nodo(dato,null,null,null,null,null,null);
            fin = inicio;
        }
        else {
            Nodo nuevo = new Nodo(dato,null,null,null, null,null, null);
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
    public void EliminarObjeto(Object dato) {
        Nodo actual = inicio;
        Nodo temporal = inicio.getSiguiente();
        if (inicio == fin &&  dato == inicio.getDato()){
            inicio = fin = null;
        }
        else if (dato == inicio.getDato()) {
            inicio = inicio.getSiguiente();
        }
        else {
            while(temporal != null && temporal.getDato() != dato) {
                actual = actual.getSiguiente();
                temporal = temporal.getSiguiente();
            }
            if (temporal != null) {
                actual.setSiguiente(temporal.getSiguiente());
                if (temporal == fin) {
                    fin = actual;
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
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }

    }
}
