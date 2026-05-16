package org.example;

import java.time.Instant;

public class Retraso extends Asistencia{
    private Instant horaLlegada;

    public Retraso(Empleado e){
        super(e);
        this.horaLlegada= Instant.now();
    }

    public Instant getHoraLlegada(){
        return horaLlegada;
    }

    public void setHoraLlegada(Instant horaLlegada){
        this.horaLlegada=horaLlegada;
    }

    @Override
    public String toString(){
        return "Retraso: empleado"+ getEmpleado()+ "llegó a las" + horaLlegada;
    }
}
