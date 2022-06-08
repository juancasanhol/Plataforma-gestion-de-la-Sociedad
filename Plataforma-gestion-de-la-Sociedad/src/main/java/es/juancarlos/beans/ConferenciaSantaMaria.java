/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.sql.Date;
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
public class ConferenciaSantaMaria {

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "NumExtId", nullable = false)
    int NumExtId;

    @Column(name = "FechaAlta", nullable = false)
    Date FechaAlta;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Categoria> lista_categorias;

    @Column(name = "Cargo", nullable = false)
    String Cargo;

    @Column(name = "Nombre", nullable = false)
    String Nombre;

    @Column(name = "Apellidos", nullable = false)
    String Apellidos;

    @Column(name = "Nif", nullable = false)
    String Nif;

    @Column(name = "Sexo", nullable = false)
    String Sexo;

    @Column(name = "FechaNac", nullable = false)
    Date FechaNac;

    @Column(name = "Direccion", nullable = false)
    String Direccion;

    @Column(name = "CodigoPostal", nullable = false)
    String CodigoPostal;

    @Column(name = "Poblacion", nullable = false)
    String Poblacion;

    @Column(name = "Provincia", nullable = false)
    String Provincia;

    @Column(name = "Telefono", nullable = false)
    String Telefono;

    @Column(name = "Mail", nullable = false)
    String Mail;

    @Column(name = "CuentaBancaria", nullable = false)
    String CuentaBancaria;

    @Column(name = "Cuota", nullable = false)
    float Cuota;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Aportacion> lista_aportaciones;

    @Column(name = "Actividad", nullable = false)
    String Actividad;

    @Column(name = "TiempoDedicacion", nullable = false)
    String TiempoDedicacion;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_conferencia;//Son las observaciones referentes a la conferencia santa maria

    @Column(name = "PermisoAcceso", nullable = false)
    Boolean PermisoAcceso;//CHECK

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Perfil> lista_perfilesacceso;

    @Column(name = "AccesoFichaIndividual", nullable = false)
    Boolean AccesoFichaIndividual; //CHECK

    @Column(name = "Usuario", nullable = false)
    String Usuario;

    @Column(name = "Password", nullable = false)
    String Password;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FicheroAdjunto> ficheros_conferenciasantamaria;
}
