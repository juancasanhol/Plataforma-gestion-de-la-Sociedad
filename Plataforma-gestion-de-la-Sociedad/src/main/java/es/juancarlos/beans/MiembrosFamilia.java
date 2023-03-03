/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juancarlos.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author juanca
 */
@Entity
@Table(name = "MiembrosFamilia")
public class MiembrosFamilia {
    
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;   
    
    @Column(name = "Nombre", nullable = true)
    String nombre;
    
    @Column(name = "Parentezco", nullable = true)
    String Parentezco;
    
    @Column(name = "FechaNacimiento", nullable = true)
    String FechaNacimiento;
    
    @Column(name = "Profesion", nullable = true)
    String Profesion;
    
    @Column(name = "AyudaHijo", nullable = true)//CHECK
    Boolean AyudaHijo;

    public MiembrosFamilia() {
    }

    public MiembrosFamilia( String nombre, String Parentezco, String FechaNacimiento, String Profesion, Boolean AyudaHijo) {
        this.nombre = nombre;
        this.Parentezco = Parentezco;
        this.FechaNacimiento = FechaNacimiento;
        this.Profesion = Profesion;
        this.AyudaHijo = AyudaHijo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentezco() {
        return Parentezco;
    }

    public void setParentezco(String Parentezco) {
        this.Parentezco = Parentezco;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    public Boolean getAyudaHijo() {
        return AyudaHijo;
    }

    public void setAyudaHijo(Boolean AyudaHijo) {
        this.AyudaHijo = AyudaHijo;
    }
    
    
    
    
}
