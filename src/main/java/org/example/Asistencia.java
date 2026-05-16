package org.example;

public class Asistencia {
    private Empleado empleado;
    public Asistencia(Empleado e){
        empleado=e;
    }
    public Empleado getEmpleado(){
        return empleado;
    }
    public void setEmpleado(Empleado e){
        empleado=e;
    }
    @Override
    public String toString(){
        return "Asistencia: empleado "+ empleado;
    }
}
