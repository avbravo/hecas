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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author avbravo
 */
@Entity
@Table(name = "advertencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertencias.findAll", query = "SELECT a FROM Advertencias a"),
    @NamedQuery(name = "Advertencias.findByIdadvertencias", query = "SELECT a FROM Advertencias a WHERE a.idadvertencias = :idadvertencias"),
    @NamedQuery(name = "Advertencias.findByFecha", query = "SELECT a FROM Advertencias a WHERE a.fecha = :fecha")})
public class Advertencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadvertencias")
    private Integer idadvertencias;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "nombreplaga", referencedColumnName = "nombreplaga")
    @ManyToOne(optional = false)
    private Plagas nombreplaga;

    public Advertencias() {
    }

    public Advertencias(Integer idadvertencias) {
        this.idadvertencias = idadvertencias;
    }

    public Advertencias(Integer idadvertencias, String descripcion, Date fecha) {
        this.idadvertencias = idadvertencias;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getIdadvertencias() {
        return idadvertencias;
    }

    public void setIdadvertencias(Integer idadvertencias) {
        this.idadvertencias = idadvertencias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idadvertencias != null ? idadvertencias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertencias)) {
            return false;
        }
        Advertencias other = (Advertencias) object;
        if ((this.idadvertencias == null && other.idadvertencias != null) || (this.idadvertencias != null && !this.idadvertencias.equals(other.idadvertencias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Advertencias[ idadvertencias=" + idadvertencias + " ]";
    }
    
}
