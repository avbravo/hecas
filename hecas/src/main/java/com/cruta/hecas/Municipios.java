/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author avbravo
 */
@Entity
@Table(name = "municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"),
    @NamedQuery(name = "Municipios.findByIdmunicipio", query = "SELECT m FROM Municipios m WHERE m.idmunicipio = :idmunicipio"),
    @NamedQuery(name = "Municipios.findByMunicipio", query = "SELECT m FROM Municipios m WHERE m.municipio = :municipio"),
    @NamedQuery(name = "Municipios.findByActivo", query = "SELECT m FROM Municipios m WHERE m.activo = :activo")})
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmunicipio")
    private Integer idmunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "municipio")
    private String municipio;
    @Size(max = 2)
    @Column(name = "activo")
    private String activo;
    @JoinColumn(name = "idprovincia", referencedColumnName = "idprovincia")
    @ManyToOne(optional = false)
    private Provincias idprovincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private Collection<Corregimientos> corregimientosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private Collection<Acceso> accesoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private Collection<Historial> historialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private Collection<Errores> erroresCollection;

    public Municipios() {
    }

    public Municipios(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Municipios(Integer idmunicipio, String municipio) {
        this.idmunicipio = idmunicipio;
        this.municipio = municipio;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Provincias getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(Provincias idprovincia) {
        this.idprovincia = idprovincia;
    }

    @XmlTransient
    public Collection<Corregimientos> getCorregimientosCollection() {
        return corregimientosCollection;
    }

    public void setCorregimientosCollection(Collection<Corregimientos> corregimientosCollection) {
        this.corregimientosCollection = corregimientosCollection;
    }

    @XmlTransient
    public Collection<Acceso> getAccesoCollection() {
        return accesoCollection;
    }

    public void setAccesoCollection(Collection<Acceso> accesoCollection) {
        this.accesoCollection = accesoCollection;
    }

    @XmlTransient
    public Collection<Historial> getHistorialCollection() {
        return historialCollection;
    }

    public void setHistorialCollection(Collection<Historial> historialCollection) {
        this.historialCollection = historialCollection;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @XmlTransient
    public Collection<Errores> getErroresCollection() {
        return erroresCollection;
    }

    public void setErroresCollection(Collection<Errores> erroresCollection) {
        this.erroresCollection = erroresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmunicipio != null ? idmunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.idmunicipio == null && other.idmunicipio != null) || (this.idmunicipio != null && !this.idmunicipio.equals(other.idmunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Municipios[ idmunicipio=" + idmunicipio + " ]";
    }
    
}
