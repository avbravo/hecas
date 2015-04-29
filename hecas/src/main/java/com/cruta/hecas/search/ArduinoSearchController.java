/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.search;


import com.cruta.hecas.Arduino;
import com.cruta.hecas.controller.ArduinoController;
import com.cruta.hecas.ejb.ArduinoFacade;
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
public class ArduinoSearchController implements Serializable, ISearchController {

    @Inject
    ArduinoFacade arduinoFacade;
    @Inject
    ResourcesFiles rf;
    @Inject
    ArduinoController arduinoController;
    Arduino arduino = new Arduino();
    Arduino selected = new Arduino();
    private List<Arduino> filtered;
    List<Arduino> arduinoList;
    private List<Arduino> items, itemsEntity, itemsCollection;
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
    public Arduino getArduino() {
        return arduino;
    }

    public void setArduino(Arduino arduino) {
        this.arduino = arduino;
    }

    public List<Arduino> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<Arduino> filtered) {
        this.filtered = filtered;
    }

    /**
     * Creates a new instance of ArduinoDataController
     */
    public Arduino getSelected() {
        return selected;
    }

    public void setSelected(Arduino selected) {
        this.selected = selected;
    }

    public ArduinoSearchController() {
        arduinoList = new ArrayList<>();
    }

    public List<Arduino> getArduinoList() {
        return arduinoList;
    }

    public void setArduinoList(List<Arduino> arduinoList) {
        this.arduinoList = arduinoList;
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
            arduino = arduinoController.getArduino();
            selected = arduinoFacade.find(arduino.getIdarduino());
            if (selected == null) {
                JSFUtil.warningDialog(rf.getMensajeArb("info.message"), rf.getMensajeArb("warning.noexiste"));
                arduinoController.setEncontrado(false);
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
        arduinoList = new ArrayList<>();
        return null;
    }

    @Override
    public void iniciar() {
        arduinoList = arduinoFacade.getArduinoList();
    }

    @Override
    public void iniciar(String value) {
//        arduinoList = arduinoFacade.findByActivo(value);
    }

 

  

    public String buscarFecha() {
        try {

    
         
                arduinoList = arduinoFacade.findByFecha(arduino.getFecha());
          
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";
    }

  
  

    @Override
    public String showAll() {
        try {

            arduinoList = arduinoFacade.findAll();

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public String regresar() {
        try {

            arduinoController.setEncontrado(true);
            arduinoController.setArduino(selected);
arduinoController.setNuevoregistro(false);
arduinoController.setDesactivar(false);
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

            arduinoController.setArduino(new Arduino());
            arduinoController.setEncontrado(false);

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";

    }

    @Override
    public List<Arduino> getItems() {
        try {
            if (items == null) {
              items = arduinoFacade.findAll();
            
            }
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return items;
    }

    @Override
    public List<Arduino> getItemsEntity() {
        return itemsEntity;
    }

    @Override
    public String changeItems() {
        try {
            itemsEntity = arduinoFacade.findAll();

        } catch (Exception e) {
            JSFUtil.addErrorMessage("changeItems() " + e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public List<Arduino> getItemsCollection() {
        try {
//            itemsCollection = new ArrayList(arduino.get());

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
            arduinoFacade.remove(selected);
        arduinoList.remove(selected);
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

