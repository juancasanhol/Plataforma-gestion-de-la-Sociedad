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
import javax.persistence.OneToOne;
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

    @OneToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "FK_USUARIO_TRABAJADOR_ATENCION_SOCIAL") 
    Perfil Trabajador; //El que atiende

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "FK_USUARIO_ATENCION_SOCIAL")
    Usuario Usuario;

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

    public AtencionSocialIgualdad(String Fecha, Perfil Trabajador, Usuario Usuario, String ProcedenciaDerivacion, String MotivoConsulta, String Intervencion, String EstadoResolucion, List<Observaciones> observaciones_atencionsocial_igualdad, List<FicheroAdjunto> ficheros_atencionsocial_igualdad) {
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
    
    public AtencionSocialIgualdad(){
        
    }

    public int getNumIntId() {
        return NumIntId;
    }

    public String getFecha() {
        return Fecha;
    }

    public Perfil getTrabajador() {
        return Trabajador;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public String getProcedenciaDerivacion() {
        return ProcedenciaDerivacion;
    }

    public String getMotivoConsulta() {
        return MotivoConsulta;
    }

    public String getIntervencion() {
        return Intervencion;
    }

    public String getEstadoResolucion() {
        return EstadoResolucion;
    }

    public List<Observaciones> getObservaciones_atencionsocial_igualdad() {
        return observaciones_atencionsocial_igualdad;
    }

    public List<FicheroAdjunto> getFicheros_atencionsocial_igualdad() {
        return ficheros_atencionsocial_igualdad;
    }

    public void setNumIntId(int NumIntId) {
        this.NumIntId = NumIntId;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setTrabajador(Perfil Trabajador) {
        this.Trabajador = Trabajador;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public void setProcedenciaDerivacion(String ProcedenciaDerivacion) {
        this.ProcedenciaDerivacion = ProcedenciaDerivacion;
    }

    public void setMotivoConsulta(String MotivoConsulta) {
        this.MotivoConsulta = MotivoConsulta;
    }

    public void setIntervencion(String Intervencion) {
        this.Intervencion = Intervencion;
    }

    public void setEstadoResolucion(String EstadoResolucion) {
        this.EstadoResolucion = EstadoResolucion;
    }

    public void setObservaciones_atencionsocial_igualdad(List<Observaciones> observaciones_atencionsocial_igualdad) {
        this.observaciones_atencionsocial_igualdad = observaciones_atencionsocial_igualdad;
    }

    public void setFicheros_atencionsocial_igualdad(List<FicheroAdjunto> ficheros_atencionsocial_igualdad) {
        this.ficheros_atencionsocial_igualdad = ficheros_atencionsocial_igualdad;
    }
    
    
}
