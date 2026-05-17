package org.example;

/**
 * Excepción general y clase base para manejar los errores relacionados
 * con el estado, los tiempos y el ciclo de vida de una reunión.
 */
public class ReunionException extends Exception {

    /**
     * Constructor para la excepción general de la reunión.
     * * @param mensaje El detalle del error que se ha producido.
     */
    public ReunionException(String mensaje) {
        super(mensaje);
    }
}