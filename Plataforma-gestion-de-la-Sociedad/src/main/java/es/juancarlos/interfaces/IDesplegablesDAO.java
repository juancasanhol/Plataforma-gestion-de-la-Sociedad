/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juancarlos.interfaces;

import es.juancarlos.beans.ValorDesplegable;

/**
 *
 * @author junco
 */
public interface IDesplegablesDAO {
    
    public ValorDesplegable getByID(String id);
    
}
