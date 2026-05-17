package org.example;

public class Empleado implements Invitable {
    private String id;
    private String nombre;
    private String apellidos;
    private String correo;
    private Departamento departamento;
    public Empleado (String id, String nombre, String apellidos, String correo, Departamento departamento){
        if (id==null || id.isBlank()){
            throw new IllegalArgumentException("id no puede ser vacio");
        }
        if (nombre==null || nombre.isBlank()){
            throw new IllegalArgumentException("no puede estar vacio el nombre ");
        }
        if (apellidos==null || apellidos.isBlank()){
            throw new IllegalArgumentException("no puede estar vacio los apellidos");
        }
        if (correo==null || correo.isBlank()){
            throw new IllegalArgumentException("no puede estar vacio el correo");
        }
        if (departamento==null){
            throw new IllegalArgumentException("no puede estar vacio el departamento");
        }
        this.id=id;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.correo=correo;
        this.departamento=departamento;
    }
    public String getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getCorreo(){
        return correo;
    }
    public Departamento getDepartamento(){
        return departamento;
    }


    public void setId(String id){
        if (id==null || id.isBlank()){
            throw new IllegalArgumentException("no puede estar el id");
        }
        this.id = id;
    }
    public void setNombre(String nombre){
        if (nombre==null || nombre.isBlank()){
            throw new IllegalArgumentException("no puede estar vacio el nombre");
        }
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos){
        if (apellidos==null || apellidos.isBlank()){
            throw new IllegalArgumentException("no pueden estar vacio los apellidos");
        }
        this.apellidos = apellidos;
    }
    public void setCorreo(String correo){
        if (correo==null || correo.isBlank()){
            throw new IllegalArgumentException("no puede estar vacio el correo");
        }
        this.correo = correo;
    }
    public void setDepartamento(Departamento departamento){
        if (departamento==null){
            throw new IllegalArgumentException("no puede estar vacio el departamento");
        }
        this.departamento = departamento;
    }


    public String nombreInvitable() {
        return nombre + " " + apellidos;
    }
    public String correoInvitable() {
        return correo;
    }
    public void invitar() {
        System.out.println("Felicidades, " + nombre + " " + apellidos + " ha recibido una invitación");
    }
    public String toString(){
        return "Id: " + id + ", nombre: " + nombre + " " + apellidos + ", correo: " + correo + ", departamento: " + departamento.getNombreDepartamento();
    }
}