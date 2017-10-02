package paquete1;


/**
 * Clase Store que crea la lista doblemente enlazada
 */
public class Store {
    private Nodo inicio;
    private Nodo fin;

    /**
     * inicializa la lista
     */

    public Store() {

        inicio = null;
        fin = null;
    }

    /**
     * inserta un nodo en la lista de documentos
     * @param dato el dat del nodo
     * @param nombre el nombre del nodo
     */
    public void insertar(Documentos dato, String nombre) {

        if (inicio == null) {
            inicio = new Nodo(null, dato,null,null, null, null, nombre, null, null, null, null ,null, null);
            fin = inicio;

        } else {
            Nodo nuevo = new Nodo(null, dato,null,null, fin, null, nombre, null, null, null, null ,null, null);
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }


    }

    /**
     * imprime los datos del store
     */
    public void imprimir_por_nombre() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.println(actual.getNombre());
            actual = actual.getSiguiente();

        }
    }

    /**
     * busca en la lista un nodo con el nombre ingresado
     * @param nombre nombre a buscar
     * @return nodo encontrado con el nombre ingresado
     */

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
