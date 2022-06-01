package es.juancarlos.beans;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

public class CursosFormacion {

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "NombreCurso", nullable = false)
    String NombreCurso;

    @Column(name = "TipoCurso", nullable = false)
    String TipoCurso;

    @Column(name = "FechaInicio", nullable = false)
    Date FechaInicio;

    @Column(name = "FechaFin", nullable = false)
    Date FechaFin;

    @Column(name = "OtraInfo", nullable = false, length = 25)//DESPLEGABLE
    String OtraInfo;

    //VAYA COLADA LO DE LA LISTA DE SOLICITANTES EN CURSOS DE FORMACION
    //Y LA LISTA DE SELECCIONADOS OTRA COLADA TREMENDA
    
    //LISTA DE ALUMNOS
   
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_cursos_formacion;//Son las observaciones referentes a los cursos de formacion

}