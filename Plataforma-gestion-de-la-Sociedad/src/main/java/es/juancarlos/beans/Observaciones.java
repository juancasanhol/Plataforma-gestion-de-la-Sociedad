/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
@Table(name = "Observaciones")
public class Observaciones implements Serializable {

    @Id
    @Column(name = "obsId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "texto", nullable = false)
    public String texto;

    @Column(name = "fecha", updatable = false, nullable = false)
    public String fecha;

    @Column(name = "autor", nullable = false)
    public String autor;

    public Observaciones() {
        this.fecha = "";
        texto = "";
        autor = "";
    }

    public Observaciones(String texto, String autor) {
        this.texto = texto;
        this.autor = autor;
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        this.fecha = dtf.format(dateObj);
    }
}
