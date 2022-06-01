/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.sql.Date;
import javax.persistence.Column;

/**
 *
 * @author Antonio
 */
public class Faltas {
    
    @Column(name = "FechaFin", nullable = false)
    Date FechaFin;

    @Column(name = "Motivo", nullable = false)
    String Motivo;

    @Column(name = "Justificada", nullable = false)
    Boolean Justificada = false;
    
}
