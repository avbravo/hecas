/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.ejb;

import com.cruta.hecas.Alertas;
import com.cruta.hecas.Alertas;
import com.cruta.hecas.Plagas;
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

   
 public List<Alertas> getAlertasOrdenados() {
        Query query = em.createQuery("SELECT a FROM Alertas a ORDER BY a.idalerta DESC");
        return query.getResultList();
    }
 public List<Alertas> findByIdalerta(Integer idalerta) {
        Query query = em.createNamedQuery("Alertas.findByIdalerta");
        return query.setParameter("idalerta", idalerta).getResultList();
    }
 
 public List<Alertas> findByFoto(String foto) {
        Query query = em.createQuery("SELECT a FROM Alertas a WHERE a.foto = :foto");
        return query.setParameter("foto", foto).getResultList();
    }
   
    public void deleteAll() {
        Query query = em.createQuery("DELETE FROM Alertas");
        int deleteRecords;
        deleteRecords = query.executeUpdate();
    }
       public Integer getMaximo() {
        try {

            Query q = em.createQuery("SELECT MAX(a.idalerta) FROM Alertas a");

            Number result = (Number) q.getSingleResult();
            return result.intValue();
        } catch (Exception e) {

        }
        return 0;
    }
       
       
         public Integer getContadorPlagas(String nombreplaga) {
        try {

            Query q = em.createQuery("SELECT COUNT(a)  FROM Alertas a WHERE a.nombreplaga= :nombreplaga");
            q.setParameter("nombreplaga", nombreplaga);

            Number result = (Number) q.getSingleResult();
            return result.intValue();
        } catch (Exception e) {

        }
        return 0;
    }
          public Integer getContadorCultivos(String nombrecultivo) {
        try {

            Query q = em.createQuery("SELECT COUNT(a)  FROM Alertas a WHERE a.nombrecultivo= :nombrecultivo");
            q.setParameter("nombrecultivo", nombrecultivo);

            Number result = (Number) q.getSingleResult();
            return result.intValue();
        } catch (Exception e) {

        }
        return 0;
    }
       /*
       devuelve un distinct de los años
       */
       
         
}
