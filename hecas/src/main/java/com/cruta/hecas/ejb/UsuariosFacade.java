/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.ejb;

import com.cruta.hecas.Grupousuarios;
import com.cruta.hecas.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author avbravo
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {
    @PersistenceContext(unitName = "com.cruta_hecas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
     public Usuarios findById(String id) {
        return em.find(Usuarios.class, id);
    }

    public List<Usuarios> getUsuariosList() {
        return em.createNamedQuery("Usuarios.findAll").getResultList();
    }

    public List<Usuarios> findByActivo(String value) {
        Query query = em.createNamedQuery("Usuarios.findByActivo");
        return query.setParameter("activo", value).getResultList();
    }
 public List<Usuarios> findByUsername(String value) {
        Query query = em.createNamedQuery("Usuarios.findByUsername");
        return query.setParameter("username", value).getResultList();
    }
 
 public List<Usuarios> findByPassword(String value) {
        Query query = em.createNamedQuery("Usuarios.findByPassword");
        return query.setParameter("password", value).getResultList();
    }
    public List<Usuarios> findByCedula(String value) {
        Query query = em.createNamedQuery("Usuarios.findByCedula");
        return query.setParameter("cedula", value).getResultList();
    }

    public List<Usuarios> findByNombre(String value) {
        Query query = em.createNamedQuery("Usuarios.findByNombre");
        return query.setParameter("nombre", value).getResultList();
    }

    public List<Usuarios> findByNombreLike(String value) {
        Query query = em.createNamedQuery("Usuarios.findByNombreLike");
        value = "%" + value.trim() + "%";
        return query.setParameter("nombre", value).getResultList();
    }

    public List<Usuarios> findByIdgrupousuario(Grupousuarios value) {
        Query query = em.createNamedQuery("Usuarios.findByIdgrupousuario");
        return query.setParameter("idgrupousuario", value).getResultList();
    }

    public Long contadorActivo(String value) {
        Query query = em.createNamedQuery("Usuarios.contadorActivo");
        return (Long) query.setParameter("activo", value).getSingleResult();
    }
    public void deleteAll() {
        Query query = em.createQuery("DELETE FROM Usuarios u WHERE u.username !='avbravo'");
        int deleteRecords;
        deleteRecords = query.executeUpdate();
    }
}
