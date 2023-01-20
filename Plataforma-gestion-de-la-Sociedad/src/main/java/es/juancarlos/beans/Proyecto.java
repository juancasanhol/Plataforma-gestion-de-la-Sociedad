/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Pablo
 */
public class Proyecto {
    
    @Id
    @Column(name = "CodIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idProyecto;
    @Column(name = "listaProyecto", nullable = false)
    ArrayList <Usuario> listaProyecto;
    
    @Column(name = "Nombre", nullable = true)
    String Nombre;
    
    @Column(name = "Actualizacion", nullable = true)
    String Actualizacion;
    
    public Proyecto(String Nombre, String Actualizacion, ArrayList <Usuario> listaProyecto){
        this.Nombre=Nombre;
        this.Actualizacion=Actualizacion;
        this.listaProyecto=listaProyecto;
    }

    public ArrayList<Usuario> getListaProyecto() {
        return listaProyecto;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getActualizacion() {
        return Actualizacion;
    }    
}
