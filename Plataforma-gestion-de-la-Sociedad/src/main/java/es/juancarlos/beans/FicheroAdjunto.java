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
@Table(name = "FicheroAdjunto")
public class FicheroAdjunto implements Serializable{

    @Id
    @Column(name = "IdFichero", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdFichero;

    @Column(name = "Ruta", nullable = true)
    String Ruta;

    @Column(name = "Fecha", nullable = true)
    String Fecha;

    //Si el fichero es necesario para el banco de alimentos
    @Column(name = "BancoAlimentos", nullable = true)
    Boolean BancoAlimentos;

    public FicheroAdjunto(String Ruta, Boolean BancoAlimentos) {
        this.Ruta = Ruta;
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        this.Fecha = dtf.format(dateObj);
        this.BancoAlimentos = BancoAlimentos;
    }
    
    public FicheroAdjunto(){
        
    }

    public int getIdFichero() {
        return IdFichero;
    }

    public String getRuta() {
        return Ruta;
    }

    public String getFecha() {
        return Fecha;
    }

    public Boolean getBancoAlimentos() {
        return BancoAlimentos;
    }

    public void setIdFichero(int IdFichero) {
        this.IdFichero = IdFichero;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setBancoAlimentos(Boolean BancoAlimentos) {
        this.BancoAlimentos = BancoAlimentos;
    }
    
    
}
