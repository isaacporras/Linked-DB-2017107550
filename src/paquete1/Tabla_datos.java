package paquete1;

import javafx.beans.property.SimpleStringProperty;


/**
 * Clase que crea establece los datos de la tabla
 */

public  class Tabla_datos{


    public final SimpleStringProperty Nombre;
    public final SimpleStringProperty Tipo;
    public final SimpleStringProperty Llave;
    /**
     * inicializa los datos de la tabla
     */
    public Tabla_datos(String Name, String tipo, String llave) {
        this.Nombre = new SimpleStringProperty(Name);
        this.Tipo = new SimpleStringProperty(tipo);
        this.Llave = new SimpleStringProperty(llave);
    }

    /**
     * da el nombre de la tabla
     * @return nombre
     */
    public String getNombre() {
        return Nombre.get();
    }

    /**
     * establece el nombre de la tabla
     * @param nombre nombre de la tabla a establecer
     */
    public void setNombre(String nombre) {
        this.Nombre.set(nombre);
    }

    /**
     * Agarra el nombre
     * @return nombre
     */
    public SimpleStringProperty nombreProperty() {
        return Nombre;
    }

    /**
     * da el tipo de la tabla
     * @return tipo
     */
    public String getTipo() {
        return Tipo.get();
    }

    /**
     * establece el tipo de la tabla
     * @param tipo tipo de la tabla
     */
    public void setTipo(String tipo) {
        this.Tipo.set(tipo);
    }

    /**
     * da el tipo de la tabla
     * @return tipo
     */
    public SimpleStringProperty tipoProperty() {
        return Tipo;
    }

    /**
     * da la llave de la tabla
     * @return llave
     */
    public String getLlave() {
        return Llave.get();
    }

    /**
     * establece la llave de la tabla
     */
    public void setLlave(String llave) {
        this.Llave.set(llave);
    }

    /**
     * retorna la llave de la tabla
     * @return llave
     */
    public SimpleStringProperty llaveProperty() {
        return Llave;
    }


}