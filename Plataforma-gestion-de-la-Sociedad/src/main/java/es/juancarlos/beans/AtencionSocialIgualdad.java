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
@Table(name = "AtencionSocialIgualdad")
public class AtencionSocialIgualdad implements Serializable{

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "Fecha", nullable = false)
    String Fecha;

    @Column(name = "Trabajador", nullable = false)
    String Trabajador; //El que atiende

    @Column(name = "Usuario", nullable = false)
    String Usuario;

    @Column(name = "ProcedenciaDerivacion", nullable = true)
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

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FicheroAdjunto> ficheros_acogida;
}
