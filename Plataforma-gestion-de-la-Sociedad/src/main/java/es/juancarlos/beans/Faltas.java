/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "Faltas")
public class Faltas implements Serializable{

    @Id
    @Column(name = "Fecha", nullable = false)
    String Fecha;

    @Column(name = "Motivo", nullable = true)
    String Motivo;

    @Column(name = "Justificada", nullable = true)
    Boolean Justificada = false;

}
