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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "ConferenciaSantaMaria")
public class ConferenciaSantaMaria implements Serializable{

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "NumExtId", nullable = true)
    int NumExtId;

    @Column(name = "FechaAlta", nullable = true)
    String FechaAlta;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Categoria> lista_categorias;

    @Column(name = "Cargo", nullable = true)
    String Cargo;

    @Column(name = "Nombre", nullable = true)
    String Nombre;

    @Column(name = "Apellidos", nullable = true)
    String Apellidos;

    @Column(name = "Nif", nullable = true)
    String Nif;

    @Column(name = "Sexo", nullable = true)
    String Sexo;

    @Column(name = "FechaNac", nullable = true)
    String FechaNac;

    @Column(name = "Direccion", nullable = true)
    String Direccion;

    @Column(name = "CodigoPostal", nullable = true)
    String CodigoPostal;

    @Column(name = "Poblacion", nullable = true)
    String Poblacion;

    @Column(name = "Provincia", nullable = true)
    String Provincia;

    @Column(name = "Telefono", nullable = true)
    String Telefono;

    @Column(name = "Mail", nullable = true)
    String Mail;

    @Column(name = "CuentaBancaria", nullable = true)
    String CuentaBancaria;

    @Column(name = "Cuota", nullable = true)
    float Cuota;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Aportacion> lista_aportaciones;

    @Column(name = "Actividad", nullable = true)
    String Actividad;

    @Column(name = "TiempoDedicacion", nullable = true)
    String TiempoDedicacion;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_conferencia;//Son las observaciones referentes a la conferencia santa maria

    @Column(name = "PermisoAcceso", nullable = true)
    Boolean PermisoAcceso;//CHECK

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Perfil> lista_perfilesacceso;

    @Column(name = "AccesoFichaIndividual", nullable = true)
    Boolean AccesoFichaIndividual; //CHECK

    @Column(name = "Usuario", nullable = true)
    String Usuario;

    @Column(name = "Password", nullable = true)
    String Password;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FicheroAdjunto> ficheros_conferenciasantamaria;
}
