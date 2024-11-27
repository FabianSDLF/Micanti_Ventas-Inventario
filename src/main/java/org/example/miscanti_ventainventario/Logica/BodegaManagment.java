package org.example.miscanti_ventainventario.Logica;



public class BodegaManagment {
    private static final Bodega bodega = new Bodega(999,20,600);

    static {
        bodega.agregarProducto(new Producto(20, 1223, "botella",1000));
        bodega.agregarProducto(new Producto(20, 1224, "limpiador",2000));
        bodega.agregarProducto(new Producto(20, 1228, "tapas",3000));
    }
    public static Bodega getBodega() {
        return bodega;
    }
}
