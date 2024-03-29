/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import Enum.TipoPerfil;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "Perfil")
public class Perfil implements Serializable {

     @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;
     
    @Column(name = "Usuario", nullable = false)
    String Usuario;

    @Column(name = "Password", nullable = false)
    String Password;
    
    @Column(name = "Tipo", nullable = true)
    @Enumerated(value = EnumType.STRING)
    TipoPerfil Tipo;

    public Perfil() {
    }

    public Perfil(String Usuario, String Password, TipoPerfil tipo) {
        this.Usuario = Usuario;
        this.Password = Password;
        this.Tipo=tipo;
    }

    public int getNumIntId() {
        return NumIntId;
    }

    public void setNumIntId(int NumIntId) {
        this.NumIntId = NumIntId;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public TipoPerfil getTipo() {
        return Tipo;
    }

    public void setTipo(TipoPerfil Tipo) {
        this.Tipo = Tipo;
    }

    
}
