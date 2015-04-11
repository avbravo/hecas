/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.ejb;

import com.cruta.hecas.Pais;
import com.cruta.hecas.Pais;
import com.cruta.hecas.Provincias;
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
public class PaisFacade extends AbstractFacade<Pais> {
    @PersistenceContext(unitName = "com.cruta_hecas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }
    
 public List<Pais> getPaisList() {
        return em.createNamedQuery("Pais.findAll").getResultList();
    }

  

    public List<Pais> findByPais(String value) {
        Query query = em.createNamedQuery("Pais.findByPais");
        return query.setParameter("pais", value).getResultList();
    }

   
       public void deleteAll() {
        Query query = em.createQuery("DELETE FROM Pais");
        int deleteRecords;
        deleteRecords = query.executeUpdate();
    }
        }