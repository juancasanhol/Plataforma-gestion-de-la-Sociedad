/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "Alimentos")
public class Alimentos implements Serializable {

    @Id
    @Column(name = "Alimento", nullable = false)
    String Alimento;

    @Column(name = "Unidades", nullable = true)
    int Unidades;

    public Alimentos(String Alimento, int Unidades) {
        this.Alimento = Alimento;
        this.Unidades = Unidades;
    }

    public Alimentos() {
    }

    public String getAlimento() {
        return Alimento;
    }

    public void setAlimento(String Alimento) {
        this.Alimento = Alimento;
    }

    public int getUnidades() {
        return Unidades;
    }

    public void setUnidades(int Unidades) {
        this.Unidades = Unidades;
    }
    
    
}
