/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author avbravo
 */
@Entity
@Table(name = "arduino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arduino.findAll", query = "SELECT a FROM Arduino a"),
    @NamedQuery(name = "Arduino.findByIdarduino", query = "SELECT a FROM Arduino a WHERE a.idarduino = :idarduino"),
    @NamedQuery(name = "Arduino.findByFecha", query = "SELECT a FROM Arduino a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Arduino.findByTemperatura", query = "SELECT a FROM Arduino a WHERE a.temperatura = :temperatura"),
    @NamedQuery(name = "Arduino.findByHumedadrelativa", query = "SELECT a FROM Arduino a WHERE a.humedadrelativa = :humedadrelativa"),
    @NamedQuery(name = "Arduino.findByHumedadsuelo", query = "SELECT a FROM Arduino a WHERE a.humedadsuelo = :humedadsuelo"),
    @NamedQuery(name = "Arduino.findByLatitud", query = "SELECT a FROM Arduino a WHERE a.latitud = :latitud"),
    @NamedQuery(name = "Arduino.findByLongitud", query = "SELECT a FROM Arduino a WHERE a.longitud = :longitud")})
public class Arduino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarduino")
    private Integer idarduino;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperatura")
    private Double temperatura;
    @Column(name = "humedadrelativa")
    private Double humedadrelativa;
    @Column(name = "humedadsuelo")
    private Double humedadsuelo;
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longitud")
    private Double longitud;

    public Arduino() {
    }

    public Arduino(Integer idarduino) {
        this.idarduino = idarduino;
    }

    public Integer getIdarduino() {
        return idarduino;
    }

    public void setIdarduino(Integer idarduino) {
        this.idarduino = idarduino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getHumedadrelativa() {
        return humedadrelativa;
    }

    public void setHumedadrelativa(Double humedadrelativa) {
        this.humedadrelativa = humedadrelativa;
    }

    public Double getHumedadsuelo() {
        return humedadsuelo;
    }

    public void setHumedadsuelo(Double humedadsuelo) {
        this.humedadsuelo = humedadsuelo;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarduino != null ? idarduino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arduino)) {
            return false;
        }
        Arduino other = (Arduino) object;
        if ((this.idarduino == null && other.idarduino != null) || (this.idarduino != null && !this.idarduino.equals(other.idarduino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Arduino[ idarduino=" + idarduino + " ]";
    }
    
}
