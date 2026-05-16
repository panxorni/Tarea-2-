package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private tipoReunion tipo;
    // atributos de relacion
    private Empleado organizador;
    private List<Nota> notas;
    private List<Asistencia> asistencias;
    private List<Invitación> invitaciones;

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipo) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tipo = tipo;
        this.organizador = organizador;
        this.notas = new ArrayList<>();
        this.asistencias = new ArrayList<>();
        this.invitaciones = new ArrayList<>();
    }

    //getters y setters

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Instant getHoraPrevista() { return horaPrevista; }
    public void setHoraPrevista(Instant horaPrevista) { this.horaPrevista = horaPrevista; }

    public Duration getDuracionPrevista() { return duracionPrevista; }
    public void setDuracionPrevista(Duration duracionPrevista) { this.duracionPrevista = duracionPrevista; }

    public Instant getHoraInicio() { return horaInicio; }
    public void setHoraInicio(Instant horaInicio) { this.horaInicio = horaInicio; }

    public Instant getHoraFin() { return horaFin; }
    public void setHoraFin(Instant horaFin) { this.horaFin = horaFin; }

    public tipoReunion getTipo() { return tipo; }
    public void setTipoReunion(tipoReunion tipo) { this.tipo = tipo; }


    //iniciar y finalizar

    public void iniciar() throws ReunionException{

        if (this.horaFin != null){
            throw new ReunionYaFinalizadaException("Error: No se puede iniciar una reunión que ya ha finalizado.");
        }
        if (this.horaInicio != null){
            throw new ReunionYaIniciadaException("Error: La reunión ya se encuentra en curso.");
        }
        this.horaInicio = Instant.now();
    }


    public void finalizar() throws ReunionException{

        if (this.horaInicio == null){
            throw new ReunionNoIniciadaException("Error: No se puede finalizar una reunión que aún no ha iniciado.");
        }
        if (this.horaFin != null){
            throw new ReunionYaFinalizadaException("Error: La reunión ya ha sido finalizada previamente.");
        }
        this.horaFin = Instant.now();
    }

    //calculo tiempo real

    public float calcularTiempoReal() throws ReunionException{
        if (this.horaInicio == null){
            throw new ReunionNoIniciadaException("Error: La reunión debe haber iniciado para calcular su tiempo.");
        }
        if (this.horaFin == null){
            throw new ReunionException("Error: La reunión debe haber finalizado para calcular su tiempo real.");
        }
        Duration duracionReal = Duration.between(this.horaInicio, this.horaFin);

        // Conversión a minutos
        float minutosReales = (float) duracionReal.toMillis() / 60000.0f;

        return minutosReales;
    }

    /**
     * Añade una nueva nota a la lista de anotaciones de esta reunión.
     * @param nota El objeto Nota que contiene el mensaje a registrar.
     */
    public void addNota(Nota nota){
        if (nota != null) {
            this.notas.add(nota);
        }
    }
    //metodos relacion




}

