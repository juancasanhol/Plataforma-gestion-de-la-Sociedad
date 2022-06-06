/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.beans;

import java.sql.Date;
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
 * @author Antonio
 */
@Entity
@Table(name = "Acogida")
public class Acogida {

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "Fecha", nullable = false)
    Date Fecha;

    @Column(name = "Trabajador", nullable = false)
    String Trabajador; //El que atiende

    @Column(name = "Usuario", nullable = false)
    String Usuario;

    @Column(name = "ProcedenciaDerivacion", nullable = false)
    String ProcedenciaDerivacion;//AYUNTAMIENTO, CARITAS, COLEGIO...

    //ESTOS 4 SIGUIENTES VAN A SER 4 DESPLEGABLES PARA ELEGIR ENTRE ELLOS UNO O VARIOS ELEMENTOS
    @Column(name = "AyudaSolicitada_General", nullable = false)
    String AyudaSolicitada_General;

    @Column(name = "AyudaSolicitada_Recibos", nullable = false)
    String AyudaSolicitada_Recibos;

    @Column(name = "AyudaSolicitada_Sanitaria", nullable = false)
    String AyudaSolicitada_Sanitaria;

    @Column(name = "AyudaSolicitada_Otras", nullable = false)
    String AyudaSolicitada_Otras;

    @Column(name = "EstadoResolucion", nullable = false)
    String EstadoResolucion;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_acogida;//Son las observaciones referentes a la acogida

    //LISTA DE ARCHIVOS
}
