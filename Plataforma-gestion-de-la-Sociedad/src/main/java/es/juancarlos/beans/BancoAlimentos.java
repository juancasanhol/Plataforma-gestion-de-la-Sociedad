/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

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
public class BancoAlimentos {

    @Id
    @Column(name = "IdUnidadConvivencia", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdUnidadConvivencia;

    @Column(name = "Mes_anio", nullable = false)
    String Mes_anio;

    @Column(name = "Asiste", nullable = false)
    Boolean Asiste;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_id;//Son las observaciones referentes al banco de alimentos

    //LISTA DE ALIMENTOS
}