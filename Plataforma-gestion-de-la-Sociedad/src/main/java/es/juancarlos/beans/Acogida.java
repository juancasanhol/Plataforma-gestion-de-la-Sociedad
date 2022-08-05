/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.io.Serializable;
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
@Table(name = "Acogida")
public class Acogida implements Serializable{

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

    //ESTOS 4 SIGUIENTES VAN A SER 4 DESPLEGABLES PARA ELEGIR ENTRE ELLOS UNO O VARIOS ELEMENTOS
    @Column(name = "AyudaSolicitada_General", nullable = true)
    String AyudaSolicitada_General;

    @Column(name = "AyudaSolicitada_Recibos", nullable = true)
    String AyudaSolicitada_Recibos;

    @Column(name = "AyudaSolicitada_Sanitaria", nullable = true)
    String AyudaSolicitada_Sanitaria;

    @Column(name = "AyudaSolicitada_Otras", nullable = true)
    String AyudaSolicitada_Otras;

    @Column(name = "EstadoResolucion", nullable = true)
    String EstadoResolucion;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_acogida;//Son las observaciones referentes a la acogida

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FicheroAdjunto> ficheros_acogida;

    public Acogida(String Fecha, String Trabajador, String Usuario, String ProcedenciaDerivacion, String AyudaSolicitada_General, String AyudaSolicitada_Recibos, String AyudaSolicitada_Sanitaria, String AyudaSolicitada_Otras, String EstadoResolucion, List<Observaciones> observaciones_acogida, List<FicheroAdjunto> ficheros_acogida) {
        this.Fecha = Fecha;
        this.Trabajador = Trabajador;
        this.Usuario = Usuario;
        this.ProcedenciaDerivacion = ProcedenciaDerivacion;
        this.AyudaSolicitada_General = AyudaSolicitada_General;
        this.AyudaSolicitada_Recibos = AyudaSolicitada_Recibos;
        this.AyudaSolicitada_Sanitaria = AyudaSolicitada_Sanitaria;
        this.AyudaSolicitada_Otras = AyudaSolicitada_Otras;
        this.EstadoResolucion = EstadoResolucion;
        this.observaciones_acogida = observaciones_acogida;
        this.ficheros_acogida = ficheros_acogida;
    }
    
    public Acogida(){
        
    }

    public int getNumIntId() {
        return NumIntId;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getTrabajador() {
        return Trabajador;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getProcedenciaDerivacion() {
        return ProcedenciaDerivacion;
    }

    public String getAyudaSolicitada_General() {
        return AyudaSolicitada_General;
    }

    public String getAyudaSolicitada_Recibos() {
        return AyudaSolicitada_Recibos;
    }

    public String getAyudaSolicitada_Sanitaria() {
        return AyudaSolicitada_Sanitaria;
    }

    public String getAyudaSolicitada_Otras() {
        return AyudaSolicitada_Otras;
    }

    public String getEstadoResolucion() {
        return EstadoResolucion;
    }

    public List<Observaciones> getObservaciones_acogida() {
        return observaciones_acogida;
    }

    public List<FicheroAdjunto> getFicheros_acogida() {
        return ficheros_acogida;
    }

    public void setNumIntId(int NumIntId) {
        this.NumIntId = NumIntId;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setTrabajador(String Trabajador) {
        this.Trabajador = Trabajador;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public void setProcedenciaDerivacion(String ProcedenciaDerivacion) {
        this.ProcedenciaDerivacion = ProcedenciaDerivacion;
    }

    public void setAyudaSolicitada_General(String AyudaSolicitada_General) {
        this.AyudaSolicitada_General = AyudaSolicitada_General;
    }

    public void setAyudaSolicitada_Recibos(String AyudaSolicitada_Recibos) {
        this.AyudaSolicitada_Recibos = AyudaSolicitada_Recibos;
    }

    public void setAyudaSolicitada_Sanitaria(String AyudaSolicitada_Sanitaria) {
        this.AyudaSolicitada_Sanitaria = AyudaSolicitada_Sanitaria;
    }

    public void setAyudaSolicitada_Otras(String AyudaSolicitada_Otras) {
        this.AyudaSolicitada_Otras = AyudaSolicitada_Otras;
    }

    public void setEstadoResolucion(String EstadoResolucion) {
        this.EstadoResolucion = EstadoResolucion;
    }

    public void setObservaciones_acogida(List<Observaciones> observaciones_acogida) {
        this.observaciones_acogida = observaciones_acogida;
    }

    public void setFicheros_acogida(List<FicheroAdjunto> ficheros_acogida) {
        this.ficheros_acogida = ficheros_acogida;
    }

    
    
}
