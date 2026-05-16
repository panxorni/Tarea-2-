package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Clase de pruebas unitarias para el motor de tiempo de las Reuniones.
 */
public class TestJunitReunion {

    private Reunion reunion;

    /**
     * Este método se ejecuta ANTES de cada @Test.
     * inicializa una reunión limpia cada vez
     */
    @BeforeEach
    public void setUp() {
        // Usa ReunionVirtual porque Reunion es abstracta
        reunion = new ReunionVirtual(new Date(), Instant.now(), Duration.ofHours(1), null, tipoReunion.TECNICA, "tims.con/ayudamtiaClavedeJAva");
    }

    // ==========================================
    // PRUEBAS DE CÁLCULO MATEMÁTICO
    // ==========================================

    @Test
    public void testCalcularTiempoRealCorrecto() throws ReunionException {
        //Se simula el tiempo exacto usando los setters
        Instant inicio = Instant.now();
        Instant fin = inicio.plus(Duration.ofMinutes(45)); //se simula que duró exactamente 45 minutos

        reunion.setHoraInicio(inicio);
        reunion.setHoraFin(fin);

        // Ejecución
        float tiempo = reunion.calcularTiempoReal();

        // Verificación: se espera 45.0, el valor real es 'tiempo', y 0.01 es el margen de error aceptado
        assertEquals(45.0f, tiempo, 0.01, "El cálculo del tiempo real en minutos es incorrecto.");
    }

    // ==========================================
    // PRUEBAS DE EXCEPCIONES
    // ==========================================

    @Test
    public void testIniciarReunionYaIniciadaLanzaExcepcion() throws ReunionException {
        // Inicia la reunión por primera vez
        reunion.iniciar();

        // Verifica que al  iniciarla de nuevo, lanza la excepcion
        assertThrows(ReunionYaIniciadaException.class, () -> {
            reunion.iniciar();
        }, "Debería lanzar ReunionYaIniciadaException al intentar iniciar dos veces.");
    }

    @Test
    public void testFinalizarReunionNoIniciadaLanzaExcepcion() {
        // Nunca se llama a reunion.iniciar() aquí

        // Verifica que falle al intentar finalizar
        assertThrows(ReunionNoIniciadaException.class, () -> {
            reunion.finalizar();
        }, "Debería lanzar ReunionNoIniciadaException si se finaliza antes de iniciar.");
    }

    @Test
    public void testCalcularTiempoReunionEnCursoLanzaExcepcion() throws ReunionException {
        // Inicia la reunión, pero NO finaliza (horaFin será null)
        reunion.iniciar();

        // Verifica que no se pueda calcular el tiempo si no ha terminado
        assertThrows(ReunionException.class, () -> {
            reunion.calcularTiempoReal();
        }, "Debería lanzar ReunionException al calcular tiempo sin haber finalizado.");
    }

    @Test
    public void testFinalizarReunionYaFinalizadaLanzaExcepcion() throws ReunionException {
        // Simula un ciclo normal completo usando setters
        reunion.setHoraInicio(Instant.now());
        reunion.setHoraFin(Instant.now().plusSeconds(60));

        // Intenta finalizarla
        assertThrows(ReunionYaFinalizadaException.class, () -> {
            reunion.finalizar();
        }, "Debería lanzar ReunionYaFinalizadaException al finalizar dos veces.");
    }
}
