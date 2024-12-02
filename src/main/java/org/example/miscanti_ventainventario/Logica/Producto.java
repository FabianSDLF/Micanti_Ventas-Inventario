package org.example.miscanti_ventainventario.Logica;
public class Producto {
    private int cantidad, codigo, precio;
    private String nombre, descipcion, url_img;
    public Producto(int cantidad, int codigo, String nombre, int precio, String url_img) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        descipcion = "";
        this.url_img = url_img;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
}
