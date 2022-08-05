/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "Empresa")
public class Empresa implements Serializable{

    @Id
    @Column(name = "CodIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int CodIntId;

    @Column(name = "Nombre", nullable = true)
    String Nombre;

    @Column(name = "FechaAlta", nullable = true)
    String FechaAlta;

    @Column(name = "FechaBaja", nullable = true)
    String FechaBaja;

    @Column(name = "PersonaContacto", nullable = true)
    String PersonaContacto;

    @Column(name = "Direccion", nullable = true)
    String Direccion;

    @Column(name = "CodigoPostal", nullable = true)
    String CodigoPostal;

    @Column(name = "Poblacion", nullable = true)
    String Poblacion;

    @Column(name = "Provincia", nullable = true)
    String Provincia;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_valor")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> lista_actividades;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_valor")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> lista_colaboraciones;

    public Empresa(String Nombre, String FechaAlta, String FechaBaja, String PersonaContacto, String Direccion, String CodigoPostal, String Poblacion, String Provincia, List<ValorDesplegable> lista_actividades, List<ValorDesplegable> lista_colaboraciones) {
        this.Nombre = Nombre;
        this.FechaAlta = FechaAlta;
        this.FechaBaja = FechaBaja;
        this.PersonaContacto = PersonaContacto;
        this.Direccion = Direccion;
        this.CodigoPostal = CodigoPostal;
        this.Poblacion = Poblacion;
        this.Provincia = Provincia;
        this.lista_actividades = lista_actividades;
        this.lista_colaboraciones = lista_colaboraciones;
    }
    
    public Empresa(){        
    }

    public int getCodIntId() {
        return CodIntId;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public String getFechaBaja() {
        return FechaBaja;
    }

    public String getPersonaContacto() {
        return PersonaContacto;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public String getProvincia() {
        return Provincia;
    }

    public List<ValorDesplegable> getLista_actividades() {
        return lista_actividades;
    }

    public List<ValorDesplegable> getLista_colaboraciones() {
        return lista_colaboraciones;
    }

    public void setCodIntId(int CodIntId) {
        this.CodIntId = CodIntId;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setFechaAlta(String FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

    public void setFechaBaja(String FechaBaja) {
        this.FechaBaja = FechaBaja;
    }

    public void setPersonaContacto(String PersonaContacto) {
        this.PersonaContacto = PersonaContacto;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setCodigoPostal(String CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public void setPoblacion(String Poblacion) {
        this.Poblacion = Poblacion;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public void setLista_actividades(List<ValorDesplegable> lista_actividades) {
        this.lista_actividades = lista_actividades;
    }

    public void setLista_colaboraciones(List<ValorDesplegable> lista_colaboraciones) {
        this.lista_colaboraciones = lista_colaboraciones;
    }
    
    

}