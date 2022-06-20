/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.io.Serializable;
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
@Table(name = "Aportacion")
public class Aportacion implements Serializable{

    @Id
    @Column(name = "IdAportacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdAportacion;

    @Column(name = "Fecha", nullable = false)
    Date Fecha;

    @Column(name = "Importe", nullable = false)
    Float Importe;
}
