package org.example.miscanti_ventainventario.Logica;
public class Producto {
    int cantidad, codigo;
    String nombre;
    public Producto(int cantidad, int codigo, String nombre) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.nombre = nombre;

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

}
