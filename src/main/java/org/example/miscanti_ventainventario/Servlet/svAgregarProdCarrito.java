package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.miscanti_ventainventario.Logica.Bodega;
import org.example.miscanti_ventainventario.Logica.Producto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class svAgregarProdCarrito extends HttpServlet {
    private Bodega bodega;

    @Override
    public void init() throws ServletException{
        super.init();

        bodega = (Bodega) getServletContext().getAttribute("bodega");
        if (bodega==null){
            bodega = new Bodega(100,5,100);
            getServletContext().setAttribute("bodega", bodega);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigoProduc = Integer.parseInt(request.getParameter("codigoProducto"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        //Obtener el carrito de la sesion
        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito==null){
            carrito = new ArrayList<>();
            session.setAttribute("carrito",carrito);
        }
        //Buscar el producto en la bodega
        Optional<Producto> productoOpti = bodega.consultarProducto(codigoProduc);
        if (productoOpti.isPresent()){
            Producto producto = productoOpti.get();
            //Verificar si el producto ya esta en el carrito
            boolean encontrado = false;
            for(Producto produc : carrito){
                if (produc.getCodigo() == producto.getCodigo()){
                    produc.setCantidad(produc.getCantidad()+cantidad);
                    encontrado=true;
                    break;
                }
            }
            if (!encontrado){
                Producto newProduc = new Producto(cantidad,producto.getCodigo(),producto.getNombre(),producto.getPrecio());
                carrito.add(newProduc);
            }
        }
        //Regirigir a productos.jsp o al carrito
        response.sendRedirect("productos.jsp");
    }
}
