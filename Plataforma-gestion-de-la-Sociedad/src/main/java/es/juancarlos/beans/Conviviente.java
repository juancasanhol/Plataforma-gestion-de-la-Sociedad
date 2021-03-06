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
@Table(name = "Conviviente")
public class Conviviente implements Serializable{

    //Como no todos los convivientes tienen por que estar registrados
    //ponemos el nombre y apellidos como ID
    @Id
    @Column(name = "NombreApellidos", nullable = false)
    String NombreApellidos;

    @Column(name = "RelacionTitular", nullable = true)
    String RelacionTitular;

}
