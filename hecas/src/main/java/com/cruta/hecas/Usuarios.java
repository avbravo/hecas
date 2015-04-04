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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsername", query = "SELECT u FROM Usuarios u WHERE u.username = :username"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuarios.findByCelular", query = "SELECT u FROM Usuarios u WHERE u.celular = :celular"),
    @NamedQuery(name = "Usuarios.findByTema", query = "SELECT u FROM Usuarios u WHERE u.tema = :tema"),
    @NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuarios u WHERE u.activo = :activo"),
    @NamedQuery(name = "Usuarios.findByCedula", query = "SELECT u FROM Usuarios u WHERE u.cedula = :cedula")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 80)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 20)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "tema")
    private String tema;
    @Size(max = 2)
    @Column(name = "activo")
    private String activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "cedula")
    private String cedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Acceso> accesoCollection;
    @JoinColumn(name = "idgrupousuario", referencedColumnName = "idgrupousuario")
    @ManyToOne(optional = false)
    private Grupousuarios idgrupousuario;
    @JoinColumn(name = "idmunicipio", referencedColumnName = "idmunicipio")
    @ManyToOne(optional = false)
    private Municipios idmunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Errores> erroresCollection;

    public Usuarios() {
    }

    public Usuarios(String username) {
        this.username = username;
    }

    public Usuarios(String username, String password, String nombre, String tema, String cedula) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.tema = tema;
        this.cedula = cedula;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @XmlTransient
    public Collection<Acceso> getAccesoCollection() {
        return accesoCollection;
    }

    public void setAccesoCollection(Collection<Acceso> accesoCollection) {
        this.accesoCollection = accesoCollection;
    }

    public Grupousuarios getIdgrupousuario() {
        return idgrupousuario;
    }

    public void setIdgrupousuario(Grupousuarios idgrupousuario) {
        this.idgrupousuario = idgrupousuario;
    }

    public Municipios getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Municipios idmunicipio) {
        this.idmunicipio = idmunicipio;
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
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cruta.hecas.Usuarios[ username=" + username + " ]";
    }
    
}
