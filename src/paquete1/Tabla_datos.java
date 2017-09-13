package paquete1;

import javafx.beans.property.SimpleStringProperty;



public  class Tabla_datos{

    public final SimpleStringProperty Nombre;
    public final SimpleStringProperty Tipo;
    public final SimpleStringProperty Llave;

    public Tabla_datos(String Name, String tipo, String llave) {
        this.Nombre = new SimpleStringProperty(Name);
        this.Tipo = new SimpleStringProperty(tipo);
        this.Llave = new SimpleStringProperty(llave);
    }

    public String getNombre() {
        return Nombre.get();
    }

    public void setNombre(String nombre) {
        this.Nombre.set(nombre);
    }

    public SimpleStringProperty nombreProperty() {
        return Nombre;
    }

    public String getTipo() {
        return Tipo.get();
    }

    public void setTipo(String tipo) {
        this.Tipo.set(tipo);
    }

    public SimpleStringProperty tipoProperty() {
        return Tipo;
    }

    public String getLlave() {
        return Llave.get();
    }

    public void setLlave(String llave) {
        this.Llave.set(llave);
    }

    public SimpleStringProperty llaveProperty() {
        return Llave;
    }
}
