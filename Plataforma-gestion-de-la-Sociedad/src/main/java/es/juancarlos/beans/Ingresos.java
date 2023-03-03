/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juancarlos.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author junco
 */
@Entity
@Table(name = "Ingreso")
public class Ingresos {
    
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;   
    
    @Column(name = "Concepto", nullable = true)
    String Concepto;
    
    @Column(name = "Importe", nullable = true)
    double Importe;

    public Ingresos() {
    }

    
    public Ingresos(String Concepto, double Importe) {
        this.Concepto = Concepto;
        this.Importe = Importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }
    
    
    
}
