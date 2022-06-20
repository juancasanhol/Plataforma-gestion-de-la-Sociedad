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
@Table(name = "ProfesionObservaciones")
//clase necesaria para la lista de profesiones y observaciones (diapositiva 7)
public class ProfesionObservaciones implements Serializable{
    @Id
    @Column(name = "ProfObsId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ProfObsId;
    
    @Column(name = "Profesion", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String Profesion;
    
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_profesionobservaciones;
}
