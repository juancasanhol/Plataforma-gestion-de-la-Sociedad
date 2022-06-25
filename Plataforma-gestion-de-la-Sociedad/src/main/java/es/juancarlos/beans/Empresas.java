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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "Empresas")
public class Empresas implements Serializable{

    @Id
    @Column(name = "CodIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String CodIntId;

    @Column(name = "Nombre", nullable = true)
    String Nombre;

    @Column(name = "FechaAlta", nullable = true)
    String FechaAlta;

    @Column(name = "FechaBaja", nullable = true)
    String FechaBaja;

    @Column(name = "PersonaContacto", nullable = true)
    String PersonaContacto;

    @Column(name = "Direccion", nullable = true)
    String Direccion;

    @Column(name = "CodigoPostal", nullable = true)
    String CodigoPostal;

    @Column(name = "Poblacion", nullable = true)
    String Poblacion;

    @Column(name = "Provincia", nullable = true)
    String Provincia;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_valor")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> lista_actividades;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_valor")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> lista_colaboraciones;
}
