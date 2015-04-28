/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author avbravo
 */
@Entity
@Table(name = "reglas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reglas.findAll", query = "SELECT r FROM Reglas r"),
    @NamedQuery(name = "Reglas.findByIdreglas", query = "SELECT r FROM Reglas r WHERE r.idreglas = :idreglas"),
    @NamedQuery(name = "Reglas.findByTemperaturainicial", query = "SELECT r FROM Reglas r WHERE r.temperaturainicial = :temperaturainicial"),
    @NamedQuery(name = "Reglas.findByTemperaturafinal", query = "SELECT r FROM Reglas r WHERE r.temperaturafinal = :temperaturafinal"),
    @NamedQuery(name = "Reglas.findByAplicatemperatura", query = "SELECT r FROM Reglas r WHERE r.aplicatemperatura = :aplicatemperatura"),
    @NamedQuery(name = "Reglas.findByAplicahumedadrelativa", query = "SELECT r FROM Reglas r WHERE r.aplicahumedadrelativa = :aplicahumedadrelativa"),
    @NamedQuery(name = "Reglas.findByHumedadrelativaminimo", query = "SELECT r FROM Reglas r WHERE r.humedadrelativaminimo = :humedadrelativaminimo"),
    @NamedQuery(name = "Reglas.findByHumedadrelativamaximo", query = "SELECT r FROM Reglas r WHERE r.humedadrelativamaximo = :humedadrelativamaximo"),
    @NamedQuery(name = "Reglas.findByAplicahumedadsuelo", query = "SELECT r FROM Reglas r WHERE r.aplicahumedadsuelo = :aplicahumedadsuelo"),
    @NamedQuery(name = "Reglas.findByHumedadsuelominimo", query = "SELECT r FROM Reglas r WHERE r.humedadsuelominimo = :humedadsuelominimo"),
    @NamedQuery(name = "Reglas.findByHumedadsuelomaximo", query = "SELECT r FROM Reglas r WHERE r.humedadsuelomaximo = :humedadsuelomaximo")})
public class Reglas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idreglas")
    private Integer idreglas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperaturainicial")
    private Double temperaturainicial;
    @Column(name = "temperaturafinal")
    private Double temperaturafinal;
    @Size(max = 2)
    @Column(name = "aplicatemperatura")
    private String aplicatemperatura;
    @Size(max = 2)
    @Column(name = "aplicahumedadrelativa")
    private String aplicahumedadrelativa;
    @Column(name = "humedadrelativaminimo")
    private Double humedadrelativaminimo;
    @Column(name = "humedadrelativamaximo")
    private Double humedadrelativamaximo;
    @Size(max = 2)
    @Column(name = "aplicahumedadsuelo")
    private String aplicahumedadsuelo;
    @Column(name = "humedadsuelominimo")
    private Double humedadsuelominimo;
    @Column(name = "humedadsuelomaximo")
    private Double humedadsuelomaximo;
    @JoinColumn(name = "nombreplaga", referencedColumnName = "nombreplaga")
    @ManyToOne(optional = false)
    private Plagas nombreplaga;

    public Reglas() {
    }

    public Reglas(Integer idreglas) {
        this.idreglas = idreglas;
    }

    public Integer getIdreglas() {
        return idreglas;
    }

    public void setIdreglas(Integer idreglas) {
        this.idreglas = idreglas;
    }

    public Double getTemperaturainicial() {
        return temperaturainicial;
    }

    public void setTemperaturainicial(Double temperaturainicial) {
        this.temperaturainicial = temperaturainicial;
    }

    public Double getTemperaturafinal() {
        return temperaturafinal;
    }

    public void setTemperaturafinal(Double temperaturafinal) {
        this.temperaturafinal = temperaturafinal;
    }

    public String getAplicatemperatura() {
        return aplicatemperatura;
    }

    public void setAplicatemperatura(String aplicatemperatura) {
        this.aplicatemperatura = aplicatemperatura;
    }

    public String getAplicahumedadrelativa() {
        return aplicahumedadrelativa;
    }

    public void setAplicahumedadrelativa(String aplicahumedadrelativa) {
        this.aplicahumedadrelativa = aplicahumedadrelativa;
    }

    public Double getHumedadrelativaminimo() {
        return humedadrelativaminimo;
    }

    public void setHumedadrelativaminimo(Double humedadrelativaminimo) {
        this.humedadrelativaminimo = humedadrelativaminimo;
    }

    public Double getHumedadrelativamaximo() {
        return humedadrelativamaximo;
    }

    public void setHumedadrelativamaximo(Double humedadrelativamaximo) {
        this.humedadrelativamaximo = humedadrelativamaximo;
    }

    public String getAplicahumedadsuelo() {
        return aplicahumedadsuelo;
    }

    public void setAplicahumedadsuelo(String aplicahumedadsuelo) {
        this.aplicahumedadsuelo = aplicahumedadsuelo;
    }

    public Double getHumedadsuelominimo() {
        return humedadsuelominimo;
    }

    public void setHumedadsuelominimo(Double humedadsuelominimo) {
        this.humedadsuelominimo = humedadsuelominimo;
    }

    public Double getHumedadsuelomaximo() {
        return humedadsuelomaximo;
    }

    public void setHumedadsuelomaximo(Double humedadsuelomaximo) {
        this.humedadsuelomaximo = humedadsuelomaximo;
    }

    public Plagas getNombreplaga() {
        return nombreplaga;
    }

    public void setNombreplaga(Plagas nombreplaga) {
        this.nombreplaga = nombreplaga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreglas != null ? idreglas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reglas)) {
            return false;
        }
        Reglas other = (Reglas) object;
        if ((this.idreglas == null && other.idreglas != null) || (this.idreglas != null && !this.idreglas.equals(other.idreglas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Reglas[ idreglas=" + idreglas + " ]";
    }
    
}
