/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "Desplegables")
public class Desplegables implements Serializable{
    
    @Id
    @Column(name = "Nombre", nullable = false)
    String Nombre;
    
    
    @OneToMany(cascade = CascadeType.ALL)  
    @JoinColumn(name = "id_valor")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> valores;

    public Desplegables(){
        this.Nombre="";
        this.valores = null;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public List<ValorDesplegable> getValores() {
        return valores;
    }

    public void setValores(List<ValorDesplegable> valores) {
        this.valores = valores;
    }

    public Desplegables(String Nombre, List<ValorDesplegable> valores) {
        this.Nombre = Nombre;
        this.valores = valores;
    }
    
}
