package org.example;

import java.time.Instant;

public class Invitación {
    private Invitable invitado;
    private Instant hora;
    public Invitación (Invitable invitado, Instant hora){
        if (invitado==null){
            throw new IllegalArgumentException("invitado no puede ser vacio");
        }
        this.invitado=invitado;
        if (hora==null ){
            throw new IllegalArgumentException("hora no puede ser vacio");
        }
        this.hora=hora;
    }
    public Invitable getInvitado(){
        return invitado;
    }
    public void setInvitado(Invitable invitado){
        if (invitado==null ){
            throw new IllegalArgumentException("no puede estar vacio el nombre");
        }
        this.invitado = invitado;
    }
    public Instant getHora(){
        return hora;
    }
    public void setHora(Instant hora){
        if (hora==null ){
            throw new IllegalArgumentException("no puede estar vacio el nombre");
        }
        this.hora = hora;
    }
    public void imprimirInvitación(){
        System.out.println("invitación para: " + invitado.nombreInvitable());
        System.out.println("Con el correo: " + invitado.correoInvitable());
        System.out.println("A las: " + hora);
    }

    public String toString(){
        return "invitado: " + invitado + ", hora: " + hora;
    }
}
