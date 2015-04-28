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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "condiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condiciones.findAll", query = "SELECT c FROM Condiciones c"),
    @NamedQuery(name = "Condiciones.findByIdcondiciones", query = "SELECT c FROM Condiciones c WHERE c.idcondiciones = :idcondiciones"),
    @NamedQuery(name = "Condiciones.findByIdfactor", query = "SELECT c FROM Condiciones c WHERE c.idfactor = :idfactor"),
    @NamedQuery(name = "Condiciones.findByCondicion", query = "SELECT c FROM Condiciones c WHERE c.condicion = :condicion"),
    @NamedQuery(name = "Condiciones.findByValor", query = "SELECT c FROM Condiciones c WHERE c.valor = :valor")})
public class Condiciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcondiciones")
    private Integer idcondiciones;
    @Column(name = "idfactor")
    private Integer idfactor;
    @Size(max = 80)
    @Column(name = "condicion")
    private String condicion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "nombreplaga", referencedColumnName = "nombreplaga")
    @ManyToOne
    private Plagas nombreplaga;

    public Condiciones() {
    }

    public Condiciones(Integer idcondiciones) {
        this.idcondiciones = idcondiciones;
    }

    public Integer getIdcondiciones() {
        return idcondiciones;
    }

    public void setIdcondiciones(Integer idcondiciones) {
        this.idcondiciones = idcondiciones;
    }

    public Integer getIdfactor() {
        return idfactor;
    }

    public void setIdfactor(Integer idfactor) {
        this.idfactor = idfactor;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
        hash += (idcondiciones != null ? idcondiciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condiciones)) {
            return false;
        }
        Condiciones other = (Condiciones) object;
        if ((this.idcondiciones == null && other.idcondiciones != null) || (this.idcondiciones != null && !this.idcondiciones.equals(other.idcondiciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Condiciones[ idcondiciones=" + idcondiciones + " ]";
    }
    
}
