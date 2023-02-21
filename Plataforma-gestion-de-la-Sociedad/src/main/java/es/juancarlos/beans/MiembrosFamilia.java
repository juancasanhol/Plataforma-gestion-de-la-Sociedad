/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juancarlos.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author juanca
 */
@Entity
@Table(name = "MiembrosFamilia")
public class MiembrosFamilia {
    
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;   
    
    @Column(name = "Nombre", nullable = true)
    String nombre;
    
    @Column(name = "Apellido", nullable = true)
    String Apellido;
    
    @Column(name = "FechaNacimiento", nullable = true)
    String FechaNacimiento;
    
    @Column(name = "Profesion", nullable = true)
    String Profesion;
    
}
