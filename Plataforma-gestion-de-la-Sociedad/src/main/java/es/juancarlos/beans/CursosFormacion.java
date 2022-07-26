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

    @Column(name = "NombreCurso", nullable = true)
    String NombreCurso;

    @Column(name = "TipoCurso", nullable = true)
    String TipoCurso;

    @Column(name = "FechaInicio", nullable = true)
    String FechaInicio;

    @Column(name = "FechaFin", nullable = true)
    String FechaFin;

    @Column(name = "OtraInfo", nullable = true)//DESPLEGABLE
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

    public CursosFormacion(String NombreCurso, String TipoCurso, String FechaInicio, String FechaFin, String OtraInfo, List<ValorDesplegable> lista_solicitantes, List<ValorDesplegable> lista_aseleccionados, List<Alumno> lista_alumnos, List<Observaciones> observaciones_cursos_formacion) {
        this.NombreCurso = NombreCurso;
        this.TipoCurso = TipoCurso;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.OtraInfo = OtraInfo;
        this.lista_solicitantes = lista_solicitantes;
        this.lista_aseleccionados = lista_aseleccionados;
        this.lista_alumnos = lista_alumnos;
        this.observaciones_cursos_formacion = observaciones_cursos_formacion;
    }

    public CursosFormacion(int id, String NombreCurso, String TipoCurso, String FechaInicio, String FechaFin, String OtraInfo) {
        this.NumIntId = id;
        this.NombreCurso = NombreCurso;
        this.TipoCurso = TipoCurso;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.OtraInfo = OtraInfo;
    }
    
    public int getNumIntId() {
        return NumIntId;
    }

    public String getNombreCurso() {
        return NombreCurso;
    }

    public String getTipoCurso() {
        return TipoCurso;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public String getOtraInfo() {
        return OtraInfo;
    }

    public List<ValorDesplegable> getLista_solicitantes() {
        return lista_solicitantes;
    }

    public List<ValorDesplegable> getLista_aseleccionados() {
        return lista_aseleccionados;
    }

    public List<Alumno> getLista_alumnos() {
        return lista_alumnos;
    }

    public List<Observaciones> getObservaciones_cursos_formacion() {
        return observaciones_cursos_formacion;
    }

    public void setNumIntId(int NumIntId) {
        this.NumIntId = NumIntId;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public void setTipoCurso(String TipoCurso) {
        this.TipoCurso = TipoCurso;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

    public void setOtraInfo(String OtraInfo) {
        this.OtraInfo = OtraInfo;
    }

    public void setLista_solicitantes(List<ValorDesplegable> lista_solicitantes) {
        this.lista_solicitantes = lista_solicitantes;
    }

    public void setLista_aseleccionados(List<ValorDesplegable> lista_aseleccionados) {
        this.lista_aseleccionados = lista_aseleccionados;
    }

    public void setLista_alumnos(List<Alumno> lista_alumnos) {
        this.lista_alumnos = lista_alumnos;
    }

    public void setObservaciones_cursos_formacion(List<Observaciones> observaciones_cursos_formacion) {
        this.observaciones_cursos_formacion = observaciones_cursos_formacion;
    }

    public CursosFormacion() {
    }
    
}
