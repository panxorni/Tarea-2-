package org.example;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable{
    private String nombreDepartamento;
    private List<Empleado> empleados;

    public Departamento(String nombreDepartamento){
        if (nombreDepartamento==null || nombreDepartamento.isBlank()){
            throw new IllegalArgumentException("no puede estar vacio el nombre del departamento");
        }
        this.nombreDepartamento = nombreDepartamento;
        this.empleados=new ArrayList<>();
    }

    public String getNombreDepartamento(){
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento){
        if (nombreDepartamento==null || nombreDepartamento.isBlank()){
            throw new IllegalArgumentException("no puede estar vacio el nombre del departamento");
        }
        this.nombreDepartamento = nombreDepartamento;
    }
    public List<Empleado> getEmpleados(){
        return empleados;
    }
    public void setEmpleados(List<Empleado> empleados){
        if (empleados==null) {
            throw new IllegalArgumentException("no pueden ser vacio los empleados");
        }
        this.empleados=empleados;
    }

    public void agregarEmpleado(Empleado empleado){
        if (empleado==null){
            throw new IllegalArgumentException("no puede ser vacio el empleado");
        }
        else{
            empleados.add(empleado);
        }
    }
    public int cantidadEmpleados(){
        return empleados.size();
    }
    public String nombreInvitable() {
        return "Departamento " + nombreDepartamento;
    }
    public String correoInvitable() {
        return "Invitación a todo el departamento";
    }
    public void invitar() {
        System.out.println("Invitación al departamento " + nombreDepartamento);
    }
}