/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Antonio
 */
public class Observaciones {

    public String texto;
    public Date fecha;
    public String autor;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "Numero_interno_identificacion")
    Usuario usuario;
    
    public Observaciones() {
        fecha = new Date(new java.util.Date().getTime());
        texto = "";
        autor = "";
    }

    public Observaciones(String texto, String autor) {
        this.texto = texto;
        this.autor = autor;
    }
}
