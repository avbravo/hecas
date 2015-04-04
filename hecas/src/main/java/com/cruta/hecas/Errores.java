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
@Table(name = "errores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Errores.findAll", query = "SELECT e FROM Errores e"),
    @NamedQuery(name = "Errores.findByIderror", query = "SELECT e FROM Errores e WHERE e.iderror = :iderror"),
    @NamedQuery(name = "Errores.findByHora", query = "SELECT e FROM Errores e WHERE e.hora = :hora"),
    @NamedQuery(name = "Errores.findByFormulario", query = "SELECT e FROM Errores e WHERE e.formulario = :formulario"),
    @NamedQuery(name = "Errores.findByMetodo", query = "SELECT e FROM Errores e WHERE e.metodo = :metodo"),
    @NamedQuery(name = "Errores.findByFecha", query = "SELECT e FROM Errores e WHERE e.fecha = :fecha")})
public class Errores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iderror")
    private Integer iderror;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "hora")
    private String hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "formulario")
    private String formulario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "metodo")
    private String metodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idmunicipio", referencedColumnName = "idmunicipio")
    @ManyToOne(optional = false)
    private Municipios idmunicipio;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Usuarios username;

    public Errores() {
    }

    public Errores(Integer iderror) {
        this.iderror = iderror;
    }

    public Errores(Integer iderror, String descripcion, String hora, String formulario, String metodo, Date fecha) {
        this.iderror = iderror;
        this.descripcion = descripcion;
        this.hora = hora;
        this.formulario = formulario;
        this.metodo = metodo;
        this.fecha = fecha;
    }

    public Integer getIderror() {
        return iderror;
    }

    public void setIderror(Integer iderror) {
        this.iderror = iderror;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Municipios getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Municipios idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Usuarios getUsername() {
        return username;
    }

    public void setUsername(Usuarios username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iderror != null ? iderror.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Errores)) {
            return false;
        }
        Errores other = (Errores) object;
        if ((this.iderror == null && other.iderror != null) || (this.iderror != null && !this.iderror.equals(other.iderror))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Errores[ iderror=" + iderror + " ]";
    }
    
}
