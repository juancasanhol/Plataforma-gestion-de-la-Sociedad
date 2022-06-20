/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.io.File;
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
@Table(name = "FicheroAdjunto")
public class FicheroAdjunto implements Serializable{

    @Id
    @Column(name = "IdFichero", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdFichero;

    @Column(name = "Fichero", nullable = false)
    File Fichero;

    @Column(name = "Descripcion", nullable = false)
    String Descripcion;

    @Column(name = "Fecha", nullable = false)
    Date Fecha;

    //Si el fichero es necesario para el banco de alimentos
    @Column(name = "BancoAlimentos", nullable = false)
    Boolean BancoAlimentos;
}
