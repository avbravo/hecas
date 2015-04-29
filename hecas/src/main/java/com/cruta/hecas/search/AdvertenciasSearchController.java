/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.search;


import com.cruta.hecas.Advertencias;
import com.cruta.hecas.controller.AdvertenciasController;
import com.cruta.hecas.ejb.AdvertenciasFacade;
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
public class AdvertenciasSearchController implements Serializable, ISearchController {

    @Inject
    AdvertenciasFacade advertenciasFacade;
    @Inject
    ResourcesFiles rf;
    @Inject
    AdvertenciasController advertenciasController;
    Advertencias advertencias = new Advertencias();
    Advertencias selected = new Advertencias();
    private List<Advertencias> filtered;
    List<Advertencias> advertenciasList;
    private List<Advertencias> items, itemsEntity, itemsCollection;
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
    public Advertencias getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(Advertencias advertencias) {
        this.advertencias = advertencias;
    }

    public List<Advertencias> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<Advertencias> filtered) {
        this.filtered = filtered;
    }

    /**
     * Creates a new instance of AdvertenciasDataController
     */
    public Advertencias getSelected() {
        return selected;
    }

    public void setSelected(Advertencias selected) {
        this.selected = selected;
    }

    public AdvertenciasSearchController() {
        advertenciasList = new ArrayList<>();
    }

    public List<Advertencias> getAdvertenciasList() {
        return advertenciasList;
    }

    public void setAdvertenciasList(List<Advertencias> advertenciasList) {
        this.advertenciasList = advertenciasList;
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
            advertencias = advertenciasController.getAdvertencias();
            selected = advertenciasFacade.find(advertencias.getIdadvertencias());
            if (selected == null) {
                JSFUtil.warningDialog(rf.getMensajeArb("info.message"), rf.getMensajeArb("warning.noexiste"));
                advertenciasController.setEncontrado(false);
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
        advertenciasList = new ArrayList<>();
        return null;
    }

    @Override
    public void iniciar() {
        advertenciasList = advertenciasFacade.getAdvertenciasList();
    }

    @Override
    public void iniciar(String value) {
//        advertenciasList = advertenciasFacade.findByActivo(value);
    }

 

  

    public String buscarNombreplaga() {
        try {

    
         
                advertenciasList = advertenciasFacade.findByNombreplaga(advertencias.getNombreplaga());
          
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";
    }

  
  

    @Override
    public String showAll() {
        try {

            advertenciasList = advertenciasFacade.findAll();

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public String regresar() {
        try {

            advertenciasController.setEncontrado(true);
            advertenciasController.setAdvertencias(selected);
advertenciasController.setNuevoregistro(false);
advertenciasController.setDesactivar(false);
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

            advertenciasController.setAdvertencias(new Advertencias());
            advertenciasController.setEncontrado(false);

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";

    }

    @Override
    public List<Advertencias> getItems() {
        try {
            if (items == null) {
              items = advertenciasFacade.findAll();
            
            }
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return items;
    }

    @Override
    public List<Advertencias> getItemsEntity() {
        return itemsEntity;
    }

    @Override
    public String changeItems() {
        try {
            itemsEntity = advertenciasFacade.findAll();

        } catch (Exception e) {
            JSFUtil.addErrorMessage("changeItems() " + e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public List<Advertencias> getItemsCollection() {
        try {
//            itemsCollection = new ArrayList(advertencias.get());

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
            advertenciasFacade.remove(selected);
        advertenciasList.remove(selected);
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

