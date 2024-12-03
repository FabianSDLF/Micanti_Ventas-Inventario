package org.example.miscanti_ventainventario.Logica;



public class BodegaManagment {
    private static final Bodega bodega = new Bodega(999,20,600);

    static {
        bodega.agregarProducto(new Producto(20, 1223, "Botella 1L",1000));
        bodega.agregarProducto(new Producto(20, 1224, "Botella 6L",1800));
        bodega.agregarProducto(new Producto(20, 1228, "Botella 20L",3500));
    }
    public static Bodega getBodega() {
        return bodega;
    }
}
