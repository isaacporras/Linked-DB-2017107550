package paquete1;



public class Store {
    private Nodo inicio;
    private Nodo fin;


    public Store() {

        inicio = null;
        fin = null;
    }

    public void insertar(Documentos dato, String nombre) {

        if (inicio == null) {
            inicio = new Nodo(null, dato,null,null, null, null, nombre);
            fin = inicio;

        } else {
            Nodo nuevo = new Nodo(null, dato,null,null, fin, null, nombre);
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }


    }


    //
//
//
//	}
//	public void insertarEnPosicion(Nodo buscado ) {
//		Nodo actual = inicio;
//
//	while (actual!= null) {
//		if (actual.getSiguiente() == buscado) {
//			actual.setSiguiente(buscado);
//			actual.getSiguiente().getSiguiente().setAnterior(buscado);
//			}
//		else {
//			actual = actual.getSiguiente();
//			}
//		}
//	}
    public void EliminarObjeto(Object dato) {
        Nodo actual = inicio;
        Nodo temporal = inicio.getSiguiente();
        if (inicio == fin && dato == inicio.getDato()) {
            inicio = fin = null;
        } else if (dato == inicio.getDato()) {
            inicio = inicio.getSiguiente();
        } else {
            while (temporal != null && temporal.getDato() != dato) {
                actual = actual.getSiguiente();
                temporal = temporal.getSiguiente();
            }
            if (temporal != null) {
                if (temporal.getSiguiente() != null) {
                    actual.setSiguiente(temporal.getSiguiente());
                    temporal.getSiguiente().setAnterior(actual);
                }
                if (temporal.getSiguiente() == null) {
                    actual.setSiguiente(temporal.getSiguiente());
                }
                if (temporal == fin) {
                    fin = actual;
                }
            }
            if (temporal == null) {
                System.out.println("No se encontro el dato :( ");
            }
        }
    }

    public void imprimir() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    public void imprimir_por_nombre() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.println(actual.getNombre());
            actual = actual.getSiguiente();

        }
    }

    public Nodo buscar_por_nombre(String nombre) {
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
//    }

//    public Nodo buscarStore(Object dato) {
//        Nodo actual = inicio.getSiguiente();
//
//        if(inicio.getDato() == dato) {
//
//            System.out.println("El dato fue encontrado:" + dato);
//            return actual;
//
//        }
//        while(actual != null & actual.getDato() != dato) {
//
//            actual = actual.getSiguiente();
//            if (actual == null) {
//                System.out.println("No se encotro el resultado");
//                return actual;
//
//            }
//        }
//        if (actual.getDato() == dato) {
//            System.out.println("El dato fue encontrado:" + dato);
//            return actual;
//        }
//        return actual;
//    }


