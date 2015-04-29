/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.ejb;

import com.cruta.hecas.Grupousuarios;
import com.cruta.hecas.Plagas;
import com.cruta.hecas.Arduino;
import com.cruta.hecas.Arduino;
import com.cruta.hecas.Arduino;
import java.util.Date;
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
public class ArduinoFacade extends AbstractFacade<Arduino> {
    @PersistenceContext(unitName = "com.cruta_hecas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArduinoFacade() {
        super(Arduino.class);
    }
    
   public Arduino findById(String id) {
        return em.find(Arduino.class, id);
    }

    public List<Arduino> getArduinoList() {
        return em.createNamedQuery("Arduino.findAll").getResultList();
    }

   
 public List<Arduino> findByIdarduino(Integer idarduino) {
        Query query = em.createNamedQuery("Arduino.findByIdarduino");
        return query.setParameter("idarduino", idarduino).getResultList();
    }
  public List<Arduino> findByFecha(Date fecha) {
        Query query = em.createNamedQuery("Arduino.findByFecha");
        return query.setParameter("fecha", fecha).getResultList();
    }
 
   
    public void deleteAll() {
        Query query = em.createQuery("DELETE FROM Arduino");
        int deleteRecords;
        deleteRecords = query.executeUpdate();
    }
    
     public Integer getMaximo() {
        try {

            Query q = em.createQuery("SELECT MAX(a.idarduino) FROM Arduino a");

            Number result = (Number) q.getSingleResult();
            return result.intValue();
        } catch (Exception e) {

        }
        return 0;
    }
     
}

