/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Desplegables {
    
    @Id
    @Column(name = "Nombre", nullable = false)
    String Nombre;
    
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<String> desplegables;

    public Desplegables(String Nombre, List<String> desplegables) {
        this.Nombre = Nombre;
        this.desplegables = desplegables;
    }
    
}
