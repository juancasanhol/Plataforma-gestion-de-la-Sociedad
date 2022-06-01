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
public class Alumno {
    
     @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "FechaAlta", nullable = false)
    Date FechaAlta;

    @Column(name = "FechaBaja", nullable = false)
    Date FechaBaja;
    
    @Column(name = "CursoEscolar", nullable = false)
    String CursoEscolar;
    
    @Column(name = "Promociona", nullable = false)
    Boolean Promociona;
    
    @Column(name = "Finaliza", nullable = false)
    Boolean Finaliza;
    
    @Column(name = "Aprovechamiento", nullable = false)
    Boolean Aprovechamiento;
    
    @Column(name = "EmpresaPracticas", nullable = false)
    String EmpresaPracticas;
    
    //LISTA DE FALTAS 
    
     @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_alumno;//Son las observaciones referentes a los alumnos

}
