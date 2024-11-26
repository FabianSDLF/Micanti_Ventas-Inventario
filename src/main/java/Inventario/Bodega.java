package Inventario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bodega {
    ArrayList<Producto> listaProducto = new ArrayList<>();
    int capacidadMax,cantidadMin,capacidadDisp;

    public Bodega(int capacidadMax, int cantidadMin, int capacidadDisp) {
        this.capacidadMax = capacidadMax;
        this.cantidadMin = cantidadMin;
        this.capacidadDisp = capacidadDisp;
    }

    /**agrega producto a la lista de productos almacenados,
     * si el producto se pudo añadir correctamente, se retorna
     * el valor true, de lo contrario, retorna false.
     *
     * @param producto
     * @return boolean
     * @author Benjamín Villa
     */
    public boolean agregarProducto(Producto producto){
        return listaProducto.add(producto);
    }
    /**consulta si hay de un cierto producto almacenado a través del código.
     * si el producto es encontrado, se retorna envuelto en un optional.
     * Si no está presente, se retorna un optional vacío.
     *
     * @param codigo
     * @return Optional
     * @author Benjamín Villa
     */
    public Optional consultarProducto(int codigo){
        for(Producto producto: listaProducto){
            if (producto.codigo == codigo){
                return Optional.of(producto);
            }
        }
        return Optional.empty();
    }

    /**Elimina la primera instancia del código de un producto especificado.
     * Retorna true si se eliminó correctamente o false si el producto no se encontró.
     *
     * @param codigo
     * @return boolean
     * @author Benjamín Villa
     */
    public boolean eliminarProducto(int codigo){
        for(Producto producto: listaProducto){
            if (producto.codigo == codigo){
                return listaProducto.remove(producto);
            }
        }
        return false;
    }
    /**agrega producto a la lista de productos almacenados,
     * si el producto se pudo añadir correctamente, se retorna
     * el valor true, de lo contrario, retorna false.
     *
     * @return List</String>
     * @author Benjamín Villa
     */
    public List<String> reporteInventario(){
        List<String> reporte = new ArrayList<>();
        String fila = "";
        for(Producto producto: listaProducto){
            fila = producto.codigo + "\t" + producto.nombre + "\t" + producto.cantidad;
            reporte.add(fila);
        }
        if (reporte.size() == 0){
            reporte.add("La bodega está vacía.");
            return reporte;
        }
        return reporte;
    }
    /**Crea una lista de artículos que se encuentran en bajo stock
     *
     * @return String[]
     * @author Benjamín Villa
     */
    public String[] solicitudPedido(){
        ArrayList<Producto> solicitud = new ArrayList<>();
        for(Producto producto: listaProducto){
            if (producto.cantidad < cantidadMin){
                solicitud.add(producto);
            }
        }
        return solicitud.toArray(new String[solicitud.size()]);
    }

}
