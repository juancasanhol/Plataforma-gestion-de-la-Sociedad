package es.juancarlos.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;
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
 * @author junco
 */
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "Nombre", nullable = false)
    String Nombre;

    @Column(name = "Apellidos", nullable = false)
    String Apellidos;

    @Column(name = "FechaAlta", nullable = false)
    Date FechaAlta;

    @Column(name = "FechaBaja", nullable = false)
    Date FechaBaja;
    
    @Column(name = "TipoDoc", nullable = false, length = 25)//DESPLEGABLE
    String TipoDoc;
    
    @Column(name = "NumDoc", nullable = false, length = 25)
    String NumDoc;
    
    @Column(name = "Telefono", nullable = false, length = 20)
    String Telefono;
    
    @Column(name = "Correo", nullable = false, length = 30)
    String Correo;
    
    //+Persona de referencia de la conferencia de santa maria (dentro de la base de datos)
    
    @Column(name = "Sexo", nullable = false, length = 25)//DESPLEGABLE
    String Sexo;
    
    @Column(name = "FechaNac", nullable = false, length = 10)
    Date FechaNac;
    
    @Column(name = "PaisOrigen", nullable = false, length = 25)//DESPLEGABLE
    String PaisOrigen;
    
    @Column(name = "Nacionalidad", nullable = false, length = 25)//DESPLEGABLE
    String Nacionalidad;
    
    @Column(name = "PerteneceMinoria", nullable = false, length = 25)//CHECK
    Boolean PerteneceMinoria;
    
    @Column(name = "Minoria", nullable = false, length = 25)//DESPLEGABLE
    String Minoria;
    
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones>  observaciones_id;//Son las observaciones referentes a la identificacion de una persona
    
    //Ficheros adjuntos, LISTA
    
    ///////////////////DATOS SANITARIOS/////////////////
    
    @Column(name = "SolicitaAyudaFarmaceutica", nullable = false, length = 25)//CHECK
    Boolean SolicitaAyudaFarmaceutica;
    
    @Column(name = "TratSanitario", nullable = false, length = 100)
    String TratSanitario;
    
    @Column(name = "Drogodependencia", nullable = false, length = 25)//CHECK
    Boolean Drogodependencia;
    
    @Column(name = "TipoDiscapacidad", nullable = false, length = 25)//DESPLEGABLE
    String TipoDiscapacidad;

    @Column(name = "GradoDiscapacidad", nullable = false, length = 25)//DESPLEGABLE
    String GradoDiscapacidad;
    
    //Observaciones, LISTA
    
    ///////////////////DATOS LABORALES/////////////////
    
    @Column(name = "PermisoResidencia", nullable = false, length = 25)//CHECK
    Boolean PermisoResidencia;
    
    @Column(name = "PermisoTrabajo", nullable = false, length = 25)//CHECK
    Boolean PermisoTrabajo;
    
    @Column(name = "CarnetConducir", nullable = false, length = 25)//CHECK
    Boolean CarnetConducir;
    
    @Column(name = "TipoCarnetConducir", nullable = false, length = 25)//DESPLEGABLE
    String TipoCarnetConducir;
    
    //Otros carnets, LISTA desplegable
    
    //Profesion+observaciones, LISTA
    
    @Column(name = "SituacionLaboral", nullable = false, length = 25)//DESPLEGABLE
    String SituacionLaboral;
    
    @Column(name = "UltTrabajo", nullable = false, length = 100)
    String UltTrabajo;
    
    @Column(name = "PrefLaboral", nullable = false, length = 100)
    String PrefLaboral;
    
    //Bolsa de trabajo, DESPLEGABLE
    
    //Observaciones, LISTA
    
    ///////////////////DATOS DE FORMACION/////////////////
    
    @Column(name = "NivelEstudios", nullable = false, length = 25)//DESPLEGABLE
    String NivelEstudios;
    
    @Column(name = "FormacionComp", nullable = false, length = 150)
    String FormacionComp;
    
    @Column(name = "EstaEstudiando", nullable = false, length = 25)//CHECK
    Boolean EstaEstudiando;
    
    @Column(name = "FracasoEscolar", nullable = false, length = 25)//CHECK
    Boolean FracasoEscolar;

    @Column(name = "CentroEst", nullable = false, length = 100)
    String CentroEst;
    
    //Observaciones, LISTA
    
    ///////////////////INGRESOS/////////////////
    
    @Column(name = "Importe", nullable = false)
    int Importe;
    
    //Origen de ingresos, DESPLEGABLE
    
    //Observaciones, LISTA
    

    public Usuario() {
    }

    public Usuario(int NumIntId, String Nombre, String Apellidos, Date FechaAlta, Date FechaBaja, List<Observaciones> observaciones_id) {
        this.NumIntId = NumIntId;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.FechaAlta = FechaAlta;
        this.FechaBaja = FechaBaja;
        this.observaciones_id=observaciones_id;
    }


    

}
