package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;
/**
 * Representa una reunión que se lleva a cabo de forma remota.
 * Hereda los atributos base de Reunion y añade un enlace de conexión.
 */
public class ReunionVirtual extends Reunion {

    private String enlace;

    /**
     * Constructor de la clase ReunionVirtual.
     * * @param fecha La fecha de la reunión.
     * @param horaPrevista La hora a la que se planea iniciar.
     * @param duracionPrevista La duración estimada.
     * @param organizador El empleado que organiza la reunión.
     * @param tipo El tipo de reunión (TECNICA, MARKETING, OTRO).
     * @param enlace El link para conectarse a la reunión virtual.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipo, String enlace) {
        // Llamada al constructor de la clase padre
        super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
        this.enlace = enlace;
    }

    /**
     * Obtiene el enlace de la reunión virtual.
     * @return El enlace de conexión.
     */
    public String getEnlace(){
        return enlace;
    }

    /**
     * Modifica el enlace de la reunión virtual.
     * @param enlace El nuevo enlace de conexión.
     */
    public void setEnlace(String enlace){
        this.enlace = enlace;
    }

    /**
     * Retorna una representación en texto de la reunión virtual.
     * @return String con los detalles de la reunión y su enlace.
     */
    @Override
    public String toString() {
        return "ReunionVirtual{" +
                "enlace='" + enlace + '\'' +
                ", fecha=" + getFecha() +
                ", tipo=" + getTipo() +
                '}';
    }
}