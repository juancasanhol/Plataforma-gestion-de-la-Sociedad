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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
    
    @OneToOne(cascade=CascadeType.DETACH)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "FK_USUARIO_TRABAJADOR_ACOGIDA")        
    Usuario Trabajador; //El que atiende

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "FK_USUARIO_FICHA_ACOGIDA")
    Usuario Usuario;

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "FK_VALOR_PD_ACOGIDA")
    ValorDesplegable ProcedenciaDerivacion;//AYUNTAMIENTO, CARITAS, COLEGIO...

    //ESTOS 4 SIGUIENTES VAN A SER 4 DESPLEGABLES PARA ELEGIR ENTRE ELLOS UNO O VARIOS ELEMENTOS
    @JoinTable(
        name = "AyudaSolicitada_General",
        joinColumns = @JoinColumn(name = "FK_ID_FICHA_ACOGIDA", nullable = false),
        inverseJoinColumns = @JoinColumn(name="FK_DESPLEGABLE", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> AyudaSolicitada_General;

    @JoinTable(
        name = "AyudaSolicitada_Recibos",
        joinColumns = @JoinColumn(name = "FK_ID_FICHA_ACOGIDA", nullable = false),
        inverseJoinColumns = @JoinColumn(name="FK_DESPLEGABLE", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> AyudaSolicitada_Recibos;

    @JoinTable(
        name = "AyudaSolicitada_Sanitaria",
        joinColumns = @JoinColumn(name = "FK_ID_FICHA_ACOGIDA", nullable = false),
        inverseJoinColumns = @JoinColumn(name="FK_DESPLEGABLE", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> AyudaSolicitada_Sanitaria;

    @JoinTable(
        name = "AyudaSolicitada_Otras",
        joinColumns = @JoinColumn(name = "FK_ID_FICHA_ACOGIDA", nullable = false),
        inverseJoinColumns = @JoinColumn(name="FK_DESPLEGABLE", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> AyudaSolicitada_Otras;
    
    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "FK_VALOR_ER_ACOGIDA")
    ValorDesplegable EstadoResolucion;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_acogida;//Son las observaciones referentes a la acogida

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FicheroAdjunto> ficheros_acogida;

    
    @Column(name = "TecnicoPrevencionSocial", nullable = true)
    String TecnicoPrevencionSocial;
    
    public Acogida(){
        
    }
    
    public Acogida(String Fecha, Usuario Trabajador, Usuario Usuario, ValorDesplegable ProcedenciaDerivacion, List<ValorDesplegable> AyudaSolicitada_General, List<ValorDesplegable> AyudaSolicitada_Recibos, List<ValorDesplegable> AyudaSolicitada_Sanitaria, List<ValorDesplegable> AyudaSolicitada_Otras, ValorDesplegable EstadoResolucion, List<Observaciones> observaciones_acogida, List<FicheroAdjunto> ficheros_acogida) {
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

    public int getNumIntId() {
        return NumIntId;
    }

    public void setNumIntId(int NumIntId) {
        this.NumIntId = NumIntId;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Usuario getTrabajador() {
        return Trabajador;
    }

    public void setTrabajador(Usuario Trabajador) {
        this.Trabajador = Trabajador;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public ValorDesplegable getProcedenciaDerivacion() {
        return ProcedenciaDerivacion;
    }

    public void setProcedenciaDerivacion(ValorDesplegable ProcedenciaDerivacion) {
        this.ProcedenciaDerivacion = ProcedenciaDerivacion;
    }

    public List<ValorDesplegable> getAyudaSolicitada_General() {
        return AyudaSolicitada_General;
    }

    public void setAyudaSolicitada_General(List<ValorDesplegable> AyudaSolicitada_General) {
        this.AyudaSolicitada_General = AyudaSolicitada_General;
    }

    public List<ValorDesplegable> getAyudaSolicitada_Recibos() {
        return AyudaSolicitada_Recibos;
    }

    public void setAyudaSolicitada_Recibos(List<ValorDesplegable> AyudaSolicitada_Recibos) {
        this.AyudaSolicitada_Recibos = AyudaSolicitada_Recibos;
    }

    public List<ValorDesplegable> getAyudaSolicitada_Sanitaria() {
        return AyudaSolicitada_Sanitaria;
    }

    public void setAyudaSolicitada_Sanitaria(List<ValorDesplegable> AyudaSolicitada_Sanitaria) {
        this.AyudaSolicitada_Sanitaria = AyudaSolicitada_Sanitaria;
    }

    public List<ValorDesplegable> getAyudaSolicitada_Otras() {
        return AyudaSolicitada_Otras;
    }

    public void setAyudaSolicitada_Otras(List<ValorDesplegable> AyudaSolicitada_Otras) {
        this.AyudaSolicitada_Otras = AyudaSolicitada_Otras;
    }

    public ValorDesplegable getEstadoResolucion() {
        return EstadoResolucion;
    }

    public void setEstadoResolucion(ValorDesplegable EstadoResolucion) {
        this.EstadoResolucion = EstadoResolucion;
    }

    public List<Observaciones> getObservaciones_acogida() {
        return observaciones_acogida;
    }

    public void setObservaciones_acogida(List<Observaciones> observaciones_acogida) {
        this.observaciones_acogida = observaciones_acogida;
    }

    public List<FicheroAdjunto> getFicheros_acogida() {
        return ficheros_acogida;
    }

    public void setFicheros_acogida(List<FicheroAdjunto> ficheros_acogida) {
        this.ficheros_acogida = ficheros_acogida;
    }

    public String getTecnicoPrevencionSocial() {
        return TecnicoPrevencionSocial;
    }

    public void setTecnicoPrevencionSocial(String TecnicoPrevencionSocial) {
        this.TecnicoPrevencionSocial = TecnicoPrevencionSocial;
    }
    
    
}