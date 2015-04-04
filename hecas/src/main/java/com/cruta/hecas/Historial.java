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
@Table(name = "historial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historial.findAll", query = "SELECT h FROM Historial h"),
    @NamedQuery(name = "Historial.findByIdhistorial", query = "SELECT h FROM Historial h WHERE h.idhistorial = :idhistorial"),
    @NamedQuery(name = "Historial.findByTabla", query = "SELECT h FROM Historial h WHERE h.tabla = :tabla"),
    @NamedQuery(name = "Historial.findByUsername", query = "SELECT h FROM Historial h WHERE h.username = :username"),
    @NamedQuery(name = "Historial.findByFecha", query = "SELECT h FROM Historial h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "Historial.findByHora", query = "SELECT h FROM Historial h WHERE h.hora = :hora"),
    @NamedQuery(name = "Historial.findByEliminado", query = "SELECT h FROM Historial h WHERE h.eliminado = :eliminado")})
public class Historial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idhistorial")
    private Integer idhistorial;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "tabla")
    private String tabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "hora")
    private String hora;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "eliminado")
    private String eliminado;
    @JoinColumn(name = "idmunicipio", referencedColumnName = "idmunicipio")
    @ManyToOne(optional = false)
    private Municipios idmunicipio;

    public Historial() {
    }

    public Historial(Integer idhistorial) {
        this.idhistorial = idhistorial;
    }

    public Historial(Integer idhistorial, String data, String tabla, String username, Date fecha, String hora, String descripcion, String eliminado) {
        this.idhistorial = idhistorial;
        this.data = data;
        this.tabla = tabla;
        this.username = username;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.eliminado = eliminado;
    }

    public Integer getIdhistorial() {
        return idhistorial;
    }

    public void setIdhistorial(Integer idhistorial) {
        this.idhistorial = idhistorial;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    public Municipios getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Municipios idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistorial != null ? idhistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.idhistorial == null && other.idhistorial != null) || (this.idhistorial != null && !this.idhistorial.equals(other.idhistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Historial[ idhistorial=" + idhistorial + " ]";
    }
    
}
