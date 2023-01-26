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
@Table(name = "AulaMagica")
public class AulaMagica implements Serializable{

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "Denominacion", nullable = true)
    String Denominacion;

    @Column(name = "Profesor", nullable = true)
    String Profesor;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Alumno> lista_alumnos;

    public AulaMagica(){
    }
    
    public AulaMagica(String Denominacion, String Profesor, List<Alumno> lista_alumnos) {
        this.Denominacion = Denominacion;
        this.Profesor = Profesor;
        this.lista_alumnos = lista_alumnos;
    }

    public int getNumIntId() {
        return NumIntId;
    }

    public String getDenominacion() {
        return Denominacion;
    }

    public String getProfesor() {
        return Profesor;
    }

    public List<Alumno> getLista_alumnos() {
        return lista_alumnos;
    }

    public void setNumIntId(int NumIntId) {
        this.NumIntId = NumIntId;
    }

    public void setDenominacion(String Denominacion) {
        this.Denominacion = Denominacion;
    }

    public void setProfesor(String Profesor) {
        this.Profesor = Profesor;
    }

    public void setLista_alumnos(List<Alumno> lista_alumnos) {
        this.lista_alumnos = lista_alumnos;
    }
    
    
}
