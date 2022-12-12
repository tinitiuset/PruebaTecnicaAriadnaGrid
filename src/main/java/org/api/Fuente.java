package org.api;

/**
 * @author Martin Valiente Ainz
 */
public class Fuente {
    private int id;
    private String nombre;

    /**
     * Constructor de la clase Fuente
     * @param id Identificador de la fuente
     * @param nombre Nombre de la fuente
     */
    public Fuente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre de la fuente
     * @return Nombre de la fuente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la fuente
     * @param nombre Nombre de la fuente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el identificador de la fuente
     * @return  Identificador de la fuente
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la fuente
     * @param id Identificador de la fuente
     */
    public void setId(int id) {
        this.id = id;
    }
}
