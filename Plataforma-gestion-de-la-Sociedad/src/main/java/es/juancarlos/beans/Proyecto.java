/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class Proyecto {
    
    private ArrayList <Usuario> listaProyecto;
    
    private String nombre;
    private String actualizacion;
    
    public Proyecto(String nombre, String actualizacion, ArrayList <Usuario> listaProyecto){
        this.nombre=nombre;
        this.actualizacion=actualizacion;
        this.listaProyecto=listaProyecto;
    }

    public ArrayList<Usuario> getListaProyecto() {
        return listaProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getActualizacion() {
        return actualizacion;
    }
    
    
}
