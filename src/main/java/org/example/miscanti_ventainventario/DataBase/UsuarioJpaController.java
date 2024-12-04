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
import org.example.miscanti_ventainventario.Logica.Usuario;

public class UsuarioJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public UsuarioJpaController() {
        // Configura tu unidad de persistencia según el archivo persistence.xml
        this.emf = Persistence.createEntityManagerFactory("Miscanti");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para crear un usuario
    public void create(Usuario usuario) throws Exception {
    EntityManager em = null;
    try {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    } catch (Exception ex) {
        if (findUsuarioByNickName(usuario.getNickName()) != null) {
            throw new Exception("Usuario con este nickname ya existe.");
        }
        throw ex;
    } finally {
        if (em != null) {
            em.close();
        }
    }
}


    // Método para encontrar un usuario por su nickname
    public Usuario findUsuario(String nickName) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, nickName);
        } finally {
            em.close();
        }
    }

    // Método para listar todos los usuarios
    public List<Usuario> findUsuarioEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Método para actualizar un usuario
    public void edit(Usuario usuario) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(usuario);
            tx.commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getNickName()) == null) {
                throw new Exception("El usuario con nickname " + usuario.getNickName() + " no existe.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para eliminar un usuario por su nickname
    public void destroy(String nickName) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, nickName);
                usuario.getNickName(); // Verifica la existencia
            } catch (Exception ex) {
                throw new Exception("El usuario con nickname " + nickName + " no existe.", ex);
            }
            em.remove(usuario);
            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para contar el total de usuarios
    public long getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT COUNT(u) FROM Usuario u", Long.class).getSingleResult();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuarioByNickName(String nickName) {
    EntityManager em = getEntityManager();
    try {
        return em.find(Usuario.class, nickName);
    } finally {
        em.close();
    }
}

}
