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
@Table(name = "UnidadConvivencia")
public class UnidadConvivencia implements Serializable{

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "Denominacion", nullable = false)
    String Denominacion;

    @Column(name = "Direccion", nullable = false)
    String Direccion;

    @Column(name = "Localidad", nullable = false)
    String Localidad = "Merida";

    @Column(name = "FamiliaMonoparental", nullable = false) //CHECK
    Boolean FamiliaMonoparental;

    @Column(name = "SinHogar", nullable = false) //CHECK
    Boolean SinHogar;

    @Column(name = "CosteVivienda", nullable = false)
    float CosteVivienda;//MENSUAL

    @Column(name = "MotivoCoste", nullable = false)
    String MotivoCoste;//ALQUILER, HIPOTECA, VIVIENDA SOCIAL

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_convivencia;//Son las observaciones referentes a la unidad de convivencia

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FicheroAdjunto> ficheros_unidadconvivencia;

    @Column(name = "IngresosConvivientes", nullable = false)
    float IngresosConvivientes;//Suma automatica

    @Column(name = "PersonaTitular", nullable = false)
    String PersonaTitular;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Conviviente> lista_convivientes;
}
