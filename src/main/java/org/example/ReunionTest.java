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
public class ReunionTest {

    private Reunion reunion;

    /**
     * Este método se ejecuta ANTES de cada @Test.
     * Nos sirve para inicializar una reunión limpia cada vez y no repetir código.
     */
    @BeforeEach
    public void setUp() {
        // Usamos ReunionVirtual porque Reunion es abstracta
        reunion = new ReunionVirtual(new Date(), Instant.now(), Duration.ofHours(1), null, tipoReunion.TECNICA, "tims.con/ayudamtiaClavedeJAva");
    }

    // ==========================================
    // PRUEBAS DE CÁLCULO MATEMÁTICO (USO NORMAL)
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
    // PRUEBAS DE CASOS EXTREMOS (EXCEPCIONES)
    // ==========================================

    @Test
    public void testIniciarReunionYaIniciadaLanzaExcepcion() throws ReunionException {
        // Iniciamos la reunión por primera vez (esto debería funcionar bien)
        reunion.iniciar();

        // Verificamos que si intentamos iniciarla DE NUEVO, lance tu excepción personalizada
        assertThrows(ReunionYaIniciadaException.class, () -> {
            reunion.iniciar();
        }, "Debería lanzar ReunionYaIniciadaException al intentar iniciar dos veces.");
    }

    @Test
    public void testFinalizarReunionNoIniciadaLanzaExcepcion() {
        // Ojo: Nunca llamamos a reunion.iniciar() aquí

        // Verificamos que falle al intentar finalizar
        assertThrows(ReunionNoIniciadaException.class, () -> {
            reunion.finalizar();
        }, "Debería lanzar ReunionNoIniciadaException si se finaliza antes de iniciar.");
    }

    @Test
    public void testCalcularTiempoReunionEnCursoLanzaExcepcion() throws ReunionException {
        // Iniciamos la reunión, pero NO la finalizamos (horaFin será null)
        reunion.iniciar();

        // Verificamos que no se pueda calcular el tiempo si no ha terminado
        assertThrows(ReunionException.class, () -> {
            reunion.calcularTiempoReal();
        }, "Debería lanzar ReunionException al calcular tiempo sin haber finalizado.");
    }

    @Test
    public void testFinalizarReunionYaFinalizadaLanzaExcepcion() throws ReunionException {
        // Simulamos un ciclo normal completo usando setters para ir más rápido
        reunion.setHoraInicio(Instant.now());
        reunion.setHoraFin(Instant.now().plusSeconds(60));

        // Intentamos finalizarla DE NUEVO
        assertThrows(ReunionYaFinalizadaException.class, () -> {
            reunion.finalizar();
        }, "Debería lanzar ReunionYaFinalizadaException al finalizar dos veces.");
    }
}