/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.controller;

import com.cruta.hecas.Advertencias;
import com.cruta.hecas.ejb.AdvertenciasFacade;
import com.cruta.hecas.generales.GestorImpresion;
import com.cruta.hecas.generales.JSFUtil;
import com.cruta.hecas.generales.LoginBean;
import com.cruta.hecas.generales.ResourcesFiles;
import com.cruta.hecas.interfaces.IController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.Size;

/**
 *
 * @author avbravo
 */
@Named
@SessionScoped
public class AdvertenciasController implements Serializable, IController {

    private static final long serialVersionUID = 1L;

    @Inject
    AdvertenciasFacade advertenciasFacade;
    Advertencias advertencias = new Advertencias();
    private Boolean encontrado = false;
    @Inject
    ResourcesFiles rf;
    @Inject
    GestorImpresion gestorImpresion;
    @Inject
    LoginBean loginBean;
    private Boolean nuevoregistro = false;
 Boolean desactivar =true;

 private Boolean aplicatemperatura;
   
  private Boolean aplicahumedadrelativa;
   private Boolean aplicahumedadsuelo;

    public Boolean getAplicatemperatura() {
        return aplicatemperatura;
    }

    public void setAplicatemperatura(Boolean aplicatemperatura) {
        this.aplicatemperatura = aplicatemperatura;
    }

    public Boolean getAplicahumedadrelativa() {
        return aplicahumedadrelativa;
    }

    public void setAplicahumedadrelativa(Boolean aplicahumedadrelativa) {
        this.aplicahumedadrelativa = aplicahumedadrelativa;
    }

    public Boolean getAplicahumedadsuelo() {
        return aplicahumedadsuelo;
    }

    public void setAplicahumedadsuelo(Boolean aplicahumedadsuelo) {
        this.aplicahumedadsuelo = aplicahumedadsuelo;
    }
   
   public void verificar(){
       System.out.println("aplicahumedadsuelo "+aplicahumedadsuelo);
   }
   
   
    public Boolean getDesactivar() {
        return desactivar;
    }

    public void setDesactivar(Boolean desactivar) {
        this.desactivar = desactivar;
    }


    public Boolean getNuevoregistro() {
        return nuevoregistro;
    }

    public void setNuevoregistro(Boolean nuevoregistro) {
        this.nuevoregistro = nuevoregistro;
    }

    public Advertencias getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(Advertencias advertencias) {
        this.advertencias = advertencias;
    }

    public Boolean getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(Boolean encontrado) {
        this.encontrado = encontrado;
    }

    /**
     * Creates a new instance of AdvertenciasController
     */
    public AdvertenciasController() {
    }

    @PostConstruct
    public void init() {   desactivar =true;
        nuevoregistro = false;
  advertencias = new Advertencias();
  limpiar();
    }

    private void limpiar(){
       
    }
    @Override
    public String buscar() {
        advertencias = advertenciasFacade.find(advertencias.getIdadvertencias());
        if (advertencias == null) {
            encontrado = false;
            JSFUtil.addWarningMessage(rf.getMensajeArb("warning.noexiste"));
            advertencias = new Advertencias();
        } else {
            encontrado = true;
        }
        return "";
    }

    @Override
    public String prepararNew() {      desactivar = false;
        try {
            nuevoregistro = true;
            encontrado = false;
            advertencias = new Advertencias();
         limpiar();
   
            
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String save() {
        try {
   advertencias.setIdadvertencias(advertenciasFacade.getMaximo() +1);
   advertencias.setFecha(JSFUtil.getFechaActual());
            advertenciasFacade.create(advertencias);
            JSFUtil.addSuccessMessage("Guardado exitosamente");
            advertencias = new Advertencias();
            this.nuevoregistro = false;
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String edit() {
        try {

            advertenciasFacade.edit(advertencias);

            JSFUtil.addSuccessMessage(rf.getMensajeArb("info.update"));

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public String delete() {
        try {
            advertenciasFacade.remove(advertencias);
            JSFUtil.addSuccessMessage(rf.getMensajeArb("info.delete"));

            encontrado = false;
            advertencias = new Advertencias();

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String imprimir() {
//        try {
//            List<Advertencias> list = new ArrayList<>();
//            list.add(advertencias);
//            String ruta = "/resources/reportes/advertencias/advertencias.jasper";
//            HashMap parameters = new HashMap();
//            gestorImpresion.imprimir(list, ruta, parameters);
//        } catch (Exception ex) {
//            JSFUtil.addErrorMessage("imprimir() " + ex.getLocalizedMessage());
//        }
        return null;
    }

    @Override
    public String imprimirTodos() {
//        String ruta = "/resources/reportes/advertencias/advertencias.jasper";
//        HashMap parameters = new HashMap();
//        gestorImpresion.imprimir(advertenciasFacade.getAdvertenciasList(), ruta, parameters);
        return null;
    }

    @Override
    public Integer contador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String elementoSeleccionado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String habilitarConsultar() {        desactivar=true;
        advertencias.setIdadvertencias(0);
        this.nuevoregistro = false;
        return "";
    }

    @Override
    public Integer getIdSiguiente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
