package org.example.miscanti_ventainventario.Logica;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @Column(length = 191)
    private String nickName;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String correo;
    private String contrasena;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
    public Usuario(){
        
    }

    public Usuario(String nickName, String primerNombre, String segundoNombre, String apellidoMaterno, String apellidoPaterno, String correo, String contrasena) {
        this.nickName = nickName;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.correo = correo;
        this.contrasena = contrasena;
        rol = Rol.CLIENTE;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getFullName(){
        return primerNombre+" "+segundoNombre+" "+apellidoMaterno+" "+apellidoPaterno;
    }
}
