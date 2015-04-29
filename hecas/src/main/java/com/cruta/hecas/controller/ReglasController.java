/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.controller;

import com.cruta.hecas.Reglas;
import com.cruta.hecas.ejb.ReglasFacade;
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
public class ReglasController implements Serializable, IController {

    private static final long serialVersionUID = 1L;

    @Inject
    ReglasFacade reglasFacade;
    Reglas reglas = new Reglas();
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

    public Reglas getReglas() {
        return reglas;
    }

    public void setReglas(Reglas reglas) {
        this.reglas = reglas;
    }

    public Boolean getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(Boolean encontrado) {
        this.encontrado = encontrado;
    }

    /**
     * Creates a new instance of ReglasController
     */
    public ReglasController() {
    }

    @PostConstruct
    public void init() {   desactivar =true;
        nuevoregistro = false;
  reglas = new Reglas();
  limpiar();
    }

    private void limpiar(){
         reglas.setHumedadrelativamaximo(0.0);
            reglas.setHumedadrelativaminimo(0.0);
            reglas.setHumedadsuelomaximo(0.0);
            reglas.setHumedadsuelominimo(0.0);
            reglas.setTemperaturafinal(0.0);
            reglas.setTemperaturainicial(0.0);
            reglas.setAplicahumedadrelativa("no");
            reglas.setAplicahumedadsuelo("si");
            reglas.setAplicatemperatura("si");
    }
    @Override
    public String buscar() {
        reglas = reglasFacade.find(reglas.getIdreglas());
        if (reglas == null) {
            encontrado = false;
            JSFUtil.addWarningMessage(rf.getMensajeArb("warning.noexiste"));
            reglas = new Reglas();
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
            reglas = new Reglas();
         limpiar();
   
            
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String save() {
        try {
   reglas.setIdreglas(reglasFacade.getMaximo() +1);
   reglas.setAplicahumedadrelativa(aplicahumedadrelativa==true?"si":"no");
   reglas.setAplicahumedadsuelo(aplicahumedadsuelo==true?"si":"no");
   reglas.setAplicatemperatura(aplicatemperatura==true?"si":"no");
            if (reglasFacade.find(reglas.getIdreglas()) != null) {
                JSFUtil.addWarningMessage("Ya se registro anteriormente esa regla para esa plaga");
                return null;
            }
            reglasFacade.create(reglas);
            JSFUtil.addSuccessMessage("Guardado exitosamente");
            reglas = new Reglas();
            this.nuevoregistro = false;
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String edit() {
        try {

            reglasFacade.edit(reglas);

            JSFUtil.addSuccessMessage(rf.getMensajeArb("info.update"));

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public String delete() {
        try {
            reglasFacade.remove(reglas);
            JSFUtil.addSuccessMessage(rf.getMensajeArb("info.delete"));

            encontrado = false;
            reglas = new Reglas();

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String imprimir() {
//        try {
//            List<Reglas> list = new ArrayList<>();
//            list.add(reglas);
//            String ruta = "/resources/reportes/reglas/reglas.jasper";
//            HashMap parameters = new HashMap();
//            gestorImpresion.imprimir(list, ruta, parameters);
//        } catch (Exception ex) {
//            JSFUtil.addErrorMessage("imprimir() " + ex.getLocalizedMessage());
//        }
        return null;
    }

    @Override
    public String imprimirTodos() {
//        String ruta = "/resources/reportes/reglas/reglas.jasper";
//        HashMap parameters = new HashMap();
//        gestorImpresion.imprimir(reglasFacade.getReglasList(), ruta, parameters);
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
        reglas.setIdreglas(0);
        this.nuevoregistro = false;
        return "";
    }

    @Override
    public Integer getIdSiguiente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
