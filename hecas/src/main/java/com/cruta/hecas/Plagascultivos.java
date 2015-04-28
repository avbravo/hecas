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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author avbravo
 */
@Entity
@Table(name = "plagascultivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plagascultivos.findAll", query = "SELECT p FROM Plagascultivos p"),
    @NamedQuery(name = "Plagascultivos.findByIdplagascultivos", query = "SELECT p FROM Plagascultivos p WHERE p.idplagascultivos = :idplagascultivos")})
public class Plagascultivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplagascultivos")
    private Integer idplagascultivos;
    @JoinColumn(name = "nombreplaga", referencedColumnName = "nombreplaga")
    @ManyToOne(optional = false)
    private Plagas nombreplaga;
    @JoinColumn(name = "nombrecultivo", referencedColumnName = "nombrecultivo")
    @ManyToOne(optional = false)
    private Cultivos nombrecultivo;

    public Plagascultivos() {
    }

    public Plagascultivos(Integer idplagascultivos) {
        this.idplagascultivos = idplagascultivos;
    }

    public Integer getIdplagascultivos() {
        return idplagascultivos;
    }

    public void setIdplagascultivos(Integer idplagascultivos) {
        this.idplagascultivos = idplagascultivos;
    }

    public Plagas getNombreplaga() {
        return nombreplaga;
    }

    public void setNombreplaga(Plagas nombreplaga) {
        this.nombreplaga = nombreplaga;
    }

    public Cultivos getNombrecultivo() {
        return nombrecultivo;
    }

    public void setNombrecultivo(Cultivos nombrecultivo) {
        this.nombrecultivo = nombrecultivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplagascultivos != null ? idplagascultivos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plagascultivos)) {
            return false;
        }
        Plagascultivos other = (Plagascultivos) object;
        if ((this.idplagascultivos == null && other.idplagascultivos != null) || (this.idplagascultivos != null && !this.idplagascultivos.equals(other.idplagascultivos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Plagascultivos[ idplagascultivos=" + idplagascultivos + " ]";
    }
    
}
