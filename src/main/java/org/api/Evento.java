package org.api;

import java.security.Timestamp;

/**
 * @author Martin Valiente Ainz
 */
public class Evento {
    private int id;
    private int fuenteId;
    private Timestamp fecha;
    private int valor;

    /**
     * Constructor de la clase Evento
     * @param id Identificador del evento
     * @param fuenteId Identificador de la fuente
     * @param fecha Fecha del evento
     * @param valor Valor del evento
     */
    public Evento(int id, int fuenteId, Timestamp fecha, int valor) {
        this.id = id;
        this.fuenteId = fuenteId;
        this.fecha = fecha;
        this.valor = valor;
    }

    /**
     * Devuelve el identificador del evento
     * @return Identificador del evento
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del evento
     * @param id Identificador del evento
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el identificador de la fuente del evento
     * @return Identificador de la fuente del evento
     */
    public int getFuenteId() {
        return fuenteId;
    }

    /**
     * Establece el identificador de la fuente del evento
     * @param fuenteId Identificador de la fuente del evento
     */
    public void setFuenteId(int fuenteId) {
        this.fuenteId = fuenteId;
    }

    /**
     * Devuelve la fecha del evento
     * @return Fecha del evento
     */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del evento
     * @param fecha Fecha del evento
     */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve el valor del evento
     * @return Valor del evento
     */
    public int getValor() {
        return valor;
    }

    /**
     * Establece el valor del evento
     * @param valor Valor del evento
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
}
