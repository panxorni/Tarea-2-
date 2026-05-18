package org.example;

public class InvitadoExterno implements Invitable{
    private String nombreCompleto;
    private String correoElectronico;
    public InvitadoExterno (String nombreCompleto, String correoElectronico){
        if (nombreCompleto==null || nombreCompleto.isBlank()){
            throw new IllegalArgumentException("el nombre no puede ser vacio");
        }
        this.nombreCompleto=nombreCompleto;
        if (correoElectronico==null || correoElectronico.isBlank()){
            throw new IllegalArgumentException("el correo no puede ser vacio");
        }
        this.correoElectronico=correoElectronico;
    }
    public String getNombreCompleto(){
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto){
        if (nombreCompleto==null || nombreCompleto.isBlank()){
            throw new IllegalArgumentException("no puede estar vacio el nombre");
        }
        this.nombreCompleto = nombreCompleto;
    }
    public String getCorreoElectronico(){
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico){
        if (correoElectronico==null || correoElectronico.isBlank()){
            throw new IllegalArgumentException("no puede estar vacio el correo");
        }
        this.correoElectronico = correoElectronico;
    }

    public String nombreInvitable() {
        return nombreCompleto;
    }
    public String correoInvitable() {
        return correoElectronico;
    }
    public void invitar() {
        System.out.println("Felicidades, " + nombreCompleto + " ha recibido una invitación");
    }
    public String toString(){
        return "nombre: " + nombreCompleto + ", correo: " + correoElectronico;
    }

}
