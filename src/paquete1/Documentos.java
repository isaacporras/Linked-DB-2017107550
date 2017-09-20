package paquete1;

import javafx.scene.control.TreeItem;

public class Documentos {
    private Object dato;
    private Nodo inicio;
    private Nodo fin;

    public Documentos() {
        inicio = null;
        fin = null;
    }

    public void ingresarDato(Objetos dato, String nombre) {


        if (inicio == null) {
            inicio = new Nodo(null,null ,dato,null,null, null, nombre, null);
            inicio.setSiguiente(inicio);
            inicio.setAnterior(fin);
            fin = inicio;

        }
        else {
            Nodo nuevo = new Nodo(dato,null,null,null,null,null, null, null);
            nuevo.setSiguiente(inicio);
            nuevo.setAnterior(fin);
            fin.setSiguiente(nuevo);
            inicio.setAnterior(nuevo);
            fin = nuevo;
        }
        this.imprimir();
    }
    public void imprimir() {
        Nodo actual = inicio;
        do{
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }while (actual != inicio);

    }
    public void EliminarObjeto(Object dato) {
        Nodo actual = inicio;
        Nodo temporal = inicio.getSiguiente();
        if (inicio == fin  &&  dato == inicio.getDato()){
            inicio = fin = null;
        }
        else if (dato == inicio.getDato()) {
            fin.setSiguiente(inicio.getSiguiente());
            inicio.getSiguiente().setAnterior(fin);
            inicio = inicio.getSiguiente();
        }
        else {
            while(temporal != inicio && temporal.getDato() != dato) {
                actual = actual.getSiguiente();
                temporal = temporal.getSiguiente();
            }
            if (temporal != inicio) {
                if (temporal.getSiguiente()!= inicio) {
                    actual.setSiguiente(temporal.getSiguiente());
                    temporal.getSiguiente().setAnterior(actual);
                }
                if (temporal.getSiguiente() == inicio) {
                    actual.setSiguiente(temporal.getSiguiente());
                    temporal.getSiguiente().setAnterior(actual);
                    fin = actual;
                }
            }
            if (temporal == inicio ) {
                System.out.println("No se encontro el dato :( ");
            }
        }
    }
    public void buscarDoc(Object dato) {
        Nodo actual = inicio.getSiguiente();
//		if(inicio.getDato() == dato) {
//			System.out.println("El dato fue encontrado:" + dato);
//		}
        while(actual != inicio & actual.getDato() != dato) {
            actual = actual.getSiguiente();
        }
        if (actual.getDato() == dato) {
            System.out.println("El dato fue encontrado:" + dato);
        }
        else {
            System.out.println("El dato no fue encontrado");
        }
    }

    public Nodo buscar_por_nombre_Documentos(String nombre) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.getNombre().equals(nombre)) {
                return actual;
            } else {
                actual = actual.getSiguiente();
            }
        }
        return null;
    }
}
