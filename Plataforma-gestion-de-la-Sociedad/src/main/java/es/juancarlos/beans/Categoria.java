/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable{

    @Id
    @Column(name = "IdCategoria", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String IdCategoria;

    @Column(name = "Nombre", nullable = false)
    String Nombre;

    @Column(name = "FechaAlta", nullable = false)
    String FechaAlta;

    @Column(name = "FechaBaja", nullable = false)
    String FechaBaja;

}
