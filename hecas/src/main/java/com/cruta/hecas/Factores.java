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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author avbravo
 */
@Entity
@Table(name = "factores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factores.findAll", query = "SELECT f FROM Factores f"),
    @NamedQuery(name = "Factores.findByIdfactores", query = "SELECT f FROM Factores f WHERE f.idfactores = :idfactores"),
    @NamedQuery(name = "Factores.findByFactor", query = "SELECT f FROM Factores f WHERE f.factor = :factor")})
public class Factores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactores")
    private Integer idfactores;
    @Size(max = 80)
    @Column(name = "factor")
    private String factor;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;

    public Factores() {
    }

    public Factores(Integer idfactores) {
        this.idfactores = idfactores;
    }

    public Integer getIdfactores() {
        return idfactores;
    }

    public void setIdfactores(Integer idfactores) {
        this.idfactores = idfactores;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactores != null ? idfactores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factores)) {
            return false;
        }
        Factores other = (Factores) object;
        if ((this.idfactores == null && other.idfactores != null) || (this.idfactores != null && !this.idfactores.equals(other.idfactores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Factores[ idfactores=" + idfactores + " ]";
    }
    
}
