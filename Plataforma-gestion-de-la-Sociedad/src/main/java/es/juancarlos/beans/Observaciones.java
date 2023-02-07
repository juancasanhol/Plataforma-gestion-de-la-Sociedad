/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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

    @Column(name = "texto", nullable = true)
    public String texto;

    @Column(name = "fecha", nullable = true)
    public String fecha;

    @OneToOne(cascade=CascadeType.DETACH)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "FK_USUARIO_OBSERVACIONES")
    public Perfil autor;

    public Observaciones() {
        this.fecha = "";
        texto = "";
        autor = null;
    }

    public Observaciones(String texto, Perfil autor) {
        this.texto = texto;
        this.autor = autor;
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        this.fecha = dtf.format(dateObj);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setAutor(Perfil autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public String getFecha() {
        return fecha;
    }

    public Perfil getAutor() {
        return autor;
    }
            
            
            
}
