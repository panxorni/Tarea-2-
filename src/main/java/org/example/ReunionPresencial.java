package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;

/**
 * Representa una reunión que se lleva a cabo presencialmente.
 * Hereda los atributos base de Reunion y añade una sala específica.
 */
public class ReunionPresencial extends Reunion {

    private String sala;

    /**
     * Constructor de la clase ReunionPresencial.
     * * @param fecha La fecha de la reunión.
     * @param horaPrevista La hora a la que se planea iniciar.
     * @param duracionPrevista La duración estimada.
     * @param organizador El empleado que organiza la reunión.
     * @param tipo El tipo de reunión (TECNICA, MARKETING, OTRO).
     * @param sala El nombre o identificador de la sala física.
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipo, String sala) {
        // Llamada al constructor de la clase padre
        super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
        this.sala = sala;
    }

    /**
     * Obtiene la sala de la reunión presencial.
     * @return El nombre de la sala.
     */
    public String getSala() {
        return sala;
    }

    /**
     * Modifica la sala de la reunión presencial.
     * @param sala El nuevo nombre de la sala.
     */
    public void setSala(String sala) {
        this.sala = sala;
    }

    /**
     * Retorna una representación en texto de la reunión presencial.
     * @return String con los detalles de la reunión y su sala.
     */
    @Override
    public String toString() {
        return "ReunionPresencial{" +
                "sala='" + sala + '\'' +
                ", fecha=" + getFecha() +
                ", tipo=" + getTipo() +
                '}';
    }
}