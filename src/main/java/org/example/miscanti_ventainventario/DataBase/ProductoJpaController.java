/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.miscanti_ventainventario.DataBase;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.example.miscanti_ventainventario.Logica.Producto;

public class ProductoJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public ProductoJpaController() {
        // Configura tu unidad de persistencia según el archivo persistence.xml
        this.emf = Persistence.createEntityManagerFactory("Miscanti");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para crear un producto
    public void create(Producto producto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(producto);
            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para encontrar un producto por su código
    public Producto findProducto(int codigo) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, codigo);
        } finally {
            em.close();
        }
    }

    // Método para listar todos los productos
    public List<Producto> findProductoEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Método para actualizar un producto
    public void edit(Producto producto) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(producto);
            tx.commit();
        } catch (Exception ex) {
            if (findProducto(producto.getCodigo()) == null) {
                throw new Exception("El producto con código " + producto.getCodigo() + " no existe.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para eliminar un producto por su código
    public void destroy(int codigo) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, codigo);
                producto.getCodigo(); // Verifica la existencia
            } catch (Exception ex) {
                throw new Exception("El producto con código " + codigo + " no existe.", ex);
            }
            em.remove(producto);
            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para contar el total de productos
    public long getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT COUNT(p) FROM Producto p", Long.class).getSingleResult();
        } finally {
            em.close();
        }
    }
}
