package org.example.miscanti_ventainventario.Logica;

public class Usuario {
    private String nickName;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String correo;
    private String contrasena;
    private Rol rol;
    public Usuario(String nN,String pN, String sN, String pA, String sA, String C, String Con) {
        nickName = nN;
        primerNombre = pN;
        segundoNombre = sN;
        apellidoMaterno = pA;
        apellidoPaterno = sA;
        correo = C;
        contrasena = Con;
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
