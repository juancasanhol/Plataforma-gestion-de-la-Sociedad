package es.juancarlos.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "CursosFormacion")
public class CursosFormacion implements Serializable{

    @Id
    @Column(name = "NumIntId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NumIntId;

    @Column(name = "NombreCurso", nullable = false)
    String NombreCurso;

    @Column(name = "TipoCurso", nullable = true)
    String TipoCurso;

    @Column(name = "FechaInicio", nullable = false)
    String FechaInicio;

    @Column(name = "FechaFin", nullable = false)
    String FechaFin;

    @Column(name = "OtraInfo", nullable = true, length = 25)//DESPLEGABLE
    String OtraInfo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_valor")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> lista_solicitantes;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_valor")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> lista_aseleccionados;//SOLO PUEDEN SER SOLICITANTES
    
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Alumno> lista_alumnos;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_cursos_formacion;//Son las observaciones referentes a los cursos de formacion

}
