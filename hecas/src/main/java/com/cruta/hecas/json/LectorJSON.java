/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.json;

import com.cruta.hecas.Advertencias;
import com.cruta.hecas.Arduino;
import com.cruta.hecas.Reglas;
import com.cruta.hecas.ejb.AdvertenciasFacade;
import com.cruta.hecas.ejb.ArduinoFacade;
import com.cruta.hecas.ejb.ReglasFacade;
import com.cruta.hecas.generales.JSFUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

/**
 *
 * @author avbravo
 */
@Named(value = "lectorJSON")
@SessionScoped
public class LectorJSON implements Serializable{
private String lectura;
 @Inject
    AdvertenciasFacade advertenciasFacade;
    Advertencias advertencias = new Advertencias();
    @Inject
    ReglasFacade reglasFacade;
    Reglas reglas = new Reglas();
    @Inject
    ArduinoFacade arduinoFacade;
    Arduino arduino = new Arduino();
    public String getLectura() {
        return lectura;
    }

    public void setLectura(String lectura) {
        this.lectura = lectura;
    }


    /**
     * Creates a new instance of LectorJSON
     */
    public LectorJSON() {
    }

     public String save() {
        try {
           arduino.setFecha(JSFUtil.getFechaActual());
arduino.setHora(JSFUtil.getHoraActual().toString());
arduino.setHumedadsuelo(0.0);
arduino.setLongitud(0.0);
arduino.setArchivo("OpenWeatherMap");
arduino.setIdarduino(arduinoFacade.getMaximo() +1);
arduinoFacade.create(arduino);


//            if (arduinoFacade.find(arduino.getIdarduino()) != null) {
//                JSFUtil.addWarningMessage("Ya se registro anteriormente esa lectura");
//                return null;
//            }
            arduinoFacade.create(arduino);
            JSFUtil.infoDialog("mensaje", "Guardado exitosamente");

          
            analizarReglas();
            arduino = new Arduino();
        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getLocalizedMessage());
        }
        return null;
    }

    public String lector() throws IOException {
        try {
StringBuilder sb = new StringBuilder();

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Panama");
        InputStream is = url.openStream();
        
                    JsonParser parser = Json.createParser(is) ;
//                    System.out.println("parser "+parser.getString());
//                    lectura = parser.getString();
                while (parser.hasNext()) {
                    Event e = parser.next();
                    if (e == Event.KEY_NAME) {
                        switch (parser.getString()) {
                            case "long":
                                parser.next();
//                                System.out.print("long: "+parser.getString());
//                                System.out.print(": ");
                         arduino.setLongitud(Double.parseDouble(parser.getString()));
                                break;
                                case "lat":
                               parser.next();
//                                System.out.print("lat: "+parser.getString());
//                                System.out.print(": ");
                                  arduino.setLatitud(Double.parseDouble(parser.getString()));
                                break;
                            case "temp":
                                parser.next();
//                                System.out.print("temp:"+parser.getString());
//                                Double temp = Double.parseDouble(parser.getString())-273;
//                                System.out.print(": "+temp);
                                arduino.setTemperatura(Double.parseDouble(parser.getString())-273);
                                break;
//                            case "temp_min":
//                                parser.next();
//                                System.out.println(parser.getString());
//                                System.out.println("---------");
//                                break;
                            case "humidity":
                                parser.next();
                                arduino.setHumedadrelativa(Double.parseDouble(parser.getString()));
                                break;
//                                case "description":
//                                parser.next();
//                                System.out.println("description"+parser.getString());
//                                System.out.println("---------");
//                                break;
                        }
                    }
                }

            save();

        } catch (MalformedURLException ex) {
            Logger.getLogger(LectorJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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