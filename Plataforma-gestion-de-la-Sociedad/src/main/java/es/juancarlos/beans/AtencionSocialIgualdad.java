/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.sql.Date;
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
public class AtencionSocialIgualdad {

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "Fecha", nullable = false)
    Date Fecha;

    @Column(name = "Trabajador", nullable = false)
    String Trabajador; //El que atiende

    @Column(name = "Usuario", nullable = false)
    String Usuario;

    @Column(name = "ProcedenciaDerivacion", nullable = false)
    String ProcedenciaDerivacion;//AYUNTAMIENTO, CARITAS, COLEGIO...

    @Column(name = "MotivoConsulta", nullable = false)
    String MotivoConsulta;

    @Column(name = "Intervencion", nullable = false)
    String Intervencion;

    @Column(name = "EstadoResolucion", nullable = false)
    String EstadoResolucion;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_atencionsocial_igualdad;//Son las observaciones referentes a la atencion social e igualdad

    //LISTA DE ARCHIVOS
}
