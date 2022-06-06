/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.sql.Date;
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
@Table(name = "Empresas")
public class Empresas {
    
     @Id
    @Column(name = "CodIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String CodIntId;

    @Column(name = "Nombre", nullable = false)
    String Nombre;

    @Column(name = "FechaAlta", nullable = false)
    Date FechaAlta;

    @Column(name = "FechaBaja", nullable = false)
    Date FechaBaja;
    
    @Column(name = "PersonaContacto", nullable = false)
    String PersonaContacto;
    
    @Column(name = "Direccion", nullable = false)
    String Direccion;
    
    @Column(name = "CodigoPostal", nullable = false)
    String CodigoPostal;
    
    @Column(name = "Poblacion", nullable = false)
    String Poblacion;
    
    @Column(name = "Provincia", nullable = false)
    String Provincia;
    
    //LISTA DE ACTIVIDADES DE LA EMPRESA
    
    //LISTA DE TIPOS DE COLABORACION (AMBAS PODRIAN SER LISTAS DE STRINGS SIMPLEMENTE SE VAN AÑADIENDO A LA LISTA)
}
