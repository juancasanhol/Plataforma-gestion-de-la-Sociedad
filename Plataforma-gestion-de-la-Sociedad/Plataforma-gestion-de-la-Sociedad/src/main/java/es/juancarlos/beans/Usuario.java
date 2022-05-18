package es.juancarlos.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author junco
 */
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "Nombre", nullable = false, length = 30)
    String Nombre;

    @Column(name = "Apellidos", nullable = false, length = 50)
    String Apellidos;

    @Column(name = "FechaAlta", nullable = false, length = 10)
    Date FechaAlta;

    @Column(name = "FechaBaja", nullable = false, length = 10)
    Date FechaBaja;
    
    /*
    //+TIPO DE DOCUMENTO IDENTIFICATIVO, QUE ES UN DESPLEGABLE
    
    @Column(name = "NumDoc", nullable = false, length = 25)
    String NumDoc;
    
    @Column(name = "Telefono", nullable = false, length = 20)
    String Telefono;
    
    @Column(name = "Correo", nullable = false, length = 30)
    String Correo;
    
    //+Persona de referencia de la conferencia de santa maria (dentro de la base de datos)
    
    //+Sexo, DESPLEGABLE
    
    @Column(name = "FechaNac", nullable = false, length = 10)
    String FechaNac;
    
    //Pais de origen, DESPLEGABLE
    
    //Nacionalidad, DESPLEGABLE
    
    //Pertenece minoria etnica, CHECK
    
    //Minoria Etnica, DESPLEGABLE
    */
    @Column(name = "Observaciones_id", nullable = false)//Son las observaciones referentes a la identificacion de una persona
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    Set<Observaciones> observaciones_id;
    /*
    //Ficheros adjuntos, LISTA
    
    ///////////////////DATOS SANITARIOS/////////////////
    
    //Solicita ayuda farmaceutica, CHECK
    
    @Column(name = "TratSanitario", nullable = false, length = 100)
    String TratSanitario;
    
    //Drogodependencia, CHECK
    
    //Tipo de discapacidad, DESPLEGABLE

    //Grado de discapacidad, DESPLEGABLE
    
    //Observaciones, LISTA
    
    ///////////////////DATOS LABORALES/////////////////
    
    //Permiso de residencia, CHECK
    
    //Permiso de trabajo, CHECK
    
    //Carnet de conducir, CHECK
    
    //Tipo de carnet de conducir, DESPLEGABLE
    
    //Otros carnets, LISTA desplegable
    
    //Profesion+observaciones, LISTA
    
    //Situacion laboral, DESPLEGABLE
    
    @Column(name = "UltTrabajo", nullable = false, length = 100)
    String UltTrabajo;
    
    @Column(name = "PrefLaboral", nullable = false, length = 100)
    String PrefLaboral;
    
    //Bolsa de trabajo, DESPLEGABLE
    
    //Observaciones, LISTA
    
    ///////////////////DATOS DE FORMACION/////////////////
    
    //Nivel de estudios, DESPLEGABLE
    
    @Column(name = "FormacionComp", nullable = false, length = 150)
    String FormacionComp;
    
    //Esta estudiando?, CHECK
    
    //Fracaso escolar?, CHECK

    @Column(name = "CentroEst", nullable = false, length = 100)
    String CentroEst;
    
    //Observaciones, LISTA
    
    ///////////////////INGRESOS/////////////////
    
    @Column(name = "Importe", nullable = false)
    int Importe;
    
    //Origen de ingresos, DESPLEGABLE
    
    //Observaciones, LISTA
    */

    public Usuario(int NumIntId, String Nombre, String Apellidos, Date FechaAlta, Date FechaBaja, Set<Observaciones> observaciones_id) {
        this.NumIntId = NumIntId;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.FechaAlta = FechaAlta;
        this.FechaBaja = FechaBaja;
        this.observaciones_id=observaciones_id;
    }


    

}
