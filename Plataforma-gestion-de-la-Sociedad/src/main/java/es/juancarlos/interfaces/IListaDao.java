/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.interfaces;

import es.juancarlos.beans.Usuario;
import java.util.List;

/**
 *
 * @author Pablo
 */
public interface IListaDao {
    
    /**
     * @return Boleano que indicara que la Lista está ordenada correctamente
     * parametro  <strong>true</strong>=Ordenada <strong>false</strong>= NO Ordenada
     */
    public List OrderList();
    
    public List<Usuario> ListadoXBanco_Fega(Boolean banco, boolean fega);
}
