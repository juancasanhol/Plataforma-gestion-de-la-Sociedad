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
    String NumExtId;

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

    public ConferenciaSantaMaria(String NumExtId, String FechaAlta, List<Categoria> lista_categorias, String Cargo, String Nombre, String Apellidos, String Nif, String Sexo, String FechaNac, String Direccion, String CodigoPostal, String Poblacion, String Provincia, String Telefono, String Mail, String CuentaBancaria, float Cuota, List<Aportacion> lista_aportaciones, String Actividad, String TiempoDedicacion, List<Observaciones> observaciones_conferencia, Boolean PermisoAcceso, List<Perfil> lista_perfilesacceso, Boolean AccesoFichaIndividual, String Usuario, String Password, List<FicheroAdjunto> ficheros_conferenciasantamaria) {
        this.NumExtId = NumExtId;
        this.FechaAlta = FechaAlta;
        this.lista_categorias = lista_categorias;
        this.Cargo = Cargo;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Nif = Nif;
        this.Sexo = Sexo;
        this.FechaNac = FechaNac;
        this.Direccion = Direccion;
        this.CodigoPostal = CodigoPostal;
        this.Poblacion = Poblacion;
        this.Provincia = Provincia;
        this.Telefono = Telefono;
        this.Mail = Mail;
        this.CuentaBancaria = CuentaBancaria;
        this.Cuota = Cuota;
        this.lista_aportaciones = lista_aportaciones;
        this.Actividad = Actividad;
        this.TiempoDedicacion = TiempoDedicacion;
        this.observaciones_conferencia = observaciones_conferencia;
        this.PermisoAcceso = PermisoAcceso;
        this.lista_perfilesacceso = lista_perfilesacceso;
        this.AccesoFichaIndividual = AccesoFichaIndividual;
        this.Usuario = Usuario;
        this.Password = Password;
        this.ficheros_conferenciasantamaria = ficheros_conferenciasantamaria;
    }

    public ConferenciaSantaMaria(){
        
    }

    public int getNumIntId() {
        return NumIntId;
    }

    public String getNumExtId() {
        return NumExtId;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public List<Categoria> getLista_categorias() {
        return lista_categorias;
    }

    public String getCargo() {
        return Cargo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getNif() {
        return Nif;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public String getProvincia() {
        return Provincia;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getMail() {
        return Mail;
    }

    public String getCuentaBancaria() {
        return CuentaBancaria;
    }

    public float getCuota() {
        return Cuota;
    }

    public List<Aportacion> getLista_aportaciones() {
        return lista_aportaciones;
    }

    public String getActividad() {
        return Actividad;
    }

    public String getTiempoDedicacion() {
        return TiempoDedicacion;
    }

    public List<Observaciones> getObservaciones_conferencia() {
        return observaciones_conferencia;
    }

    public Boolean getPermisoAcceso() {
        return PermisoAcceso;
    }

    public List<Perfil> getLista_perfilesacceso() {
        return lista_perfilesacceso;
    }

    public Boolean getAccesoFichaIndividual() {
        return AccesoFichaIndividual;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public List<FicheroAdjunto> getFicheros_conferenciasantamaria() {
        return ficheros_conferenciasantamaria;
    }

    public void setNumIntId(int NumIntId) {
        this.NumIntId = NumIntId;
    }

    public void setNumExtId(String NumExtId) {
        this.NumExtId = NumExtId;
    }

    public void setFechaAlta(String FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

    public void setLista_categorias(List<Categoria> lista_categorias) {
        this.lista_categorias = lista_categorias;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setNif(String Nif) {
        this.Nif = Nif;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setCodigoPostal(String CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public void setPoblacion(String Poblacion) {
        this.Poblacion = Poblacion;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public void setCuentaBancaria(String CuentaBancaria) {
        this.CuentaBancaria = CuentaBancaria;
    }

    public void setCuota(float Cuota) {
        this.Cuota = Cuota;
    }

    public void setLista_aportaciones(List<Aportacion> lista_aportaciones) {
        this.lista_aportaciones = lista_aportaciones;
    }

    public void setActividad(String Actividad) {
        this.Actividad = Actividad;
    }

    public void setTiempoDedicacion(String TiempoDedicacion) {
        this.TiempoDedicacion = TiempoDedicacion;
    }

    public void setObservaciones_conferencia(List<Observaciones> observaciones_conferencia) {
        this.observaciones_conferencia = observaciones_conferencia;
    }

    public void setPermisoAcceso(Boolean PermisoAcceso) {
        this.PermisoAcceso = PermisoAcceso;
    }

    public void setLista_perfilesacceso(List<Perfil> lista_perfilesacceso) {
        this.lista_perfilesacceso = lista_perfilesacceso;
    }

    public void setAccesoFichaIndividual(Boolean AccesoFichaIndividual) {
        this.AccesoFichaIndividual = AccesoFichaIndividual;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setFicheros_conferenciasantamaria(List<FicheroAdjunto> ficheros_conferenciasantamaria) {
        this.ficheros_conferenciasantamaria = ficheros_conferenciasantamaria;
    }
    
    
}
