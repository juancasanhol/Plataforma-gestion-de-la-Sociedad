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

    @Column(name = "Fecha", nullable = true)
    String Fecha;

    @Column(name = "Trabajador", nullable = true)
    String Trabajador; //El que atiende

    @Column(name = "Usuario", nullable = true)
    String Usuario;

    @Column(name = "ProcedenciaDerivacion", nullable = true)
    String ProcedenciaDerivacion;//AYUNTAMIENTO, CARITAS, COLEGIO...

    @Column(name = "MotivoConsulta", nullable = true)
    String MotivoConsulta;

    @Column(name = "Intervencion", nullable = true)
    String Intervencion;

    @Column(name = "EstadoResolucion", nullable = true)
    String EstadoResolucion;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_atencionsocial_igualdad;//Son las observaciones referentes a la atencion social e igualdad

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FicheroAdjunto> ficheros_atencionsocial_igualdad;

    public AtencionSocialIgualdad(String Fecha, String Trabajador, String Usuario, String ProcedenciaDerivacion, String MotivoConsulta, String Intervencion, String EstadoResolucion, List<Observaciones> observaciones_atencionsocial_igualdad, List<FicheroAdjunto> ficheros_atencionsocial_igualdad) {
        this.Fecha = Fecha;
        this.Trabajador = Trabajador;
        this.Usuario = Usuario;
        this.ProcedenciaDerivacion = ProcedenciaDerivacion;
        this.MotivoConsulta = MotivoConsulta;
        this.Intervencion = Intervencion;
        this.EstadoResolucion = EstadoResolucion;
        this.observaciones_atencionsocial_igualdad = observaciones_atencionsocial_igualdad;
        this.ficheros_atencionsocial_igualdad = ficheros_atencionsocial_igualdad;
    }
    
    
    
}
