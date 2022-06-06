/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Antonio
 */
public class UnidadConvivencia {

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

    //LISTA DE FICHEROS ADJUNTOS
    @Column(name = "IngresosConvivientes", nullable = false)
    float IngresosConvivientes;//Suma automatica

    @Column(name = "PersonaTitular", nullable = false)
    String PersonaTitular;

    //LISTA DE CONVIVIENTES
}
