package org.example;

/**
 * Excepción lanzada cuando se intenta modificar el estado, iniciar o finalizar
 * una reunión que ya ha concluido previamente (ya tiene una hora de fin registrada).
 */
public class ReunionYaFinalizadaException extends ReunionException {

    /**
     * Constructor para la excepción de reunión ya finalizada.
     * * @param mensaje El detalle del error al intentar actuar sobre una reunión cerrada.
     */
    public ReunionYaFinalizadaException(String mensaje) {
        super(mensaje);
    }
}