/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.ejb;

import com.cruta.hecas.Alertas;
import com.cruta.hecas.Alertas;
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
public class AlertasFacade extends AbstractFacade<Alertas> {
    @PersistenceContext(unitName = "com.cruta_hecas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlertasFacade() {
        super(Alertas.class);
    }
    
    public Alertas findById(String id) {
        return em.find(Alertas.class, id);
    }

    public List<Alertas> getAlertasList() {
        return em.createNamedQuery("Alertas.findAll").getResultList();
    }

   
 public List<Alertas> findByIdalerta(Integer idalerta) {
        Query query = em.createNamedQuery("Alertas.findByIdalerta");
        return query.setParameter("idalerta", idalerta).getResultList();
    }
 
 
   
    public void deleteAll() {
        Query query = em.createQuery("DELETE FROM Alertas");
        int deleteRecords;
        deleteRecords = query.executeUpdate();
    }
    
}
