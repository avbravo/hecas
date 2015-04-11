/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.ejb;

import com.cruta.hecas.Alertas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
