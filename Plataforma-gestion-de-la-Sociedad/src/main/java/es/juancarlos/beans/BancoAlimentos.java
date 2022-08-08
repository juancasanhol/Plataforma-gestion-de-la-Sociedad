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
@Table(name = "BancoAlimentos")
public class BancoAlimentos implements Serializable{

    @Id
    @Column(name = "IdOperacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdOperacion;
    
    @Column(name = "TitularUnidad", nullable = true)
    String TitularUnidad;

    @Column(name = "Mes_anio", nullable = true)
    String Mes_anio;

    @Column(name = "Asiste", nullable = true)
    Boolean Asiste;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_id;//Son las observaciones referentes al banco de alimentos

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Alimentos> lista_alimentos;

    public BancoAlimentos(String TitularUnidad, String Mes_anio, Boolean Asiste, List<Observaciones> observaciones_id, List<Alimentos> lista_alimentos) {
        this.TitularUnidad = TitularUnidad;
        this.Mes_anio = Mes_anio;
        this.Asiste = Asiste;
        this.observaciones_id = observaciones_id;
        this.lista_alimentos = lista_alimentos;
    }

    public int getIdOperacion() {
        return IdOperacion;
    }

    public String getTitularUnidad() {
        return TitularUnidad;
    }

    public String getMes_anio() {
        return Mes_anio;
    }

    public Boolean getAsiste() {
        return Asiste;
    }

    public List<Observaciones> getObservaciones_id() {
        return observaciones_id;
    }

    public List<Alimentos> getLista_alimentos() {
        return lista_alimentos;
    }

    public void setIdOperacion(int IdOperacion) {
        this.IdOperacion = IdOperacion;
    }

    public void setTitularUnidad(String TitularUnidad) {
        this.TitularUnidad = TitularUnidad;
    }

    public void setMes_anio(String Mes_anio) {
        this.Mes_anio = Mes_anio;
    }

    public void setAsiste(Boolean Asiste) {
        this.Asiste = Asiste;
    }

    public void setObservaciones_id(List<Observaciones> observaciones_id) {
        this.observaciones_id = observaciones_id;
    }

    public void setLista_alimentos(List<Alimentos> lista_alimentos) {
        this.lista_alimentos = lista_alimentos;
    }
    
    public BancoAlimentos(){
        
    }
}
