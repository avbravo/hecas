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
import javax.persistence.Lob;
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
@Table(name = "plagas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plagas.findAll", query = "SELECT p FROM Plagas p"),
    @NamedQuery(name = "Plagas.findByNombreplaga", query = "SELECT p FROM Plagas p WHERE p.nombreplaga = :nombreplaga"),
    @NamedQuery(name = "Plagas.findByNombrecientifico", query = "SELECT p FROM Plagas p WHERE p.nombrecientifico = :nombrecientifico"),
    @NamedQuery(name = "Plagas.findByFoto", query = "SELECT p FROM Plagas p WHERE p.foto = :foto")})
public class Plagas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombreplaga")
    private String nombreplaga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombrecientifico")
    private String nombrecientifico;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "aquienafecta")
    private String aquienafecta;
    @Size(max = 200)
    @Column(name = "foto")
    private String foto;
    @Lob
    @Size(max = 65535)
    @Column(name = "aparicion")
    private String aparicion;
    @Lob
    @Size(max = 65535)
    @Column(name = "dano")
    private String dano;
    @Lob
    @Size(max = 65535)
    @Column(name = "controlbiologico")
    private String controlbiologico;
    @Lob
    @Size(max = 65535)
    @Column(name = "controlquimico")
    private String controlquimico;
    @Lob
    @Size(max = 65535)
    @Column(name = "controlcultural")
    private String controlcultural;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreplaga")
    private Collection<Reglas> reglasCollection;
    @OneToMany(mappedBy = "nombreplaga")
    private Collection<Plagasporcultivos> plagasporcultivosCollection;
    @OneToMany(mappedBy = "nombreplaga")
    private Collection<Condiciones> condicionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreplaga")
    private Collection<Plagascultivos> plagascultivosCollection;

    public Plagas() {
    }

    public Plagas(String nombreplaga) {
        this.nombreplaga = nombreplaga;
    }

    public Plagas(String nombreplaga, String nombrecientifico, String descripcion, String aquienafecta) {
        this.nombreplaga = nombreplaga;
        this.nombrecientifico = nombrecientifico;
        this.descripcion = descripcion;
        this.aquienafecta = aquienafecta;
    }

    public String getNombreplaga() {
        return nombreplaga;
    }

    public void setNombreplaga(String nombreplaga) {
        this.nombreplaga = nombreplaga;
    }

    public String getNombrecientifico() {
        return nombrecientifico;
    }

    public void setNombrecientifico(String nombrecientifico) {
        this.nombrecientifico = nombrecientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAquienafecta() {
        return aquienafecta;
    }

    public void setAquienafecta(String aquienafecta) {
        this.aquienafecta = aquienafecta;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAparicion() {
        return aparicion;
    }

    public void setAparicion(String aparicion) {
        this.aparicion = aparicion;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public String getControlbiologico() {
        return controlbiologico;
    }

    public void setControlbiologico(String controlbiologico) {
        this.controlbiologico = controlbiologico;
    }

    public String getControlquimico() {
        return controlquimico;
    }

    public void setControlquimico(String controlquimico) {
        this.controlquimico = controlquimico;
    }

    public String getControlcultural() {
        return controlcultural;
    }

    public void setControlcultural(String controlcultural) {
        this.controlcultural = controlcultural;
    }

    @XmlTransient
    public Collection<Reglas> getReglasCollection() {
        return reglasCollection;
    }

    public void setReglasCollection(Collection<Reglas> reglasCollection) {
        this.reglasCollection = reglasCollection;
    }

    @XmlTransient
    public Collection<Plagasporcultivos> getPlagasporcultivosCollection() {
        return plagasporcultivosCollection;
    }

    public void setPlagasporcultivosCollection(Collection<Plagasporcultivos> plagasporcultivosCollection) {
        this.plagasporcultivosCollection = plagasporcultivosCollection;
    }

    @XmlTransient
    public Collection<Condiciones> getCondicionesCollection() {
        return condicionesCollection;
    }

    public void setCondicionesCollection(Collection<Condiciones> condicionesCollection) {
        this.condicionesCollection = condicionesCollection;
    }

    @XmlTransient
    public Collection<Plagascultivos> getPlagascultivosCollection() {
        return plagascultivosCollection;
    }

    public void setPlagascultivosCollection(Collection<Plagascultivos> plagascultivosCollection) {
        this.plagascultivosCollection = plagascultivosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreplaga != null ? nombreplaga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plagas)) {
            return false;
        }
        Plagas other = (Plagas) object;
        if ((this.nombreplaga == null && other.nombreplaga != null) || (this.nombreplaga != null && !this.nombreplaga.equals(other.nombreplaga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Plagas[ nombreplaga=" + nombreplaga + " ]";
    }
    
}
