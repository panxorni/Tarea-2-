package org.example;

/**
 * Excepción lanzada cuando se intenta finalizar o calcular el tiempo real
 * de una reunión que nunca comenzó (no tiene una hora de inicio registrada).
 */
public class ReunionNoIniciadaException extends ReunionException {

    /**
     * Constructor para la excepción de reunión no iniciada.
     * * @param mensaje El detalle del error al requerir un inicio previo inexistente.
     */
    public ReunionNoIniciadaException(String mensaje) {
        super(mensaje);
    }
}