/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.search;


import com.cruta.hecas.Reglas;
import com.cruta.hecas.controller.ReglasController;
import com.cruta.hecas.ejb.ReglasFacade;
import com.cruta.hecas.generales.GestorImpresion;
import com.cruta.hecas.generales.JSFUtil;
import com.cruta.hecas.generales.ResourcesFiles;
import com.cruta.hecas.interfaces.ISearchController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
public class ReglasSearchController implements Serializable, ISearchController {

    @Inject
    ReglasFacade reglasFacade;
    @Inject
    ResourcesFiles rf;
    @Inject
    ReglasController reglasController;
    Reglas reglas = new Reglas();
    Reglas selected = new Reglas();
    private List<Reglas> filtered;
    List<Reglas> reglasList;
    private List<Reglas> items, itemsEntity, itemsCollection;
    private Boolean usarlike = false;
    @Inject
    GestorImpresion gestorImpresion;
 private String page_call = "";

    public String getPage_call() {
        return page_call;
    }

    public void setPage_call(String page_call) {
        this.page_call = page_call;
    }
    public Reglas getReglas() {
        return reglas;
    }

    public void setReglas(Reglas reglas) {
        this.reglas = reglas;
    }

    public List<Reglas> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<Reglas> filtered) {
        this.filtered = filtered;
    }

    /**
     * Creates a new instance of ReglasDataController
     */
    public Reglas getSelected() {
        return selected;
    }

    public void setSelected(Reglas selected) {
        this.selected = selected;
    }

    public ReglasSearchController() {
        reglasList = new ArrayList<>();
    }

    public List<Reglas> getReglasList() {
        return reglasList;
    }

    public void setReglasList(List<Reglas> reglasList) {
        this.reglasList = reglasList;
    }

    public Boolean getUsarlike() {
        return usarlike;
    }

    public void setUsarlike(Boolean usarlike) {
        this.usarlike = usarlike;
    }

    @PostConstruct
    public void init() {
        iniciar();

    }

    @Override
    public String load() {
        try {
            reglas = reglasController.getReglas();
            selected = reglasFacade.find(reglas.getIdreglas());
            if (selected == null) {
                JSFUtil.warningDialog(rf.getMensajeArb("info.message"), rf.getMensajeArb("warning.noexiste"));
                reglasController.setEncontrado(false);
            } else {
                regresar();
            }
        } catch (Exception e) {
            JSFUtil.addErrorMessage("load()" + e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String clear() {
        reglasList = new ArrayList<>();
        return null;
    }

    @Override
    public void iniciar() {
        reglasList = reglasFacade.getReglasList();
    }

    @Override
    public void iniciar(String value) {
//        reglasList = reglasFacade.findByActivo(value);
    }

 

  

    public String buscarNombreplaga() {
        try {

    
         
                reglasList = reglasFacade.findByNombreplaga(reglas.getNombreplaga());
          
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";
    }

  
  

    @Override
    public String showAll() {
        try {

            reglasList = reglasFacade.findAll();

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public String regresar() {
        try {

            reglasController.setEncontrado(true);
            reglasController.setReglas(selected);
reglasController.setNuevoregistro(false);
reglasController.setDesactivar(false);
          if (page_call == ""){
          
                  
               }
          
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public String regresarSinSeleccion() {
        try {

            reglasController.setReglas(new Reglas());
            reglasController.setEncontrado(false);

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";

    }

    @Override
    public List<Reglas> getItems() {
        try {
            if (items == null) {
              items = reglasFacade.findAll();
            
            }
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return items;
    }

    @Override
    public List<Reglas> getItemsEntity() {
        return itemsEntity;
    }

    @Override
    public String changeItems() {
        try {
            itemsEntity = reglasFacade.findAll();

        } catch (Exception e) {
            JSFUtil.addErrorMessage("changeItems() " + e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public List<Reglas> getItemsCollection() {
        try {
//            itemsCollection = new ArrayList(reglas.get());

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return itemsCollection;
    }

    @Override
    public String changeItemsInverso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String imprimirTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   @Override
    public String listar(){
        showAll();
        imprimirTodos();
        return null;
    }
    @Override
      public String delete(){
        try {
            reglasFacade.remove(selected);
        reglasList.remove(selected);
        } catch (Exception e) {
              JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public void onCellEdit(CellEditEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

