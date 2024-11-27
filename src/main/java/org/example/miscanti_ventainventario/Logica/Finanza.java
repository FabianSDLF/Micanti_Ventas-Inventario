package org.example.miscanti_ventainventario.Logica;

import java.util.Optional;

public class Finanza {
    static Finanza actual = null;
    Bodega bodega = null;
    private Finanza(){
        this.actual = this;
    }
    public boolean crearBodega(int capacidadMax,int cantidadMin, int capacidadDisp){
        if (bodega != null){
            return false;
        }
        bodega = new Bodega(capacidadMax,cantidadMin,capacidadDisp);
        return true;
    }

    public Optional<Bodega> getBodega(){
        return Optional.ofNullable(bodega);
    }

    public static Finanza getInstance(){
        if(actual!= null){
            return actual;
        }
        return new Finanza();
    }
}
