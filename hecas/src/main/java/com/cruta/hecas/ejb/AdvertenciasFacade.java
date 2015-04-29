/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.ejb;

import com.cruta.hecas.Grupousuarios;
import com.cruta.hecas.Plagas;
import com.cruta.hecas.Advertencias;
import com.cruta.hecas.Advertencias;
import com.cruta.hecas.Advertencias;
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
public class AdvertenciasFacade extends AbstractFacade<Advertencias> {
    @PersistenceContext(unitName = "com.cruta_hecas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdvertenciasFacade() {
        super(Advertencias.class);
    }
    
   public Advertencias findById(String id) {
        return em.find(Advertencias.class, id);
    }

    public List<Advertencias> getAdvertenciasList() {
        return em.createNamedQuery("Advertencias.findAll").getResultList();
    }

   
 public List<Advertencias> findByIdadvertencias(Integer idadvertencias) {
        Query query = em.createNamedQuery("Advertencias.findByIdadvertencias");
        return query.setParameter("idadvertencias", idadvertencias).getResultList();
    }
 
  public List<Advertencias> findByNombreplaga(Plagas nombreplaga){
         Query query = em.createQuery("SELECT a FROM Advertencias a WHERE a.nombreplaga = :nombreplaga");
        return query.setParameter("nombreplaga", nombreplaga).getResultList();
    }
 
   
    public void deleteAll() {
        Query query = em.createQuery("DELETE FROM Advertencias");
        int deleteRecords;
        deleteRecords = query.executeUpdate();
    }
    
     public Integer getMaximo() {
        try {

            Query q = em.createQuery("SELECT MAX(a.idadvertencias) FROM Advertencias a");

            Number result = (Number) q.getSingleResult();
            return result.intValue();
        } catch (Exception e) {

        }
        return 0;
    }
     
}

