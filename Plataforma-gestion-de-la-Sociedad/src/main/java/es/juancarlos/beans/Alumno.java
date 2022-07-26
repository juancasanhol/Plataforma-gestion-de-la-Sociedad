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
@Table(name = "Alumno")
public class Alumno implements Serializable{

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "Persona", nullable = true)//DESPLEGABLE
    String Persona;
    
    @Column(name = "FechaAlta", nullable = true)
    String FechaAlta;

    @Column(name = "FechaBaja", nullable = true)
    String FechaBaja;

    @Column(name = "CursoEscolar", nullable = true)
    String CursoEscolar;

    @Column(name = "Promociona", nullable = true)
    Boolean Promociona;

    @Column(name = "Finaliza", nullable = true)
    Boolean Finaliza;

    @Column(name = "Aprovechamiento", nullable = true)
    Boolean Aprovechamiento;

    @Column(name = "EmpresaPracticas", nullable = true)
    String EmpresaPracticas;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Faltas> faltas_alumno;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_alumno;//Son las observaciones referentes a los alumnos

    public Alumno(String Persona, String FechaAlta, String FechaBaja, String CursoEscolar, Boolean Promociona, Boolean Finaliza, Boolean Aprovechamiento, String EmpresaPracticas, List<Faltas> faltas_alumno, List<Observaciones> observaciones_alumno) {
        this.Persona = Persona;
        this.FechaAlta = FechaAlta;
        this.FechaBaja = FechaBaja;
        this.CursoEscolar = CursoEscolar;
        this.Promociona = Promociona;
        this.Finaliza = Finaliza;
        this.Aprovechamiento = Aprovechamiento;
        this.EmpresaPracticas = EmpresaPracticas;
        this.faltas_alumno = faltas_alumno;
        this.observaciones_alumno = observaciones_alumno;
    }
    
}
