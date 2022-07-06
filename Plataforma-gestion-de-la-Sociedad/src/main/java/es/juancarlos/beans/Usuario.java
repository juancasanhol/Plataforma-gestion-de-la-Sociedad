package es.juancarlos.beans;

import java.io.Serializable;
import java.util.ArrayList;
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

    @Column(name = "FechaAlta", nullable = true)
    String FechaAlta;

    @Column(name = "FechaBaja", nullable = true)
    String FechaBaja;

    @Column(name = "TipoDoc", nullable = true)//DESPLEGABLE
    String TipoDoc;

    @Column(name = "NumDoc", nullable = true)
    String NumDoc;

    @Column(name = "Telefono", nullable = true)
    String Telefono;

    @Column(name = "Correo", nullable = true)
    String Correo;

    @Column(name = "PersonaReferencia", nullable = true)//DESPLEGABLE
    String PersonaReferencia;

    @Column(name = "Sexo", nullable = true)//DESPLEGABLE
    String Sexo;

    @Column(name = "FechaNac", nullable = true)
    String FechaNac;

    @Column(name = "PaisOrigen", nullable = true)//DESPLEGABLE
    String PaisOrigen;

    @Column(name = "Nacionalidad", nullable = true)//DESPLEGABLE
    String Nacionalidad;

    @Column(name = "PerteneceMinoria", nullable = true)//CHECK
    Boolean PerteneceMinoria;

    @Column(name = "Minoria", nullable = true)//DESPLEGABLE
    String Minoria;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Observaciones> observaciones_id;//Son las observaciones referentes a la identificacion de una persona

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FicheroAdjunto> ficheros_usuario;

    ///////////////////DATOS SANITARIOS/////////////////
    @Column(name = "SolicitaAyudaFarmaceutica", nullable = true)//CHECK
    Boolean SolicitaAyudaFarmaceutica;

    @Column(name = "TratSanitario", nullable = true)
    String TratSanitario;

    @Column(name = "Drogodependencia", nullable = true)//CHECK
    Boolean Drogodependencia;

    @Column(name = "TipoDiscapacidad", nullable = true)//DESPLEGABLE
    String TipoDiscapacidad;

    @Column(name = "GradoDiscapacidad", nullable = true)//DESPLEGABLE
    String GradoDiscapacidad;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_obs_sanitarias")
    List<Observaciones> observaciones_sanitarias;

    ///////////////////DATOS LABORALES/////////////////
    @Column(name = "PermisoResidencia", nullable = true)//CHECK
    Boolean PermisoResidencia;

    @Column(name = "PermisoTrabajo", nullable = true)//CHECK
    Boolean PermisoTrabajo;

    @Column(name = "CarnetConducir", nullable = true)//CHECK
    Boolean CarnetConducir;

    @Column(name = "TipoCarnetConducir", nullable = true)//DESPLEGABLE
    String TipoCarnetConducir;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_valor")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> otros_carnets;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profesionobservaciones")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ProfesionObservaciones> profesion_observaciones;

    @Column(name = "SituacionLaboral", nullable = true)//DESPLEGABLE
    String SituacionLaboral;

    @Column(name = "UltTrabajo", nullable = true)
    String UltTrabajo;

    @Column(name = "PrefLaboral", nullable = true)
    String PrefLaboral;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_valor")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<ValorDesplegable> bolsa_trabajo;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_obs_datoslaborales")
    List<Observaciones> observaciones_datos_laborales;//Son las observaciones referentes a los datos laborales

    ///////////////////DATOS DE FORMACION/////////////////
    @Column(name = "NivelEstudios", nullable = true)//DESPLEGABLE
    String NivelEstudios;

    @Column(name = "FormacionComp", nullable = true)
    String FormacionComp;

    @Column(name = "EstaEstudiando", nullable = true)//CHECK
    Boolean EstaEstudiando;

    @Column(name = "FracasoEscolar", nullable = true)//CHECK
    Boolean FracasoEscolar;

    @Column(name = "CentroEst", nullable = true)
    String CentroEst;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_obs_formacion")
    List<Observaciones> observaciones_formacion;//Son las observaciones referentes a los datos de formacion

    ///////////////////INGRESOS/////////////////
    @Column(name = "Importe", nullable = true)
    float Importe;

    @Column(name = "OrigenIngresos", nullable = true)//DESPLEGABLE
    String OrigenIngresos;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_obs_ingresos")
    List<Observaciones> observaciones_ingresos;//Son las observaciones referentes a los ingresos

    //DATOS DE LA FICHA DE UNIDAD DE CONVIVENCIA, LOS CUALES NO SON OBLIGATORIOS TENER
    
    @Column(name = "Denominacion", nullable = true)
    String Denominacion;

    @Column(name = "Direccion", nullable = true)
    String Direccion;

    @Column(name = "Localidad", nullable = true)
    String Localidad = "Merida"; //POR DEFECTO ES MERIDA

    @Column(name = "FamiliaMonoparental", nullable = true)//CHECK
    Boolean FamiliaMonoparental;

    @Column(name = "SinHogar", nullable = true)//CHECK
    Boolean SinHogar;

    @Column(name = "CosteVivienda", nullable = true)
    float CosteVivienda;//Al mes

    @Column(name = "MotivoCoste", nullable = true)//DESPLEGABLE
    String MotivoCoste;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_obs_fichaconvivencia")
    List<Observaciones> observaciones_ficha_convivencia;//Son las observaciones referentes a la ficha de convivencia

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FicheroAdjunto> ficheros_unidadconvivencia;

    //SUMA DE INGRESOS DE LOS CONVIVIENTES (SE CALCULA SOLO)
    

    //DATOS DEL BANCO DE ALIMENTOS
    @Column(name = "EstaBanco", nullable = true)//CHECK
    Boolean EstaBanco;

    @Column(name = "FechaAlta_BancoAlimentos", nullable = true)
    String FechaAlta_BancoAlimentos;

    @Column(name = "FechaBaja_BancoAlimentos", nullable = true)
    String FechaBaja_BancoAlimentos;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<BancoAlimentos> lista_recogidas;

    //DATOS ORIENTACION LABORAL
    //Si se añade aqui un dato a un usuario, el check de orientacion laboral se activa
    @Column(name = "FechaOrientacion", nullable = true)
    String FechaOrientacion;

    @Column(name = "Beneficiario", nullable = true)
    String Beneficiario;

    //LISTA DE TIPOS DE SERVICIO Y OBSERVACIONES
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_obs_orientacion")
    List<Observaciones> observaciones_orientacion;//Son las observaciones referentes a orientacion laboral

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Usuario() {
    }

    public Usuario(String Nombre, String Apellidos) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
    }

    public Usuario(String Nombre, String Apellidos, String FechaAlta, String FechaBaja) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.FechaAlta = FechaAlta;
        this.FechaBaja = FechaBaja;
    }

    public Usuario(String Nombre, String Apellidos, String FechaAlta, String FechaBaja, String TipoDoc, String NumDoc, String Telefono, String Correo, String PersonaReferencia, String Sexo, String FechaNac, String PaisOrigen, String Nacionalidad, Boolean PerteneceMinoria, String Minoria, List<Observaciones> observaciones_id, List<FicheroAdjunto> ficheros_usuario) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.FechaAlta = FechaAlta;
        this.FechaBaja = FechaBaja;
        this.TipoDoc = TipoDoc;
        this.NumDoc = NumDoc;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.PersonaReferencia = PersonaReferencia;
        this.Sexo = Sexo;
        this.FechaNac = FechaNac;
        this.PaisOrigen = PaisOrigen;
        this.Nacionalidad = Nacionalidad;
        this.PerteneceMinoria = PerteneceMinoria;
        this.Minoria = Minoria;
        this.observaciones_id = observaciones_id;
        this.ficheros_usuario = ficheros_usuario;
        //Todas estas listas se crean ahora para que a la hora de añadir o editar los datos no haya que crearlas
        /*this.observaciones_sanitarias = new ArrayList<Observaciones>();
        this.profesion_observaciones = new ArrayList<ProfesionObservaciones>();
        this.observaciones_datos_laborales = new ArrayList<Observaciones>();
        this.observaciones_formacion = new ArrayList<Observaciones>();
        this.observaciones_ingresos = new ArrayList<Observaciones>();
        this.observaciones_ficha_convivencia = new ArrayList<Observaciones>();
        this.observaciones_orientacion = new ArrayList<Observaciones>();
        this.lista_recogidas = new ArrayList<BancoAlimentos>();*/
    }

    //Constructor usado para la insercion de datos en la edicion del usuario
    public Usuario(int NumIntId, String Nombre, String Apellidos, String FechaAlta, String FechaBaja, String TipoDoc, String NumDoc, String Telefono, String Correo, String PersonaReferencia, String Sexo, String FechaNac, String PaisOrigen, String Nacionalidad, Boolean PerteneceMinoria, String Minoria, Boolean SolicitaAyudaFarmaceutica, String TratSanitario, Boolean Drogodependencia, String TipoDiscapacidad, String GradoDiscapacidad, Boolean PermisoResidencia, Boolean PermisoTrabajo, Boolean CarnetConducir, String TipoCarnetConducir, String SituacionLaboral, String UltTrabajo, String PrefLaboral, String NivelEstudios, String FormacionComp, Boolean EstaEstudiando, Boolean FracasoEscolar, String CentroEst, float Importe, String OrigenIngresos, String Denominacion, String Direccion, Boolean FamiliaMonoparental, Boolean SinHogar, float CosteVivienda, String MotivoCoste, Boolean EstaBanco, String FechaAlta_BancoAlimentos, String FechaBaja_BancoAlimentos, String FechaOrientacion, String Beneficiario) {
        this.NumIntId = NumIntId;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.FechaAlta = FechaAlta;
        this.FechaBaja = FechaBaja;
        this.TipoDoc = TipoDoc;
        this.NumDoc = NumDoc;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.PersonaReferencia = PersonaReferencia;
        this.Sexo = Sexo;
        this.FechaNac = FechaNac;
        this.PaisOrigen = PaisOrigen;
        this.Nacionalidad = Nacionalidad;
        this.PerteneceMinoria = PerteneceMinoria;
        this.Minoria = Minoria;
        this.SolicitaAyudaFarmaceutica = SolicitaAyudaFarmaceutica;
        this.TratSanitario = TratSanitario;
        this.Drogodependencia = Drogodependencia;
        this.TipoDiscapacidad = TipoDiscapacidad;
        this.GradoDiscapacidad = GradoDiscapacidad;
        this.PermisoResidencia = PermisoResidencia;
        this.PermisoTrabajo = PermisoTrabajo;
        this.CarnetConducir = CarnetConducir;
        this.TipoCarnetConducir = TipoCarnetConducir;
        this.SituacionLaboral = SituacionLaboral;
        this.UltTrabajo = UltTrabajo;
        this.PrefLaboral = PrefLaboral;
        this.NivelEstudios = NivelEstudios;
        this.FormacionComp = FormacionComp;
        this.EstaEstudiando = EstaEstudiando;
        this.FracasoEscolar = FracasoEscolar;
        this.CentroEst = CentroEst;
        this.Importe = Importe;
        this.OrigenIngresos = OrigenIngresos;
        this.Denominacion = Denominacion;
        this.Direccion = Direccion;
        this.FamiliaMonoparental = FamiliaMonoparental;
        this.SinHogar = SinHogar;
        this.CosteVivienda = CosteVivienda;
        this.MotivoCoste = MotivoCoste;
        this.EstaBanco = EstaBanco;
        this.FechaAlta_BancoAlimentos = FechaAlta_BancoAlimentos;
        this.FechaBaja_BancoAlimentos = FechaBaja_BancoAlimentos;
        this.FechaOrientacion = FechaOrientacion;
        this.Beneficiario = Beneficiario;
    }

    
    
    public int getNumIntId() {
        return NumIntId;
    }

    public void setNumIntId(int NumIntId) {
        this.NumIntId = NumIntId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

    public String getFechaBaja() {
        return FechaBaja;
    }

    public void setFechaBaja(String FechaBaja) {
        this.FechaBaja = FechaBaja;
    }

    public String getTipoDoc() {
        return TipoDoc;
    }

    public void setTipoDoc(String TipoDoc) {
        this.TipoDoc = TipoDoc;
    }

    public String getNumDoc() {
        return NumDoc;
    }

    public void setNumDoc(String NumDoc) {
        this.NumDoc = NumDoc;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getPersonaReferencia() {
        return PersonaReferencia;
    }

    public void setPersonaReferencia(String PersonaReferencia) {
        this.PersonaReferencia = PersonaReferencia;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    public String getPaisOrigen() {
        return PaisOrigen;
    }

    public void setPaisOrigen(String PaisOrigen) {
        this.PaisOrigen = PaisOrigen;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public Boolean getPerteneceMinoria() {
        return PerteneceMinoria;
    }

    public void setPerteneceMinoria(Boolean PerteneceMinoria) {
        this.PerteneceMinoria = PerteneceMinoria;
    }

    public String getMinoria() {
        return Minoria;
    }

    public void setMinoria(String Minoria) {
        this.Minoria = Minoria;
    }

    public List<Observaciones> getObservaciones_id() {
        return observaciones_id;
    }

    public void setObservaciones_id(List<Observaciones> observaciones_id) {
        this.observaciones_id = observaciones_id;
    }

    public List<FicheroAdjunto> getFicheros_usuario() {
        return ficheros_usuario;
    }

    public void setFicheros_usuario(List<FicheroAdjunto> ficheros_usuario) {
        this.ficheros_usuario = ficheros_usuario;
    }

    public Boolean getSolicitaAyudaFarmaceutica() {
        return SolicitaAyudaFarmaceutica;
    }

    public void setSolicitaAyudaFarmaceutica(Boolean SolicitaAyudaFarmaceutica) {
        this.SolicitaAyudaFarmaceutica = SolicitaAyudaFarmaceutica;
    }

    public String getTratSanitario() {
        return TratSanitario;
    }

    public void setTratSanitario(String TratSanitario) {
        this.TratSanitario = TratSanitario;
    }

    public Boolean getDrogodependencia() {
        return Drogodependencia;
    }

    public void setDrogodependencia(Boolean Drogodependencia) {
        this.Drogodependencia = Drogodependencia;
    }

    public String getTipoDiscapacidad() {
        return TipoDiscapacidad;
    }

    public void setTipoDiscapacidad(String TipoDiscapacidad) {
        this.TipoDiscapacidad = TipoDiscapacidad;
    }

    public String getGradoDiscapacidad() {
        return GradoDiscapacidad;
    }

    public void setGradoDiscapacidad(String GradoDiscapacidad) {
        this.GradoDiscapacidad = GradoDiscapacidad;
    }

    public List<Observaciones> getObservaciones_sanitarias() {
        return observaciones_sanitarias;
    }

    public void setObservaciones_sanitarias(List<Observaciones> observaciones_sanitarias) {
        this.observaciones_sanitarias = observaciones_sanitarias;
    }

    public Boolean getPermisoResidencia() {
        return PermisoResidencia;
    }

    public void setPermisoResidencia(Boolean PermisoResidencia) {
        this.PermisoResidencia = PermisoResidencia;
    }

    public Boolean getPermisoTrabajo() {
        return PermisoTrabajo;
    }

    public void setPermisoTrabajo(Boolean PermisoTrabajo) {
        this.PermisoTrabajo = PermisoTrabajo;
    }

    public Boolean getCarnetConducir() {
        return CarnetConducir;
    }

    public void setCarnetConducir(Boolean CarnetConducir) {
        this.CarnetConducir = CarnetConducir;
    }

    public String getTipoCarnetConducir() {
        return TipoCarnetConducir;
    }

    public void setTipoCarnetConducir(String TipoCarnetConducir) {
        this.TipoCarnetConducir = TipoCarnetConducir;
    }

    public List<ValorDesplegable> getOtros_carnets() {
        return otros_carnets;
    }

    public void setOtros_carnets(List<ValorDesplegable> otros_carnets) {
        this.otros_carnets = otros_carnets;
    }

    public List<ProfesionObservaciones> getProfesion_observaciones() {
        return profesion_observaciones;
    }

    public void setProfesion_observaciones(List<ProfesionObservaciones> profesion_observaciones) {
        this.profesion_observaciones = profesion_observaciones;
    }

    public String getSituacionLaboral() {
        return SituacionLaboral;
    }

    public void setSituacionLaboral(String SituacionLaboral) {
        this.SituacionLaboral = SituacionLaboral;
    }

    public String getUltTrabajo() {
        return UltTrabajo;
    }

    public void setUltTrabajo(String UltTrabajo) {
        this.UltTrabajo = UltTrabajo;
    }

    public String getPrefLaboral() {
        return PrefLaboral;
    }

    public void setPrefLaboral(String PrefLaboral) {
        this.PrefLaboral = PrefLaboral;
    }

    public List<ValorDesplegable> getBolsa_trabajo() {
        return bolsa_trabajo;
    }

    public void setBolsa_trabajo(List<ValorDesplegable> bolsa_trabajo) {
        this.bolsa_trabajo = bolsa_trabajo;
    }

    public List<Observaciones> getObservaciones_datos_laborales() {
        return observaciones_datos_laborales;
    }

    public void setObservaciones_datos_laborales(List<Observaciones> observaciones_datos_laborales) {
        this.observaciones_datos_laborales = observaciones_datos_laborales;
    }

    public String getNivelEstudios() {
        return NivelEstudios;
    }

    public void setNivelEstudios(String NivelEstudios) {
        this.NivelEstudios = NivelEstudios;
    }

    public String getFormacionComp() {
        return FormacionComp;
    }

    public void setFormacionComp(String FormacionComp) {
        this.FormacionComp = FormacionComp;
    }

    public Boolean getEstaEstudiando() {
        return EstaEstudiando;
    }

    public void setEstaEstudiando(Boolean EstaEstudiando) {
        this.EstaEstudiando = EstaEstudiando;
    }

    public Boolean getFracasoEscolar() {
        return FracasoEscolar;
    }

    public void setFracasoEscolar(Boolean FracasoEscolar) {
        this.FracasoEscolar = FracasoEscolar;
    }

    public String getCentroEst() {
        return CentroEst;
    }

    public void setCentroEst(String CentroEst) {
        this.CentroEst = CentroEst;
    }

    public List<Observaciones> getObservaciones_formacion() {
        return observaciones_formacion;
    }

    public void setObservaciones_formacion(List<Observaciones> observaciones_formacion) {
        this.observaciones_formacion = observaciones_formacion;
    }

    public float getImporte() {
        return Importe;
    }

    public void setImporte(float Importe) {
        this.Importe = Importe;
    }

    public String getOrigenIngresos() {
        return OrigenIngresos;
    }

    public void setOrigenIngresos(String OrigenIngresos) {
        this.OrigenIngresos = OrigenIngresos;
    }

    public List<Observaciones> getObservaciones_ingresos() {
        return observaciones_ingresos;
    }

    public void setObservaciones_ingresos(List<Observaciones> observaciones_ingresos) {
        this.observaciones_ingresos = observaciones_ingresos;
    }

    public String getDenominacion() {
        return Denominacion;
    }

    public void setDenominacion(String Denominacion) {
        this.Denominacion = Denominacion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public Boolean getFamiliaMonoparental() {
        return FamiliaMonoparental;
    }

    public void setFamiliaMonoparental(Boolean FamiliaMonoparental) {
        this.FamiliaMonoparental = FamiliaMonoparental;
    }

    public Boolean getSinHogar() {
        return SinHogar;
    }

    public void setSinHogar(Boolean SinHogar) {
        this.SinHogar = SinHogar;
    }

    public float getCosteVivienda() {
        return CosteVivienda;
    }

    public void setCosteVivienda(float CosteVivienda) {
        this.CosteVivienda = CosteVivienda;
    }

    public String getMotivoCoste() {
        return MotivoCoste;
    }

    public void setMotivoCoste(String MotivoCoste) {
        this.MotivoCoste = MotivoCoste;
    }

    public List<Observaciones> getObservaciones_ficha_convivencia() {
        return observaciones_ficha_convivencia;
    }

    public void setObservaciones_ficha_convivencia(List<Observaciones> observaciones_ficha_convivencia) {
        this.observaciones_ficha_convivencia = observaciones_ficha_convivencia;
    }

    public List<FicheroAdjunto> getFicheros_unidadconvivencia() {
        return ficheros_unidadconvivencia;
    }

    public void setFicheros_unidadconvivencia(List<FicheroAdjunto> ficheros_unidadconvivencia) {
        this.ficheros_unidadconvivencia = ficheros_unidadconvivencia;
    }

    public Boolean getEstaBanco() {
        return EstaBanco;
    }

    public void setEstaBanco(Boolean EstaBanco) {
        this.EstaBanco = EstaBanco;
    }

    public String getFechaAlta_BancoAlimentos() {
        return FechaAlta_BancoAlimentos;
    }

    public void setFechaAlta_BancoAlimentos(String FechaAlta_BancoAlimentos) {
        this.FechaAlta_BancoAlimentos = FechaAlta_BancoAlimentos;
    }

    public String getFechaBaja_BancoAlimentos() {
        return FechaBaja_BancoAlimentos;
    }

    public void setFechaBaja_BancoAlimentos(String FechaBaja_BancoAlimentos) {
        this.FechaBaja_BancoAlimentos = FechaBaja_BancoAlimentos;
    }

    public List<BancoAlimentos> getLista_recogidas() {
        return lista_recogidas;
    }

    public void setLista_recogidas(List<BancoAlimentos> lista_recogidas) {
        this.lista_recogidas = lista_recogidas;
    }

    public String getFechaOrientacion() {
        return FechaOrientacion;
    }

    public void setFechaOrientacion(String FechaOrientacion) {
        this.FechaOrientacion = FechaOrientacion;
    }

    public String getBeneficiario() {
        return Beneficiario;
    }

    public void setBeneficiario(String Beneficiario) {
        this.Beneficiario = Beneficiario;
    }

    public List<Observaciones> getObservaciones_orientacion() {
        return observaciones_orientacion;
    }

    public void setObservaciones_orientacion(List<Observaciones> observaciones_orientacion) {
        this.observaciones_orientacion = observaciones_orientacion;
    }

   
}
