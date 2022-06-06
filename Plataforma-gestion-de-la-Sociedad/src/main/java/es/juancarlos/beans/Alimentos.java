/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import javax.persistence.Column;

/**
 *
 * @author Antonio
 */
public class Alimentos {

    @Column(name = "Alimento", nullable = false)
    String Alimento;

    @Column(name = "Unidades", nullable = false)
    int Unidades;
}
