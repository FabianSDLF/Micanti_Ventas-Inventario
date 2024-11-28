package org.example.miscanti_ventainventario.Logica;



public class BodegaManagment {
    private static final Bodega bodega = new Bodega(999,20,600);

    static {
        bodega.agregarProducto(new Producto(20, 1223, "botella 1L",5000));
        bodega.agregarProducto(new Producto(20, 1224, "botella 15L",10000));
        bodega.agregarProducto(new Producto(20, 1228, "botella 20L",20000));
    }
    public static Bodega getBodega() {
        return bodega;
    }
}
