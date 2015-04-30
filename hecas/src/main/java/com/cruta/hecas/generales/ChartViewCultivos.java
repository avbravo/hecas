/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.generales;

import com.cruta.hecas.Alertas;
import com.cruta.hecas.Cultivos;
import com.cruta.hecas.Plagas;
import com.cruta.hecas.ejb.AlertasFacade;
import com.cruta.hecas.ejb.CultivosFacade;
import com.cruta.hecas.ejb.PlagasFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
public class ChartViewCultivos implements Serializable {
 @Inject
 AlertasFacade alertasFacade;
 Alertas alertas = new Alertas();
 
 @Inject
 PlagasFacade plagasFacade;
 Plagas plagas = new Plagas();
 
 @Inject
 CultivosFacade cultivosFacade;
 Cultivos cultivos = new Cultivos();
         
 
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() {
          BarChartModel model = new BarChartModel();
        try {
            
        
      
   ChartSeries boys = new ChartSeries();
   List<Cultivos> listCultivos = cultivosFacade.findAll();
    Integer total ;
   if(!listCultivos.isEmpty()){
       for(Cultivos p:listCultivos){
          total = alertasFacade.getContadorCultivos(p.getNombrecultivo());
          ChartSeries b = new ChartSeries();
          b.setLabel(p.getNombrecultivo());
          b.set("total", total);
            model.addSeries(b);
            System.out.println(p.getNombrecultivo()+"total "+total );
       }
   }

         } catch (Exception e) {
             JSFUtil.addErrorMessage("error() "+e.getLocalizedMessage());
        }
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
        createHorizontalBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Cultivos");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Total");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cultivos Afectados");
        yAxis.setMin(0);
        yAxis.setMax(50);
    }
     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Gusano cachon");
        boys.set("2004", 50);
        boys.set("2005", 96);
        boys.set("2006", 44);
        boys.set("2007", 55);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Picudo");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 82);
        girls.set("2007", 35);
        girls.set("2008", 120);
 
        horizontalBarModel.addSeries(boys);
        horizontalBarModel.addSeries(girls);
         
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Danos");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");        
    }
 
}