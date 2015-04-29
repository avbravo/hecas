/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.ejb;

import com.cruta.hecas.Grupousuarios;
import com.cruta.hecas.Plagas;
import com.cruta.hecas.Reglas;
import com.cruta.hecas.Reglas;
import com.cruta.hecas.Reglas;
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
public class ReglasFacade extends AbstractFacade<Reglas> {
    @PersistenceContext(unitName = "com.cruta_hecas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReglasFacade() {
        super(Reglas.class);
    }
    
   public Reglas findById(String id) {
        return em.find(Reglas.class, id);
    }

    public List<Reglas> getReglasList() {
        return em.createNamedQuery("Reglas.findAll").getResultList();
    }

   
 public List<Reglas> findByIdreglas(Integer idreglas) {
        Query query = em.createNamedQuery("Reglas.findByIdreglas");
        return query.setParameter("idreglas", idreglas).getResultList();
    }
 
  public List<Reglas> findByNombreplaga(Plagas nombreplaga){
         Query query = em.createQuery("SELECT r FROM Reglas r WHERE r.nombreplaga = :nombreplaga");
        return query.setParameter("nombreplaga", nombreplaga).getResultList();
    }
 
   
    public void deleteAll() {
        Query query = em.createQuery("DELETE FROM Reglas");
        int deleteRecords;
        deleteRecords = query.executeUpdate();
    }
    
     public Integer getMaximo() {
        try {

            Query q = em.createQuery("SELECT MAX(r.idreglas) FROM Reglas r");

            Number result = (Number) q.getSingleResult();
            return result.intValue();
        } catch (Exception e) {

        }
        return 0;
    }
     
}

