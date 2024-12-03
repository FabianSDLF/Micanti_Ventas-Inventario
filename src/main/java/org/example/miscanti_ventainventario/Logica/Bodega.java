package org.example.miscanti_ventainventario.Logica;

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

    /**Agrega producto a la lista de productos almacenados,
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
    /**Consulta si hay de un cierto producto almacenado a través del código.
     * si el producto es encontrado, se retorna envuelto en un optional.
     * Si no está presente, se retorna un optional vacío.
     *
     * @param codigo
     * @return Optional
     * @author Benjamín Villa
     */
    public Optional<Producto> consultarProducto(int codigo){
        for(Producto producto: listaProducto){
            if (producto.getCodigo() == codigo){
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
            if (producto.getCodigo() == codigo){
                return listaProducto.remove(producto);
            }
        }
        return false;
    }
    /**Crea una lista de los productos disponibles, incluyendo el código del producto,
     * el nombre, y su cantidad, todo separado por tabulaciones.
     *
     * @return List</String>
     * @author Benjamín Villa
     */
    public List<String> reporteInventario(){
        List<String> reporte = new ArrayList<>();
        String fila = "";
        for(Producto producto: listaProducto){
            fila = producto.getCodigo() + "\t" + producto.getNombre() + "\t" + producto.getCantidad() + "\t"+ producto.getPrecio();
            reporte.add(fila);
        }
        if (reporte.isEmpty()){
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
            if (producto.getCantidad() < cantidadMin){
                solicitud.add(producto);
            }
        }
        return solicitud.toArray(new String[solicitud.size()]);
    }

    public List<Producto> getListaProductos(){
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public void aumentarStock(int codigo, int cantidad) {
        Producto producto = buscarProducto(codigo);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + cantidad);
        }
    }

    public void reducirStock(int codigo, int cantidad) {
        Producto producto = buscarProducto(codigo);
        if (producto != null) {
            producto.setCantidad(Math.max(0, producto.getCantidad() - cantidad)); // Evita cantidades negativas
        }
    }

    private Producto buscarProducto(int codigo) {
        for(Producto producto: listaProducto){
            if (producto.getCodigo() == codigo){
                return producto;
            }
        }
        return null;
    }

    public double getProductPrice(String productId) {
        Producto poducto = buscarProducto(Integer.parseInt(productId));
        assert poducto != null;
        return poducto.getPrecio();
    }

    public String getProductName(String productId) {
        Producto poducto = buscarProducto(Integer.parseInt(productId));
        assert poducto != null;
        return poducto.getNombre();
    }

}
