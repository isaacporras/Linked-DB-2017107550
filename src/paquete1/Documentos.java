package paquete1;


/**
 * Clase que maneja todas las operaciones de la lista doblemente enlazada documentos
 */
public class Documentos {

    private Nodo inicio;
    private Nodo fin;
    private String nombre_lista;
    private String llave_1;
    private String llave_2;

    /**
     * Inicializa la lista de documentos
     */
    public Documentos() {
        inicio = null;
        fin = null;
    }

    /**
     * Ingresa un nodo a la lista
     * @param dato el dato que contiene el nodo
     * @param nombre el nombre del nodo
     * @param nombre_atr el nombre del atributo del nodo
     * @param tipo_atr el tipo del atributo del nodo
     * @param llave_prim la llave primaria del nodo
     * @param llave_fora la llave foranea del nodo
     * @param nombre_atributo el nombre del atributo del nodo
     */
    public void ingresarDato(Objetos dato, String nombre , String nombre_atr , String tipo_atr , String llave_prim , String llave_fora, String nombre_atributo) {


        if (inicio == null) {
            inicio = new Nodo(null,null ,dato,null,null, null, nombre, null, nombre_atr, tipo_atr, llave_prim ,llave_fora,nombre_atributo);
            inicio.setSiguiente(inicio);
            inicio.setAnterior(fin);
            fin = inicio;
            nombre_lista = nombre_atr;
            llave_1 = llave_prim;
            llave_2 = llave_fora;


        }
        else {
            Nodo nuevo = new Nodo(null,null,dato,null,null,null, nombre, null,nombre_atr, tipo_atr, llave_prim ,llave_fora, nombre_atributo);
            nuevo.setSiguiente(inicio);
            nuevo.setAnterior(fin);
            fin.setSiguiente(nuevo);
            inicio.setAnterior(nuevo);
            fin = nuevo;
        }
        this.imprimir();
    }

    /**
     * metodo que enseña los nodos de la lista Documentos
     */
    public void imprimir() {

        Nodo actual = inicio;
        do{
            System.out.println(actual.getDato_Documento());
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

    /**
     * Busca nodos dentro de la lista por el nombre
     * @param nombre el nombre del nodo que se busca
     * @return retonra el nodo que tiene como atributo ese nodo
     */

    public Nodo buscar_por_nombre_Documentos(String nombre) {
        Nodo actual = inicio.getSiguiente();
        System.out.println();
        System.out.println("el nombre del inicio es :"+inicio.getNombre());

        if (inicio.getNombre().equals(nombre)){
            return inicio;
        }

        while (actual != inicio) {
            if (inicio.getNombre().equals(nombre)){
                return inicio;
            }
            if (actual.getNombre().equals(nombre)) {
                return actual;
            }
            else {
                actual = actual.getSiguiente();
            }
        }
        return null;
    }

    /**
     * metodo que da el nombre de la  lista
     * @return nombre de la lista
     */

    public String getNombre_lista() {
        return nombre_lista;
    }

    /**
     * metodo que da la llave primaria de la lista
     * @return llave primaria
     */
    public String getLlave_1() {
        return llave_1;
    }

    /**
     * metodo que da la llave foranea de la lista
     * @return llave foranea
     */
    public String getLlave_2() {
        return llave_2;
    }
}