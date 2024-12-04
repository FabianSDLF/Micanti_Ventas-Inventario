package org.example.miscanti_ventainventario.Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable {
    @Id
    private int codigo;
    private int cantidad;
    private int precio;
    private String nombre;
    private String descipcion;
    
    public Producto(){
        
    }
    
    public Producto(int cantidad, int codigo, String nombre, int precio) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        descipcion = "";
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
}
