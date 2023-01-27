/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "Proyecto")
public class Proyecto {

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "Nombre", nullable = true)
    String nombre;
    
    @Column(name = "Accion", nullable = true)
    String accion;
    
    
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List <String> listfecha;
    
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Usuario> listaUsuarios;

    public Proyecto() {
    }

    //Chupi cambio List fechas + id (user que entro)
    public Proyecto(String nombre, String accion, List listaUsuarios, List listfecha) {
        this.nombre = nombre;
        this.accion = accion;
        this.listaUsuarios = listaUsuarios;
        this.listfecha=listfecha;
    }
    
    public List getListfecha() {
        return listfecha;
    }

    public int getNumIntId() {
        return NumIntId;
    }


    public String getNombre() {
        return nombre;
    }


    public String getAccion() {
        return accion;
    }


    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    
    

}
