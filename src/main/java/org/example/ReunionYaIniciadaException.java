package org.example;

/**
 * Excepción lanzada cuando se intenta iniciar una reunión que ya
 * se encuentra en curso (es decir, ya tiene una hora de inicio registrada).
 */
public class ReunionYaIniciadaException extends ReunionException {

    /**
     * Constructor para la excepción de reunión ya iniciada.
     * * @param mensaje El detalle del error al intentar duplicar el inicio.
     */
    public ReunionYaIniciadaException(String mensaje) {
        super(mensaje);
    }
}