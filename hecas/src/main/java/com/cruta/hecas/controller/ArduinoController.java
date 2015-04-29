/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.controller;

import com.cruta.hecas.Advertencias;
import com.cruta.hecas.Alertas;
import com.cruta.hecas.Arduino;
import com.cruta.hecas.Reglas;
import com.cruta.hecas.ejb.AdvertenciasFacade;
import com.cruta.hecas.ejb.AlertasFacade;
import com.cruta.hecas.ejb.ArduinoFacade;
import com.cruta.hecas.ejb.ReglasFacade;
import com.cruta.hecas.generales.GestorImpresion;
import com.cruta.hecas.generales.JSFUtil;
import com.cruta.hecas.generales.LoginBean;
import com.cruta.hecas.generales.ResourcesFiles;
import com.cruta.hecas.interfaces.IController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.LatLng;

/**
 *
 * @author avbravo
 */
@Named
@SessionScoped
public class ArduinoController implements Serializable, IController {

    private static final long serialVersionUID = 1L;
    @Inject
    AdvertenciasFacade advertenciasFacade;
    Advertencias advertencias = new Advertencias();
    @Inject
    ReglasFacade reglasFacade;
    Reglas reglas = new Reglas();
    @Inject
    ArduinoFacade arduinoFacade;
    Arduino arduino = new Arduino();
    private Boolean encontrado = false;
    @Inject
    ResourcesFiles rf;
    @Inject
    GestorImpresion gestorImpresion;
    @Inject
    LoginBean loginBean;
    private Boolean nuevoregistro = false;
    Boolean desactivar = true;

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

