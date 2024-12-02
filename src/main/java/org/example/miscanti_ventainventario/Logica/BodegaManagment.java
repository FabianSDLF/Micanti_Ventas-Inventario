package org.example.miscanti_ventainventario.Logica;



public class BodegaManagment {
    private static final Bodega bodega = new Bodega(999,20,600);

    static {
        bodega.agregarProducto(new Producto(22, 1223, "botella 1L",5000,"\\C:\\Users\\sapul\\Desktop\\UBB\\2024-2\\Modelamiento\\img's\\botella1L.jpg"));
        bodega.agregarProducto(new Producto(21, 1224, "botella 15L",10000,"\\C:\\Users\\sapul\\Desktop\\UBB\\2024-2\\Modelamiento\\img's\\botella 15l.jpg"));
        bodega.agregarProducto(new Producto(20, 1228, "botella 20L",20000,"\\C:\\Users\\sapul\\Desktop\\UBB\\2024-2\\Modelamiento\\img's\\botella 20l.jpg"));
    }
    public static Bodega getBodega() {
        return bodega;
    }
}