    public void verificar() {
        System.out.println("aplicahumedadsuelo " + aplicahumedadsuelo);
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

    public Arduino getArduino() {
        return arduino;
    }

    public void setArduino(Arduino arduino) {
        this.arduino = arduino;
    }

    public Boolean getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(Boolean encontrado) {
        this.encontrado = encontrado;
    }

    /**
     * Creates a new instance of ArduinoController
     */
    public ArduinoController() {
    }

    @PostConstruct
    public void init() {
        desactivar = true;
        nuevoregistro = false;
        arduino = new Arduino();
        limpiar();
    }

    private void limpiar() {

    }

    @Override
    public String buscar() {
        arduino = arduinoFacade.find(arduino.getIdarduino());
        if (arduino == null) {
            encontrado = false;
            JSFUtil.addWarningMessage(rf.getMensajeArb("warning.noexiste"));
            arduino = new Arduino();
        } else {
            encontrado = true;
        }
        return "";
    }

    @Override
    public String prepararNew() {
        desactivar = false;
        try {
            nuevoregistro = true;
            encontrado = false;
            arduino = new Arduino();
            limpiar();

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String save() {
        try {
            arduino.setIdarduino(arduinoFacade.getMaximo() + 1);

            if (arduinoFacade.find(arduino.getIdarduino()) != null) {
                JSFUtil.addWarningMessage("Ya se registro anteriormente esa lectura");
                return null;
            }
            arduinoFacade.create(arduino);
            JSFUtil.infoDialog("mensaje", "Guardado exitosamente");

            this.nuevoregistro = false;
            analizarReglas();
            arduino = new Arduino();
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String edit() {
        try {

            arduinoFacade.edit(arduino);

            JSFUtil.addSuccessMessage(rf.getMensajeArb("info.update"));

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public String delete() {
        try {
            arduinoFacade.remove(arduino);
            JSFUtil.addSuccessMessage(rf.getMensajeArb("info.delete"));

            encontrado = false;
            arduino = new Arduino();

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String imprimir() {
//        try {
//            List<Arduino> list = new ArrayList<>();
//            list.add(arduino);
//            String ruta = "/resources/reportes/arduino/arduino.jasper";
//            HashMap parameters = new HashMap();
//            gestorImpresion.imprimir(list, ruta, parameters);
//        } catch (Exception ex) {
//            JSFUtil.addErrorMessage("imprimir() " + ex.getLocalizedMessage());
//        }
        return null;
    }

    @Override
    public String imprimirTodos() {
//        String ruta = "/resources/reportes/arduino/arduino.jasper";
//        HashMap parameters = new HashMap();
//        gestorImpresion.imprimir(arduinoFacade.getArduinoList(), ruta, parameters);
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
    public String habilitarConsultar() {
        desactivar = true;
        arduino.setIdarduino(0);
        this.nuevoregistro = false;
        return "";
    }

    @Override
    public Integer getIdSiguiente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {

            UploadedFile file = event.getFile();

            String destination = JSFUtil.getPathArduino();
            if (destination == null) {
                JSFUtil.addErrorMessage("No se obtuvo la ruta del archivo");
            } else {
                Boolean continuarGenerado = true;

                String nuevoNombreLogo = "";

                nuevoNombreLogo = JSFUtil.getUUID() + JSFUtil.getExtension(file.getFileName());
                if (JSFUtil.copyFile(nuevoNombreLogo, file.getInputstream(), destination)) {

                    FileReader f = new FileReader("/" + destination + nuevoNombreLogo);
                    String cadena;
                    BufferedReader b = new BufferedReader(f);
                    Integer contador = -1;
                    String fecha = "", temperatura = "", humedadrelativa = "", humedadsuelo = "", hora = "";
                    while ((cadena = b.readLine()) != null) {
                        contador++;
                        if (contador == 0) {
                            //cabecera
                        } else {
                            arduino = new Arduino();
                            StringTokenizer st = new StringTokenizer(cadena);
                            Integer indice = -1;

                            while (st.hasMoreTokens()) {
                                String texto = st.nextToken();

                                indice++;
                                switch (indice) {
                                    case 0:
                                        fecha = texto;

                                        Date apptDay = null;
                                        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

                                        java.sql.Date sqlDate;
                                        apptDay = (Date) df.parse(texto);
                                        sqlDate = new java.sql.Date(apptDay.getTime());

                                        arduino.setFecha(sqlDate);

//                                       
//                                      
                                        break;
                                    case 1:
//                                        hora = texto;
                                        hora = texto.contains(",") ? texto.replaceAll(",", "") : texto;
                                        arduino.setHora(hora);
                                        break;
                                    case 2:
                                        temperatura = texto.contains(",") ? texto.replaceAll(",", "") : texto;
                                        arduino.setTemperatura(Double.parseDouble(temperatura));
                                        break;
                                    case 3:
                                        humedadrelativa = texto.contains(",") ? texto.replaceAll(",", "") : texto;
                                        arduino.setHumedadrelativa(Double.parseDouble(humedadrelativa));
                                        break;
                                    case 4:
                                        humedadsuelo = texto.contains(",") ? texto.replaceAll(",", "") : texto;
                                        arduino.setHumedadsuelo(Double.parseDouble(humedadsuelo));
                                        break;

                                }
//                              
                            }

                            arduino.setArchivo(nuevoNombreLogo);

//                           
                        }

                    }
                    b.close();

                }
            }

            JSFUtil.addSuccessMessage( "Se subio archivo exitosamente ");

        } catch (Exception e) {
            JSFUtil.addErrorMessage("handleFileUpload()" + e.getLocalizedMessage());
        }

    }

    public void onPointSelect(PointSelectEvent event) {
        System.out.println("onPointSelect");
        LatLng latlng = event.getLatLng();
        arduino.setLatitud(latlng.getLat());

        arduino.setLongitud(latlng.getLng());

    }

    public String analizarReglas() {
        try {
            List<Reglas> listReglas = reglasFacade.findAll();
            if (!listReglas.isEmpty()) {
                for (Reglas r : listReglas) {

                    if (r.getAplicatemperatura().equals("si")) {
                        if (arduino.getTemperatura() >= r.getTemperaturainicial() && arduino.getTemperatura() <= r.getTemperaturafinal()) {
                            advertencias.setIdadvertencias(advertenciasFacade.getMaximo() + 1);
                            advertencias.setFecha(JSFUtil.getFechaActual());
                            advertencias.setDescripcion("Variaciones en la temperatura de " + arduino.getTemperatura() + " pueden generar la aparcion de la plaga");
                            advertencias.setNombreplaga(r.getNombreplaga());
                            advertenciasFacade.create(advertencias);
                            JSFUtil.infoDialog("Temperatura", "Aparece plaga: " + r.getNombreplaga().getNombreplaga());
                        }

                    }
                    if (r.getAplicahumedadrelativa().equals("si")) {
                        if (arduino.getHumedadrelativa() >= r.getHumedadrelativaminimo() && arduino.getHumedadrelativa() <= r.getHumedadrelativamaximo()) {
                            advertencias.setIdadvertencias(advertenciasFacade.getMaximo() + 1);
                            advertencias.setFecha(JSFUtil.getFechaActual());
                            advertencias.setDescripcion("Variaciones en la humedad relativa de " + arduino.getHumedadrelativa() + " pueden generar la aparcion de la plaga");
                            advertencias.setNombreplaga(r.getNombreplaga());
                            advertenciasFacade.create(advertencias);
                            JSFUtil.infoDialog("Humedad relativa", "Aparece plaga: " + r.getNombreplaga().getNombreplaga());
                        }
                    }
                    if (r.getAplicahumedadsuelo().equals("si")) {
                        if (arduino.getHumedadsuelo() >= r.getHumedadsuelominimo() && arduino.getHumedadsuelo() <= r.getHumedadsuelomaximo()) {
                            advertencias.setIdadvertencias(advertenciasFacade.getMaximo() + 1);
                            advertencias.setFecha(JSFUtil.getFechaActual());
                            advertencias.setDescripcion("Variaciones en la humedad del suelo de " + arduino.getHumedadsuelo() + " pueden generar la aparcion de la plaga");
                            advertencias.setNombreplaga(r.getNombreplaga());
                            advertenciasFacade.create(advertencias);
                            JSFUtil.infoDialog("Humedad suelo", "Aparece plaga: " + r.getNombreplaga().getNombreplaga());
                        }
                    }

                }
            } else {
                JSFUtil.infoDialog("Mensaje", "No hay reglas para analizar");
            }
        } catch (Exception e) {
            JSFUtil.addErrorMessage("analizarReglas()" + e.getLocalizedMessage());
        }
        return null;
    }
}
