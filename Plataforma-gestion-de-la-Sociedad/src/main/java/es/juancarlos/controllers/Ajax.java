package es.juancarlos.controllers;

import Enum.TipoPerfil;
import es.juancarlos.beans.Acogida;
import es.juancarlos.beans.Alimentos;
import es.juancarlos.beans.Alumno;
import es.juancarlos.beans.AtencionSocialIgualdad;
import es.juancarlos.beans.AulaMagica;
import es.juancarlos.beans.BancoAlimentos;
import es.juancarlos.beans.ConferenciaSantaMaria;
import es.juancarlos.beans.CursosFormacion;
import es.juancarlos.beans.Desplegables;
import es.juancarlos.beans.Empresa;
import es.juancarlos.beans.Observaciones;
import es.juancarlos.beans.Perfil;
import es.juancarlos.beans.UsuXFecha;
import es.juancarlos.beans.Proyecto;
import es.juancarlos.beans.UsuXFecha;
import es.juancarlos.beans.Usuario;
import es.juancarlos.beans.ValorDesplegable;
import es.juancarlos.dao.ListaDao;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IAjaxDAO;
import es.juancarlos.interfaces.IDesplegablesDAO;
import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.interfaces.IListaDao;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Juan Carlos Sánchez Holguín
 */
@WebServlet(name = "Ajax", urlPatterns = {"/Ajax"})
public class Ajax extends HttpServlet {

    //para devolver un solo objeto
    JSONObject objeto = null;

    //para devolver uno o varios objetos (varios preferiblemente)
    JSONArray arrayJSON = null;

    /**
     * Servlet usado para consultas Ajax de las diferentes páginas
     *
     * @param request Servlet request
     * @param response Servlet response
     * @throws ServletException Si ocurre un error específico del Servlet
     * @throws IOException Si ocurre un error de I/O
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        IAjaxDAO adao = daof.getAjaxDAO();
        IListaDao ldao = daof.getListaDAO();
        IDesplegablesDAO ddao = daof.getDesplegablesDAO();

        Usuario u;
        CursosFormacion c;
        AulaMagica a;
        Iterator i, it;
        Desplegables d;
        Empresa e;
        Acogida ac;
        AtencionSocialIgualdad asi;
        Alumno al;
        ConferenciaSantaMaria conf;
        List desplegables, cursos, aulas, empresas, acogidas, atenciones, alumnos, conferencias, bancos, observaciones, obs, valores, listadouserproyect;
        BancoAlimentos b;
        Perfil p;
        /*gdao.insertOrUpdate(new Usuario("PROBANDO0", "PROBANDO0"));
        gdao.insertOrUpdate(new Usuario("PROBANDO1", "PROBANDO1"));
        gdao.insertOrUpdate(new Usuario("PROBANDO2", "PROBANDO2"));*/
        switch (request.getParameter("accion")) {

            case "prueba1":
                /*Usuario u = (Usuario) gdao.getById(Integer.parseInt(request.getParameter("dato")), Usuario.class);

                objeto = new JSONObject();
                objeto.put("id", u.getNumIntId());
                objeto.put("nombre", u.getNombre());//...

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                 */
                break;

            case "prueba2":

                /*List retorno = new ArrayList();
                Iterator i = gdao.get(Usuario.class).iterator();
                while (i.hasNext()) {

                    Usuario u2 = (Usuario) i.next();
                    objeto = new JSONObject();
                    objeto.put("id", u2.getNumIntId());
                    objeto.put("nombre", u2.getNombre());

                    retorno.add(objeto);
                }

                arrayJSON = new JSONArray(retorno);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                 */
                break;
            //ESTA PARTE ES PARA EL Logueo

            case "login":
                p = null;
                p = (Perfil) gdao.getById(adao.LoginId(request.getParameter("usuario"), request.getParameter("passwd")), Perfil.class);
                objeto = new JSONObject();

                if (!p.equals(null)) {
                    objeto.put("aceso", true);
                    objeto.put("tipo", p.getTipo());

                    request.getSession().setAttribute("autor", p.getUsuario());
                    request.getSession().setAttribute("idAutor", p.getNumIntId());
                    request.getSession().setAttribute("tipo", p.getTipo());

                } else {
                    objeto.put("aceso", true);
                }

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;

            case "tipos":

                List retorno = new ArrayList();
                TipoPerfil[] enu = TipoPerfil.values();

                for (TipoPerfil enu1 : enu) {
                    objeto = new JSONObject();
                    objeto.put("tipo", enu1);
                    retorno.add(objeto);
                }

                arrayJSON = new JSONArray(retorno);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);

                break;

            case "addPerfil":

                switch (request.getParameter("tipo")) {

                    case "ADMIN":
                        gdao.insertOrUpdate(new Perfil(request.getParameter("usuario"), request.getParameter("passwd"), TipoPerfil.ADMIN));
                        break;

                    case "PROFESOR":
                        gdao.insertOrUpdate(new Perfil(request.getParameter("usuario"), request.getParameter("passwd"), TipoPerfil.PROFESOR));
                        break;

                    case "PROFESIONAL":
                        gdao.insertOrUpdate(new Perfil(request.getParameter("usuario"), request.getParameter("passwd"), TipoPerfil.PROFESIONAL));
                        break;

                }

                break;

            //ESTA PARTE ES PARA EL REGISTRO DE UN USUARIO NUEVO
            case "Usuario":
                //Primero se hace el desplegable para los usuarios de la conferencia y luego los demas
                desplegables = new ArrayList();
                try {
                    it = gdao.get(Usuario.class).iterator();
                    while (it.hasNext()) {
                        u = (Usuario) it.next();
                        objeto = new JSONObject();
                        objeto.put("idUsuarios", u.getNumIntId());
                        objeto.put("usuarios", u.getNombre() + " " + u.getApellidos());
                        desplegables.add(objeto);

                    }
                } catch (Exception exc) {
                    //Para que cargue los desplegables de forma secuencial
                }
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    //Tipo de documento identificativo
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("TipoDocumentoIdentificativo")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idTipodocumento", lista.get(j).getId());
                            objeto.put("tipodocumento", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Sexo")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idSexo", lista.get(j).getId());
                            objeto.put("sexo", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("PaisOrigen")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idPaisorigen", lista.get(j).getId());
                            objeto.put("paisorigen", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Nacionalidad")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idNacionalidad", lista.get(j).getId());
                            objeto.put("nacionalidad", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("MinoriaEtnica")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idMinoriaetnica", lista.get(j).getId());
                            objeto.put("minoriaetnica", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }

                    if (d.getNombre().equals("TipoCarnetConducir")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("tipoCarnetConducir", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }

                    if (d.getNombre().equals("BolsaTrabajo")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idNombreBolsa", lista.get(j).getId());
                            objeto.put("nombreBolsa", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }

                    if (d.getNombre().equals("Parentesco")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idParentesco", lista.get(j).getId());
                            objeto.put("parentesco", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                     if (d.getNombre().equals("OrigenIngresos")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idOrigenIngresos", lista.get(j).getId());
                            objeto.put("origenIngresos", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }

                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "EditarUsuario":
                u = (Usuario) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Usuario.class);
                desplegables = new ArrayList();
                List<ValorDesplegable> carnets_usuario = u.getOtros_carnets();
                List<ValorDesplegable> bolsas_usuario = u.getBolsa_trabajo();
                List<ValorDesplegable> bolsas = new ArrayList<ValorDesplegable>();
                List<ValorDesplegable> carnets = new ArrayList<ValorDesplegable>();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("TipoCarnetConducir")) {
                        carnets = d.getValores();
                    }
                    if (d.getNombre().equals("BolsaTrabajo")) {
                        bolsas = d.getValores();
                    }
                }
                //Para rellenar el select de editar carnets de conducir
                boolean esta = false;
                if (carnets != null) {
                    for (int i2 = 0; i2 < carnets.size(); i2++) {
                        if (carnets_usuario != null) {
                            for (int j = 0; j < carnets_usuario.size(); j++) {
                                if (carnets_usuario.get(j) != null && carnets.get(i2) != null) {
                                    if (carnets_usuario.get(j).getValor().equals(carnets.get(i2).getValor())) {
                                        esta = true;
                                    }
                                }
                            }
                        }
                        if (!esta) {
                            objeto = new JSONObject();
                            objeto.put("addcarnet", carnets.get(i2).getValor());
                            desplegables.add(objeto);
                        }
                        esta = false;
                    }
                    for (int i2 = 0; i2 < carnets_usuario.size(); i2++) {
                        if (carnets_usuario.get(i2).getValor() != null) {
                            objeto = new JSONObject();
                            objeto.put("borrarcarnet", carnets_usuario.get(i2).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                //Para rellenar el select de bolsa de trabajo
                esta = false;
                if (bolsas != null) {
                    for (int i2 = 0; i2 < bolsas.size(); i2++) {
                        if (bolsas_usuario != null) {
                            for (int j = 0; j < bolsas_usuario.size(); j++) {
                                if (bolsas_usuario.get(j) != null && bolsas.get(i2) != null) {
                                    if (bolsas_usuario.get(j).getValor().equals(bolsas.get(i2).getValor())) {
                                        esta = true;
                                    }
                                }
                            }
                        }
                        if (!esta) {
                            objeto = new JSONObject();
                            objeto.put("addbolsa", bolsas.get(i2).getValor());
                            desplegables.add(objeto);
                        }
                        esta = false;
                    }
                    for (int i2 = 0; i2 < bolsas_usuario.size(); i2++) {
                        if (bolsas_usuario.get(i2).getValor() != null) {
                            objeto = new JSONObject();
                            objeto.put("borrarbolsa", bolsas_usuario.get(i2).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "DatosSanitarios":
                //PARA LOS DESPLEGABLES DE LOS DATOS SANITARIOS
                desplegables = new ArrayList();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("TipoDiscapacidad")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("tipodiscapacidad", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("GradoDiscapacidad")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("gradodiscapacidad", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "DatosLaborales":
                //PARA LOS DESPLEGABLES DE LOS DATOS LABORALES
                desplegables = new ArrayList();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("TipoCarnetConducir")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("tipocarnetconducir", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("SituacionLaboral")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("situacionlaboral", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "DatosFormacion":
                //PARA LOS DESPLEGABLES DE LOS DATOS DE FORMACION
                desplegables = new ArrayList();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("NivelEstudios")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("nivelestudios", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "Ingresos":
                //PARA LOS DESPLEGABLES DE LOS INGRESOS
                desplegables = new ArrayList();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("OrigenIngresos")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("origeningresos", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;

            case "AulaMagicaProf":
                desplegables = new ArrayList();
                it = gdao.get(Perfil.class).iterator();
                while (it.hasNext()) {
                    p = (Perfil) it.next();
                    if (p.getTipo().equals(TipoPerfil.PROFESOR)) {
                        objeto = new JSONObject();
                        objeto.put("nombre", p.getUsuario());
                        objeto.put("idProfe", p.getNumIntId());
                        desplegables.add(objeto);
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "UnidadConvivencia":
                //PARA LOS DESPLEGABLES DE LA FICHA DE UNIDAD DE CONVIVENCIA
                desplegables = new ArrayList();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("MotivoCoste")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("motivocoste", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerDatosUsuario":
                //PARA MOSTRAR LOS DATOS DE LOS USUARIOS ANTES DE EDITAR
                u = (Usuario) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Usuario.class);
                objeto = new JSONObject();
                objeto.put("id", u.getNumIntId());
                objeto.put("nombre", u.getNombre());
                objeto.put("apellidos", u.getApellidos());
                objeto.put("fechaalta", u.getFechaAlta());
                objeto.put("fechabaja", u.getFechaBaja());
                objeto.put("tipodoc", u.getTipoDoc());
                objeto.put("numdoc", u.getNumDoc());
                objeto.put("telefono", u.getTelefono());
                objeto.put("correo", u.getCorreo());
                objeto.put("personareferencia", u.getPersonaReferencia());
                objeto.put("sexo", u.getSexo());
                objeto.put("fechanac", u.getFechaNac());
                objeto.put("paisorigen", u.getPaisOrigen());
                objeto.put("nacionalidad", u.getNacionalidad());
                objeto.put("perteneceminoria", u.isPerteneceMinoria());
                objeto.put("minoria", u.getMinoria());
                objeto.put("solicitaayudafarmaceutica", u.getSolicitaAyudaFarmaceutica());
                objeto.put("tratsanitario", u.getTratSanitario());
                objeto.put("drogodependencia", u.getDrogodependencia());
                objeto.put("tipodiscapacidad", u.getTipoDiscapacidad());
                objeto.put("gradodiscapacidad", u.getGradoDiscapacidad());
                objeto.put("permisoresidencia", u.getPermisoResidencia());
                objeto.put("permisotrabajo", u.getPermisoTrabajo());
                objeto.put("carnetconducir", u.getCarnetConducir());
                objeto.put("tipocarnetconducir", u.getTipoCarnetConducir());
                objeto.put("situacionlaboral", u.getSituacionLaboral());
                objeto.put("ulttrabajo", u.getUltTrabajo());
                objeto.put("preflaboral", u.getPrefLaboral());
                objeto.put("nivelestudios", u.getNivelEstudios());
                objeto.put("formacioncomp", u.getFormacionComp());
                objeto.put("estaestudiando", u.getEstaEstudiando());
                objeto.put("fracasoescolar", u.getFracasoEscolar());
                objeto.put("centroest", u.getCentroEst());
                objeto.put("ingresos", u.getIngresos());
                objeto.put("unidadConvivencia", u.getFamiliares());
                objeto.put("denominacion", u.getDenominacion());
                objeto.put("direccion", u.getDireccion());
                objeto.put("localidad", u.getLocalidad());
                objeto.put("familiamonoparental", u.getFamiliaMonoparental());
                objeto.put("sinhogar", u.getSinHogar());
                objeto.put("costevivienda", u.getCosteVivienda());
                objeto.put("motivocoste", u.getMotivoCoste());
                objeto.put("estabanco", u.getEstaBanco());
                objeto.put("fechaalta_bancoalimentos", u.getFechaAlta_BancoAlimentos());
                objeto.put("fechabaja_bancoalimentos", u.getFechaBaja_BancoAlimentos());
                objeto.put("fechaorientacion", u.getFechaOrientacion());
                objeto.put("beneficiario", u.getBeneficiario());
                //log("EL BOOLEAN SE VE ASI: "+u.getPerteneceMinoria());
                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;

            case "OtrosCarnet":
                desplegables = new ArrayList();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("OtrosCarnets")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("OtrosCarnets", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;

            case "CursosFormacion":
                //PARA LOS DESPLEGABLES DE LOS DATOS SANITARIOS
                desplegables = new ArrayList();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("TipoCurso")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("tipocurso", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                it = gdao.get(Alumno.class).iterator();
                while (it.hasNext()) {
                    al = (Alumno) it.next();
                    objeto = new JSONObject();
                    objeto.put("alumno", al.getPersona().replaceAll(" ", "_"));
                    desplegables.add(objeto);

                }
                it = gdao.get(Usuario.class).iterator();
                while (it.hasNext()) {
                    u = (Usuario) it.next();
                    objeto = new JSONObject();
                    objeto.put("idSol", u.getNumIntId());
                    objeto.put("solicitante", (u.getNombre() + " " + u.getApellidos()).replaceAll(" ", "_"));
                    desplegables.add(objeto);

                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerAlumnosAula":
                AulaMagica am = (AulaMagica) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), AulaMagica.class);
                desplegables = new ArrayList();
                for (int tam = 0; tam < am.getLista_alumnos().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("alumno", am.getLista_alumnos().get(tam).getPersona().replaceAll(" ", "_"));
                    desplegables.add(objeto);
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "Empresas":
                //PARA LOS DESPLEGABLES DE LAS EMPRESAS
                desplegables = new ArrayList();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("Actividad")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idActividad", lista.get(j).getId());
                            objeto.put("actividad", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("TiposColaboracion")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idTiposcolaboracion", lista.get(j).getId());
                            objeto.put("tiposcolaboracion", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "Acogida":
                //Primero se hace el desplegable para los usuarios y luego los demas
                desplegables = new ArrayList();
                try {
                    it = gdao.get(Usuario.class).iterator();
                    while (it.hasNext()) {
                        u = (Usuario) it.next();
                        objeto = new JSONObject();
                        objeto.put("idUsuario", u.getNumIntId());
                        objeto.put("usuarios", u.getNombre() + " " + u.getApellidos());
                        desplegables.add(objeto);

                    }
                } catch (Exception exc) {
                    //Para cargar los desplegables correctamente
                }
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("ProcedenciaDerivacion")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("idProcedenciaderivacion", lista.get(j).getId());
                            objeto.put("procedenciaderivacion", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("AyudaGeneral")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("idAyudageneral", lista.get(j).getId());
                            objeto.put("ayudageneral", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("AyudaRecibos")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("idAyudarecibos", lista.get(j).getId());
                            objeto.put("ayudarecibos", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("AyudaAsistenciaSanitaria")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("idAyudasanitaria", lista.get(j).getId());
                            objeto.put("ayudasanitaria", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("OtrasAyudas")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("idAyudaotra", lista.get(j).getId());
                            objeto.put("ayudaotra", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("EstadoResolucion")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("idEstadoresolucion", lista.get(j).getId());
                            objeto.put("estadoresolucion", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "BancoAlimentos":
                //Primero se hace el desplegable para los usuarios y luego los demas
                desplegables = new ArrayList();
                try {
                    it = gdao.get(Usuario.class).iterator();

                    while (it.hasNext()) {
                        u = (Usuario) it.next();
                        objeto = new JSONObject();
                        objeto.put("idUsuarios", u.getNumIntId());
                        objeto.put("usuarios", u.getNombre() + " " + u.getApellidos());
                        desplegables.add(objeto);

                    }
                } catch (Exception exc) {
                    //Para cargar los desplegables sin errores
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "AtencionSocialIgualdad":
                //Primero se hace el desplegable para los usuarios y luego los demas
                desplegables = new ArrayList();
                try {
                    it = gdao.get(Usuario.class).iterator();
                    while (it.hasNext()) {
                        u = (Usuario) it.next();
                        objeto = new JSONObject();
                        objeto.put("idUsuarios", u.getNumIntId());
                        objeto.put("usuarios", u.getNombre() + " " + u.getApellidos());
                        desplegables.add(objeto);
                    }
                } catch (Exception exc) {
                    //Para cargar los desplegables sin errores
                }
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("ProcedenciaDerivacion")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("idProcedenciaderivacion", lista.get(j).getId());
                            objeto.put("procedenciaderivacion", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Intervencion")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("idIntervencion", lista.get(j).getId());
                            objeto.put("intervencion", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("MotivoConsulta")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("idMotivoconsulta", lista.get(j).getId());
                            objeto.put("motivoconsulta", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("EstadoResolucion")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("idEstadoresolucion", lista.get(j).getId());
                            objeto.put("estadoresolucion", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "ConferenciaSantaMaria":
                //PARA LOS DESPLEGABLES DE CONFERENCIA SANTA MARIA
                desplegables = new ArrayList();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("Actividad")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idActividad", lista.get(j).getId());
                            objeto.put("actividad", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Categoria")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idCategoria", lista.get(j).getId());
                            objeto.put("categoria", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Cargo")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idCargo", lista.get(j).getId());
                            objeto.put("cargo", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Sexo")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idSexo", lista.get(j).getId());
                            objeto.put("sexo", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }

                    if (d.getNombre().equals("Colectivos")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("idColectivos", lista.get(j).getId());
                            objeto.put("colectivos", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "Alumnos":
                //Primero se hace el desplegable para los usuarios de la conferencia y luego los demas
                desplegables = new ArrayList();
                try {
                    it = gdao.get(Usuario.class).iterator();
                    while (it.hasNext()) {
                        u = (Usuario) it.next();
                        objeto = new JSONObject();
                        objeto.put("personas", u.getNombre() + " " + u.getApellidos());
                        desplegables.add(objeto);

                    }
                } catch (Exception exc) {
                    //Para cargar los desplegables sin errores
                }
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    //Tipo de documento identificativo
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("EmpresaPracticas")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("empresapracticas", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                }
                arrayJSON = new JSONArray(desplegables);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerUsuarios":
                Boolean estaBanco=Boolean.parseBoolean(request.getParameter("banco"));
                Boolean estaFega=Boolean.parseBoolean(request.getParameter("fega"));
                Boolean lTodos=Boolean.parseBoolean(request.getParameter("lTodos"));
                List usuarios = new ArrayList();
                try {
                    if(lTodos){
                    i=gdao.get(Usuario.class).iterator();
                    }else{
                       i = ldao.ListadoXBanco_Fega(estaBanco, estaFega).iterator(); 
                    }
                    while (i.hasNext()) {
                        u = (Usuario) i.next();
                        objeto = new JSONObject();
                        objeto.put("id", u.getNumIntId());
                        objeto.put("nombre", u.getNombre());
                        objeto.put("apellidos", u.getApellidos());
                        usuarios.add(objeto);
                    }
                } catch (Exception exc) {
                    System.out.println(exc);
                }
                arrayJSON = new JSONArray(usuarios);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerCursos":
                cursos = new ArrayList();
                try {
                    i = gdao.get(CursosFormacion.class).iterator();
                    while (i.hasNext()) {
                        c = (CursosFormacion) i.next();
                        objeto = new JSONObject();
                        objeto.put("id", c.getNumIntId());
                        objeto.put("nombrecurso", c.getNombreCurso());
                        objeto.put("tipocurso", c.getTipoCurso());
                        cursos.add(objeto);
                    }
                } catch (Exception exc) {
                    //Para cargar los desplegables sin errores
                }
                arrayJSON = new JSONArray(cursos);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerDatosCurso":
                //PARA MOSTRAR LOS DATOS DE LOS USUARIOS ANTES DE EDITAR
                c = (CursosFormacion) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), CursosFormacion.class);
                objeto = new JSONObject();
                objeto.put("id", c.getNumIntId());
                objeto.put("nombrecurso", c.getNombreCurso());
                objeto.put("tipocurso", c.getTipoCurso());
                objeto.put("fechainicio", c.getFechaInicio());
                objeto.put("fechafin", c.getFechaFin());
                objeto.put("otrainfo", c.getOtraInfo());

                //log(" ID = " + c.getNumIntId());
                //COMPLETAR DATOS DE LISTAS AQUI
                //log("EL BOOLEAN SE VE ASI: "+u.getPerteneceMinoria());
                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
            case "VerAulas":
                aulas = new ArrayList();
                try {
                    i = gdao.get(AulaMagica.class).iterator();
                    while (i.hasNext()) {
                        a = (AulaMagica) i.next();
                        objeto = new JSONObject();
                        objeto.put("id", a.getNumIntId());
                        objeto.put("denominacion", a.getDenominacion());
                        objeto.put("profesor", a.getProfesor());
                        aulas.add(objeto);
                    }
                } catch (Exception exc) {
                    //Para cargar sin errores
                }
                arrayJSON = new JSONArray(aulas);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerDatosAula":
                //PARA MOSTRAR LOS DATOS DE LOS USUARIOS ANTES DE EDITAR
                a = (AulaMagica) gdao.getById(Integer.parseInt((String) request.getSession().getAttribute("id")), AulaMagica.class);
                objeto = new JSONObject();
                objeto.put("id", a.getNumIntId());
                objeto.put("denominacion", a.getDenominacion());
                objeto.put("profesor", a.getProfesor());
                //COMPLETAR DATOS DE LISTAS AQUI

                //log("EL BOOLEAN SE VE ASI: "+u.getPerteneceMinoria());
                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;

            case "addEmpresa":

                List<ValorDesplegable> activi = new ArrayList<>();
                List<ValorDesplegable> colabo = new ArrayList<>();
                alumnos = new ArrayList<>();

                String[] act = request.getParameter("actividad").split(";");
                String[] colab = request.getParameter("colab").split(";");

                for (String actividad : act) {
                    activi.add((ValorDesplegable) gdao.getById(Integer.parseInt(actividad), ValorDesplegable.class));
                }

                for (String colaboracion : colab) {
                    colabo.add((ValorDesplegable) gdao.getById(Integer.parseInt(colaboracion), ValorDesplegable.class));
                }

                e = new Empresa(request.getParameter("nombre"), request.getParameter("fechaAlta"), request.getParameter("fechaBaja"), request.getParameter("personaContacto"), request.getParameter("direccion"), request.getParameter("codigoPostal"), request.getParameter("poblacion"), request.getParameter("provincia"), activi, colabo);
                gdao.insertOrUpdate(e);
                break;
            case "VerEmpresas":
                empresas = new ArrayList();
                try {
                    i = gdao.get(Empresa.class).iterator();
                    while (i.hasNext()) {
                        e = (Empresa) i.next();
                        objeto = new JSONObject();
                        objeto.put("id", e.getCodIntId());
                        objeto.put("nombre", e.getNombre());
                        objeto.put("localidad", e.getLocalidad());
                        empresas.add(objeto);
                    }
                } catch (Exception exc) {
                    //Para cargar sin errores
                }
                arrayJSON = new JSONArray(empresas);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerDatosEmpresa":
                //PARA MOSTRAR LOS DATOS DE LOS USUARIOS ANTES DE EDITAR
                e = (Empresa) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Empresa.class);
                objeto = new JSONObject();
                objeto.put("id", e.getCodIntId());
                objeto.put("nombre", e.getNombre());
                objeto.put("direccion", e.getDireccion());
                objeto.put("fechaalta", e.getFechaAlta());
                objeto.put("fechabaja", e.getFechaBaja());
                objeto.put("codigopostal", e.getCodigoPostal());
                objeto.put("poblacion", e.getLocalidad());
                objeto.put("personacontacto", e.getPersonaContacto());
                objeto.put("provincia", e.getProvincia());
                //COMPLETAR DATOS DE LISTAS AQUI

                //log("EL BOOLEAN SE VE ASI: "+u.getPerteneceMinoria());
                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
            case "VerFichasAcogida":
                acogidas = new ArrayList();
                try {
                    i = gdao.get(Acogida.class).iterator();
                    while (i.hasNext()) {
                        ac = (Acogida) i.next();
                        objeto = new JSONObject();
                        objeto.put("id", ac.getNumIntId());
                        objeto.put("nombre", ac.getUsuario());
                        acogidas.add(objeto);
                    }
                } catch (Exception exc) {
                    //Para acrgar sin errores
                }
                arrayJSON = new JSONArray(acogidas);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerDatosFichaAcogida":
                //PARA MOSTRAR LOS DATOS DE LOS USUARIOS ANTES DE EDITAR
                ac = (Acogida) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Acogida.class);
                objeto = new JSONObject();
                objeto.put("id", ac.getNumIntId());
                objeto.put("fecha", ac.getFecha());
                objeto.put("ayudageneral", ac.getAyudaSolicitada_General());
                objeto.put("ayudarecibos", ac.getAyudaSolicitada_Recibos());
                objeto.put("ayudasanitaria", ac.getAyudaSolicitada_Sanitaria());
                objeto.put("ayudaotra", ac.getAyudaSolicitada_Otras());
                objeto.put("estadoresolucion", ac.getEstadoResolucion().getValor());
                objeto.put("trabajador", ac.getTrabajador().getUsuario());
                objeto.put("usuario", ac.getUsuario().getNombre() + " " + ac.getUsuario().getApellidos());
                objeto.put("procedenciaderivacion", ac.getProcedenciaDerivacion().getValor());
                //COMPLETAR DATOS DE LISTAS AQUI

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
            case "VerFichasAtencionSocialIgualdad":
                atenciones = new ArrayList();
                try {
                    i = gdao.get(AtencionSocialIgualdad.class).iterator();
                    while (i.hasNext()) {
                        asi = (AtencionSocialIgualdad) i.next();
                        objeto = new JSONObject();
                        objeto.put("id", asi.getNumIntId());
                        objeto.put("datos", asi.getFecha() + " " + asi.getMotivoConsulta() + " " + asi.getEstadoResolucion());
                        atenciones.add(objeto);
                    }
                } catch (Exception exc) {
                    //Para cargar sin errores
                }
                arrayJSON = new JSONArray(atenciones);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerDatosFichaAtencionSocialIgualdad":
                //PARA MOSTRAR LOS DATOS DE LOS USUARIOS ANTES DE EDITAR
                asi = (AtencionSocialIgualdad) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), AtencionSocialIgualdad.class);
                objeto = new JSONObject();
                objeto.put("id", asi.getNumIntId());
                objeto.put("fecha", asi.getFecha());
                objeto.put("motivoconsulta", asi.getMotivoConsulta());
                objeto.put("intervencion", asi.getIntervencion());
                objeto.put("estadoresolucion", asi.getEstadoResolucion());
                objeto.put("trabajador", asi.getTrabajador().getUsuario());
                objeto.put("usuario", asi.getUsuario().getNombre() + " " + asi.getUsuario().getApellidos());
                objeto.put("procedenciaderivacion", asi.getProcedenciaDerivacion());
                //COMPLETAR DATOS DE OBSERVACIONES Y LISTAS DE FICHEROS

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
            case "VerBancosAlimentos":
                bancos = new ArrayList();
                try {
                    i = gdao.get(BancoAlimentos.class).iterator();
                    while (i.hasNext()) {
                        b = (BancoAlimentos) i.next();
                        objeto = new JSONObject();
                        objeto.put("id", b.getIdOperacion());
                        objeto.put("mes", b.getMes_anio());
                        objeto.put("titular", b.getTitularUnidad().getNombre() + " " + b.getTitularUnidad().getApellidos());
                        bancos.add(objeto);
                    }
                } catch (Exception exc) {
                    //Para cargar sin errores
                }
                arrayJSON = new JSONArray(bancos);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerDatosBancoAlimentos":
                //PARA MOSTRAR LOS DATOS DE LOS USUARIOS ANTES DE EDITAR
                b = (BancoAlimentos) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), BancoAlimentos.class);
                objeto = new JSONObject();
                objeto.put("id", b.getIdOperacion());
                objeto.put("mes", b.getMes_anio());
                objeto.put("titular", b.getTitularUnidad().getNombre() + " " + b.getTitularUnidad().getApellidos());
                objeto.put("asiste", b.getAsiste());
                //COMPLETAR DATOS DE LAS LISTAS DE FALTAS

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
            case "VerAlumnos":
                alumnos = new ArrayList();
                try {
                    i = gdao.get(Alumno.class).iterator();
                    while (i.hasNext()) {
                        al = (Alumno) i.next();
                        objeto = new JSONObject();
                        objeto.put("id", al.getNumIntId());
                        objeto.put("nombre", al.getPersona());
                        alumnos.add(objeto);
                    }
                } catch (Exception exc) {
                    //Para cargar sin errores
                }
                arrayJSON = new JSONArray(alumnos);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerDatosAlumno":
                //PARA MOSTRAR LOS DATOS DE LOS USUARIOS ANTES DE EDITAR
                al = (Alumno) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Alumno.class);
                objeto = new JSONObject();
                objeto.put("id", al.getNumIntId());
                objeto.put("nombre", al.getPersona());
                objeto.put("empresapracticas", al.getEmpresaPracticas());
                objeto.put("fechaalta", al.getFechaAlta());
                objeto.put("fechabaja", al.getFechaBaja());
                objeto.put("cursoescolar", al.getCursoEscolar());
                objeto.put("aprovechamiento", al.getAprovechamiento());
                objeto.put("promociona", al.getPromociona());
                objeto.put("finaliza", al.getFinaliza());
                //COMPLETAR DATOS DE LAS LISTAS DE FALTAS

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
            case "VerConferencias":
                conferencias = new ArrayList();
                try {
                    i = gdao.get(ConferenciaSantaMaria.class).iterator();
                    while (i.hasNext()) {
                        conf = (ConferenciaSantaMaria) i.next();
                        objeto = new JSONObject();
                        objeto.put("id", conf.getNumIntId());
                        objeto.put("nombre", conf.getNombre() + " " + conf.getApellidos());
                        objeto.put("numeroext", conf.getNumExtId());
                        conferencias.add(objeto);
                    }
                } catch (Exception exc) {
                    //Para cargar sin errores
                }
                arrayJSON = new JSONArray(conferencias);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerDatosConferencia":
                //PARA MOSTRAR LOS DATOS DE LOS USUARIOS ANTES DE EDITAR
                conf = (ConferenciaSantaMaria) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), ConferenciaSantaMaria.class);
                objeto = new JSONObject();
                objeto.put("id", conf.getNumIntId());
                objeto.put("nombre", conf.getNombre());
                objeto.put("apellidos", conf.getApellidos());
                objeto.put("numextid", conf.getNumExtId());
                objeto.put("fechanac", conf.getFechaNac());
                objeto.put("provincia", conf.getProvincia());
                objeto.put("cuota", conf.getCuota());
                objeto.put("usuario", conf.getUsuario());
                objeto.put("fechaalta", conf.getFechaAlta());
                objeto.put("direccion", conf.getDireccion());
                objeto.put("telefono", conf.getTelefono());
                objeto.put("password", conf.getPassword());
                objeto.put("nif", conf.getNif());
                objeto.put("codigopostal", conf.getCodigoPostal());
                objeto.put("mail", conf.getMail());
                objeto.put("actividad", conf.getActividad());
                objeto.put("cargo", conf.getCargo());
                objeto.put("sexo", conf.getSexo());
                objeto.put("poblacion", conf.getPoblacion());
                objeto.put("cuentabancaria", conf.getCuentaBancaria());
                objeto.put("tiempodedicacion", conf.getTiempoDedicacion());
                objeto.put("permisoacceso", conf.getPermisoAcceso());
                objeto.put("accesofichaindividual", conf.getAccesoFichaIndividual());
                objeto.put("categoria", conf.getCategor());
                //COMPLETAR DATOS DE LAS LISTAS DE FICHEROS, OBSERVACIONES, APORTACIONES, PERFILES DE USUARIO Y CATEGORIAS

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
            case "VerObservacionesUsuario":
                u = (Usuario) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Usuario.class);
                observaciones = new ArrayList();
                for (int tam = 0; tam < u.getObservaciones().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobs", u.getObservaciones().get(tam).getTexto());
                    objeto.put("fechaobs", u.getObservaciones().get(tam).getFecha());
                    objeto.put("autorobs", u.getObservaciones().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < u.getObservaciones_sanitarias().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobssanitarias", u.getObservaciones_sanitarias().get(tam).getTexto());
                    objeto.put("fechaobssanitarias", u.getObservaciones_sanitarias().get(tam).getFecha());
                    objeto.put("autorobssanitarias", u.getObservaciones_sanitarias().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < u.getObservaciones_datos_laborales().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobslaborales", u.getObservaciones_datos_laborales().get(tam).getTexto());
                    objeto.put("fechaobslaborales", u.getObservaciones_datos_laborales().get(tam).getFecha());
                    objeto.put("autorobslaborales", u.getObservaciones_datos_laborales().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < u.getObservaciones_formacion().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobsformacion", u.getObservaciones_formacion().get(tam).getTexto());
                    objeto.put("fechaobsformacion", u.getObservaciones_formacion().get(tam).getFecha());
                    objeto.put("autorobsformacion", u.getObservaciones_formacion().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < u.getObservaciones_ingresos().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobsingresos", u.getObservaciones_ingresos().get(tam).getTexto());
                    objeto.put("fechaobsingresos", u.getObservaciones_ingresos().get(tam).getFecha());
                    objeto.put("autorobsingresos", u.getObservaciones_ingresos().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < u.getObservaciones_ficha_convivencia().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobsconvivencia", u.getObservaciones_ficha_convivencia().get(tam).getTexto());
                    objeto.put("fechaobsconvivencia", u.getObservaciones_ficha_convivencia().get(tam).getFecha());
                    objeto.put("autorobsconvivencia", u.getObservaciones_ficha_convivencia().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < u.getObservaciones_orientacion().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobsorientacion", u.getObservaciones_orientacion().get(tam).getTexto());
                    objeto.put("fechaobsorientacion", u.getObservaciones_orientacion().get(tam).getFecha());
                    objeto.put("autorobsorientacion", u.getObservaciones_orientacion().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                arrayJSON = new JSONArray(observaciones);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerObservacionesAlumno":
                al = (Alumno) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Alumno.class);
                observaciones = new ArrayList();
                for (int tam = 0; tam < al.getObservaciones_alumno().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobs", al.getObservaciones_alumno().get(tam).getTexto());
                    objeto.put("fechaobs", al.getObservaciones_alumno().get(tam).getFecha());
                    objeto.put("autorobs", al.getObservaciones_alumno().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                arrayJSON = new JSONArray(observaciones);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerObservacionesBancoAlimentos":
                b = (BancoAlimentos) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), BancoAlimentos.class);
                retorno = new ArrayList();
                for (int tam = 0; tam < b.getObservaciones_id().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobs", b.getObservaciones_id().get(tam).getTexto());
                    objeto.put("fechaobs", b.getObservaciones_id().get(tam).getFecha());
                    objeto.put("autorobs", b.getObservaciones_id().get(tam).getAutor().getUsuario());
                    retorno.add(objeto);
                }

                for (int tam = 0; tam < b.getLista_alimentos().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("nombreAli", b.getLista_alimentos().get(tam).getAlimento());
                    objeto.put("unidadesAli", b.getLista_alimentos().get(tam).getUnidades());
                    retorno.add(objeto);
                }

                arrayJSON = new JSONArray(retorno);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerObservacionesConferencia":
                conf = (ConferenciaSantaMaria) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), ConferenciaSantaMaria.class);
                observaciones = new ArrayList();
                for (int tam = 0; tam < conf.getObservaciones_conferencia().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobs", conf.getObservaciones_conferencia().get(tam).getTexto());
                    objeto.put("fechaobs", conf.getObservaciones_conferencia().get(tam).getFecha());
                    objeto.put("autorobs", conf.getObservaciones_conferencia().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < conf.getFicheros_conferenciasantamaria().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("fichero", conf.getFicheros_conferenciasantamaria().get(tam).getRuta());
                    objeto.put("fecha", conf.getFicheros_conferenciasantamaria().get(tam).getFecha());
                    observaciones.add(objeto);
                }
                arrayJSON = new JSONArray(observaciones);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerObservacionesCurso":
                c = (CursosFormacion) gdao.getById(Integer.parseInt((String) request.getSession().getAttribute("id")), CursosFormacion.class);
                observaciones = new ArrayList();
                for (int tam = 0; tam < c.getObservaciones_cursos_formacion().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobs", c.getObservaciones_cursos_formacion().get(tam).getTexto());
                    objeto.put("fechaobs", c.getObservaciones_cursos_formacion().get(tam).getFecha());
                    objeto.put("autorobs", c.getObservaciones_cursos_formacion().get(tam).getAutor());
                    observaciones.add(objeto);
                }

                for (Usuario alu : c.getLista_solicitantes()) {
                    objeto = new JSONObject();
                    objeto.put("solId", alu.getNumIntId());
                    objeto.put("solNom", alu.getNombre() + " " + alu.getApellidos());
                    observaciones.add(objeto);
                }

                for (Usuario alu : c.getLista_seleccionados()) {
                    objeto = new JSONObject();
                    objeto.put("aluId", alu.getNumIntId());
                    objeto.put("aluNom", alu.getNombre() + " " + alu.getApellidos());
                    observaciones.add(objeto);
                }

                for (Usuario alu : c.getLista_alumnos()) {
                    objeto = new JSONObject();
                    objeto.put("aluId", alu.getNumIntId());
                    objeto.put("solNom", alu.getNombre() + " " + alu.getApellidos());
                    observaciones.add(objeto);
                }
                arrayJSON = new JSONArray(observaciones);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerObservacionesFichaAcogida":
                ac = (Acogida) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Acogida.class);
                observaciones = new ArrayList();
                for (int tam = 0; tam < ac.getObservaciones_acogida().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobs", ac.getObservaciones_acogida().get(tam).getTexto());
                    objeto.put("fechaobs", ac.getObservaciones_acogida().get(tam).getFecha());
                    objeto.put("autorobs", ac.getObservaciones_acogida().get(tam).getAutor().getUsuario());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < ac.getFicheros_acogida().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("fichero", ac.getFicheros_acogida().get(tam).getRuta());
                    objeto.put("fecha", ac.getFicheros_acogida().get(tam).getFecha());
                    observaciones.add(objeto);
                }

                for (int tam = 0; tam < ac.getAyudaSolicitada_General().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("ag", ac.getAyudaSolicitada_General().get(tam).getValor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < ac.getAyudaSolicitada_Otras().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("ao", ac.getAyudaSolicitada_Otras().get(tam).getValor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < ac.getAyudaSolicitada_Recibos().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("ar", ac.getAyudaSolicitada_Recibos().get(tam).getValor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < ac.getAyudaSolicitada_Sanitaria().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("as", ac.getAyudaSolicitada_Sanitaria().get(tam).getValor());
                    observaciones.add(objeto);
                }

                arrayJSON = new JSONArray(observaciones);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerObservacionesFichaAtencionSocialIgualdad":
                asi = (AtencionSocialIgualdad) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), AtencionSocialIgualdad.class);
                observaciones = new ArrayList();
                for (int tam = 0; tam < asi.getObservaciones_atencionsocial_igualdad().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobs", asi.getObservaciones_atencionsocial_igualdad().get(tam).getTexto());
                    objeto.put("fechaobs", asi.getObservaciones_atencionsocial_igualdad().get(tam).getFecha());
                    objeto.put("autorobs", asi.getObservaciones_atencionsocial_igualdad().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < asi.getFicheros_atencionsocial_igualdad().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("fichero", asi.getFicheros_atencionsocial_igualdad().get(tam).getRuta());
                    objeto.put("fecha", asi.getFicheros_atencionsocial_igualdad().get(tam).getFecha());
                    observaciones.add(objeto);
                }
                arrayJSON = new JSONArray(observaciones);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerDesplegables":
                List desplegable = new ArrayList();
                i = gdao.get(Desplegables.class).iterator();
                while (i.hasNext()) {
                    d = (Desplegables) i.next();
                    objeto = new JSONObject();
                    objeto.put("nombre", d.getNombre());

                    desplegable.add(objeto);
                }
                arrayJSON = new JSONArray(desplegable);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;

            case "VerValoresDesplegables":
                valores = new ArrayList<ValorDesplegable>();

                d = (Desplegables) gdao.getById(request.getParameter("nombre"), Desplegables.class);
                Collections.sort(d.getValores());
                i = d.getValores().iterator();
                while (i.hasNext()) {
                    ValorDesplegable v = (ValorDesplegable) i.next();
                    objeto = new JSONObject();
                    objeto.put("nombre", d.getNombre());
                    objeto.put("valor", v.getValor());
                    valores.add(objeto);
                }
                arrayJSON = new JSONArray(valores);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerTiposCarnet":
                u = (Usuario) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Usuario.class);
                i = u.getOtros_carnets().iterator();
                valores = new ArrayList();
                while (i.hasNext()) {
                    ValorDesplegable v = (ValorDesplegable) i.next();
                    objeto = new JSONObject();
                    objeto.put("tipocarnet", v.getValor());
                    valores.add(objeto);
                }
                arrayJSON = new JSONArray(valores);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerBolsaTrabajo":
                u = (Usuario) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Usuario.class);
                i = u.getBolsa_trabajo().iterator();
                valores = new ArrayList();
                while (i.hasNext()) {
                    ValorDesplegable v = (ValorDesplegable) i.next();
                    objeto = new JSONObject();
                    objeto.put("bolsatrabajo", v.getValor());
                    valores.add(objeto);
                }
                arrayJSON = new JSONArray(valores);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "VerListasEmpresa":
                e = (Empresa) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Empresa.class);
                i = e.getLista_actividades().iterator();
                valores = new ArrayList();
                while (i.hasNext()) {
                    ValorDesplegable v = (ValorDesplegable) i.next();
                    objeto = new JSONObject();
                    objeto.put("actividad", v.getValor());
                    valores.add(objeto);
                }
                i = e.getLista_colaboraciones().iterator();
                while (i.hasNext()) {
                    ValorDesplegable v = (ValorDesplegable) i.next();
                    objeto = new JSONObject();
                    objeto.put("colaboracion", v.getValor());
                    valores.add(objeto);
                }
                arrayJSON = new JSONArray(valores);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "addValoresDesplegables":
                d = (Desplegables) gdao.getById(request.getParameter("nombre"), Desplegables.class);
                d.getValores().add(new ValorDesplegable(request.getParameter("valor")));
                Collections.sort(d.getValores());
                gdao.insertOrUpdate(d);

                break;

            case "delValoresDesplegables":
                String val = request.getParameter("nombreD");
                String[] valoresD = val.split("-");

                d = (Desplegables) gdao.getById(valoresD[0], Desplegables.class);

                i = d.getValores().iterator();
                while (i.hasNext()) {
                    ValorDesplegable v = (ValorDesplegable) i.next();
                    if (v.getValor().equals(valoresD[1])) {
                        d.getValores().remove(v);
                        gdao.delete(v);
                        break;
                    }
                }

                gdao.insertOrUpdate(d);

                break;

            case "delDValoresDesplegables":

                d = (Desplegables) gdao.getById(request.getParameter("nombreD"), Desplegables.class);

                gdao.delete(d);

                break;

            /*case "VisualizarAlimentos":
                List l = ldao.OrderList();
                System.out.println(l.toString());
                i = l.iterator();
                valores = new ArrayList();                    
                    while (i.hasNext()) {
                        String nombreAlimentos = (String) i.next();
                        objeto = new JSONObject();
                        objeto.put("nombre", nombreAlimentos);
                        valores.add(objeto);
                    }
                arrayJSON = new JSONArray(valores);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                
                break;*/
            case "verProfesores":

                i = gdao.get(Perfil.class).iterator();
                valores = new ArrayList();
                while (i.hasNext()) {
                    p = (Perfil) i.next();
                    if (p.getTipo().equals(TipoPerfil.PROFESOR)) {
                        objeto = new JSONObject();
                        objeto.put("Nombre", p.getUsuario());
                        valores.add(objeto);
                    }
                }
                arrayJSON = new JSONArray(valores);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;

            case "verAlumnos":

                i = gdao.get(Usuario.class).iterator();
                valores = new ArrayList();
                while (i.hasNext()) {
                    u = (Usuario) i.next();
                    objeto = new JSONObject();
                    objeto.put("nombre", u.getNombre());
                    objeto.put("apellido", u.getApellidos());
                    objeto.put("centro", u.getCentroEst());
                    objeto.put("nivel", u.getNivelEstudios());
                    valores.add(objeto);
                }
                arrayJSON = new JSONArray(valores);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);

                break;
            case "usuariosProyecto":
                i = gdao.get(Usuario.class).iterator();
                valores = new ArrayList();
                while (i.hasNext()) {
                    u = (Usuario) i.next();
                    objeto = new JSONObject();
                    objeto.put("nombre", u.getNombre() + " " + u.getApellidos());
                    objeto.put("id", u.getNumIntId());
                    valores.add(objeto);
                }
                arrayJSON = new JSONArray(valores);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);

                break;

            case "usuariosProyectoadd":

                u = (Usuario) gdao.getById(Integer.parseInt(request.getParameter("id")), Usuario.class);

                objeto = new JSONObject();
                objeto.put("nombre", u.getNombre() + " " + u.getApellidos());
                objeto.put("id", u.getNumIntId());
                objeto.put("numDoc", u.getNumDoc());

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;

            case "adddAula":
                AulaMagica aula = new AulaMagica();

                //request.getParameter("denom")
                //request.getParameter("profe")
                System.out.println(request.getParameter("alumnos"));
                String alumnosAMPara = request.getParameter("alumnos");
                String[] alumnosAM = alumnosAMPara.split(";");
                alumnos = new ArrayList<Alumno>();
                for (String alumno : alumnosAM) {

                    String[] datos = alumno.split("-");
                    Alumno alu = new Alumno();
                    alu.setPersona(datos[0] + " " + datos[1]);
                    alu.setCursoEscolar(datos[2]);
                    alu.setColegio(datos[3]);

                    gdao.insertOrUpdate(alu);
                    alumnos.add(alu);
                }
                gdao.insertOrUpdate(new AulaMagica(request.getParameter("denom"), request.getParameter("profe"), alumnos));

                break;

            case "addAlimentos":
                BancoAlimentos banco = new BancoAlimentos();

                String[] alimentos;
                String[] ValoresAlimentos;

                List<Alimentos> alimen = new ArrayList();

                banco.setTitularUnidad((Usuario) gdao.getById(Integer.parseInt(request.getParameter("TitularUnidad")), Usuario.class));
                banco.setMes_anio(request.getParameter("Mes_anio"));
                System.out.println(request.getParameter("Asiste"));
                if (request.getParameter("Asiste").equals("true")) {
                    banco.setAsiste(true);
                } else {
                    banco.setAsiste(false);
                }

                alimentos = request.getParameter("lista_alimentos").split(";");
                ValoresAlimentos = request.getParameter("lista_alimentos_valores").split(";");

                for (int j = 0; j < alimentos.length; j++) {
                    Alimentos aux = new Alimentos(alimentos[j], Integer.parseInt(ValoresAlimentos[j]));
                    alimen.add(aux);
                }

                banco.setLista_alimentos(alimen);

                Observaciones obsB = new Observaciones(request.getParameter("observaciones"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class));

                observaciones = new ArrayList();
                observaciones.add(obsB);

                banco.setObservaciones_id(observaciones);

                gdao.insertOrUpdate(banco);
                break;

            case "addProyecto":

                String identif = request.getParameter("ids");
                String fechasAjax = request.getParameter("fechas");
                Proyecto pro = new Proyecto();

                pro.setNombre(request.getParameter("nombre"));
                pro.setAccion(request.getParameter("actualizacion"));

                String[] ids = identif.split(";");
                String[] fechas = fechasAjax.split(";");

                List<Usuario> listadoU = new ArrayList<Usuario>();
                List<UsuXFecha> listadoF = new ArrayList<UsuXFecha>();

                UsuXFecha f;
                for (int j = 0; j < ids.length; j++) {
                    f = new UsuXFecha();

                    u = new Usuario();
                    u = (Usuario) gdao.getById(Integer.parseInt(ids[j]), Usuario.class);
                    listadoU.add(u);

                    f.setUsuario(u);
                    f.setFecha(fechas[j]);
                    listadoF.add(f);
                }

                pro.setListaUsuarios(listadoU);
                pro.setListaFechas(listadoF);

                gdao.insertOrUpdate(pro);

                break;

            case "CursosFormacionAdd":

                List<Usuario> solicitantes = new ArrayList<>();
                List<Usuario> seleccionados = new ArrayList<>();
                alumnos = new ArrayList<>();
                observaciones = new ArrayList();

                c = new CursosFormacion();

                String[] sol = request.getParameter("LSol").split(";");
                String[] sel = request.getParameter("LSel").split(";");
                String[] alu = request.getParameter("LAlu").split(";");
                Observaciones ob = new Observaciones();

                for (String id : sol) {
                    solicitantes.add((Usuario) gdao.getById(Integer.parseInt(id), Usuario.class));
                }
                for (String id : sel) {
                    seleccionados.add((Usuario) gdao.getById(Integer.parseInt(id), Usuario.class));
                }
                for (String id : alu) {
                    alumnos.add((Usuario) gdao.getById(Integer.parseInt(id), Usuario.class));
                }

                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");
                Date fecha = new Date();

                ob.setTexto(request.getParameter("obs"));
                ob.setFecha(df.format(fecha));
                observaciones.add(ob);

                c = new CursosFormacion(request.getParameter("nombre"), request.getParameter("tipo"), request.getParameter("Fini"), request.getParameter("Ffin"), request.getParameter("otra"), solicitantes, seleccionados, alumnos, observaciones);

                gdao.insertOrUpdate(c);
                break;

            case "addAcogida":
                ac = new Acogida();
                ac.setFecha(request.getParameter("fecha"));
                ac.setTecnicoPrevencionSocial(request.getParameter("its"));

                p = new Perfil();
                p = (Perfil) gdao.getById(Integer.parseInt(request.getSession().getAttribute("idAutor").toString()), Perfil.class);
                ac.setTrabajador(p);

                List<ValorDesplegable> ag = new ArrayList<>();
                List<ValorDesplegable> ao = new ArrayList<>();
                List<ValorDesplegable> ar = new ArrayList<>();
                List<ValorDesplegable> ass = new ArrayList<>();
                obs = new ArrayList<>();

                if (!request.getParameter("obs").equals("") && !request.getParameter("obs").equals(null)) {
                    Observaciones o = new Observaciones(request.getParameter("obs"), p);
                    o.setAutor(p);
                    obs.add(o);
                }

                u = new Usuario();
                ac.setUsuario((Usuario) gdao.getById(Integer.parseInt(request.getParameter("usuario")), Usuario.class));
                //(ValorDesplegable) gdao.getById(request.getParameter("pd"), ValorDesplegable.class)

                if (!request.getParameter("ag").equals("") && !request.getParameter("ag").equals(null)) {
                    ag.add((ValorDesplegable) gdao.getById(Integer.parseInt(request.getParameter("ag")), ValorDesplegable.class));
                }
                if (!request.getParameter("oa").equals("") && !request.getParameter("oa").equals(null)) {
                    ao.add((ValorDesplegable) gdao.getById(Integer.parseInt(request.getParameter("oa")), ValorDesplegable.class));
                }
                if (!request.getParameter("ar").equals("") && !request.getParameter("ar").equals(null)) {
                    ar.add((ValorDesplegable) gdao.getById(Integer.parseInt(request.getParameter("ar")), ValorDesplegable.class));
                }
                if (!request.getParameter("aas").equals("") && !request.getParameter("aas").equals(null)) {
                    ass.add((ValorDesplegable) gdao.getById(Integer.parseInt(request.getParameter("ass")), ValorDesplegable.class));
                }

                ac.setAyudaSolicitada_General(ag);
                ac.setAyudaSolicitada_Otras(ao);
                ac.setAyudaSolicitada_Recibos(ar);
                ac.setAyudaSolicitada_Sanitaria(ass);

                ac.setObservaciones_acogida(obs);

                ac.setEstadoResolucion((ValorDesplegable) gdao.getById(Integer.parseInt(request.getParameter("er")), ValorDesplegable.class));

                ac.setProcedenciaDerivacion((ValorDesplegable) gdao.getById(Integer.parseInt(request.getParameter("pd")), ValorDesplegable.class));

                gdao.insertOrUpdate(ac);
                break;

            case "DatosEstadisticos":
                valores = new ArrayList();
                d = new Desplegables();
                List des = gdao.get(Desplegables.class);

                i = des.iterator();

                while (i.hasNext()) {
                    d = (Desplegables) i.next();
                    if (d.getNombre().equals("Colectivos")) {
                        break;
                    }
                }

                i = d.getValores().iterator();

                while (i.hasNext()) {
                    ValorDesplegable v = (ValorDesplegable) i.next();
                    objeto = new JSONObject();
                    objeto.put("value", v.getValor());
                    valores.add(objeto);
                }
                arrayJSON = new JSONArray(valores);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);

                break;

            case "addFicha":

                AtencionSocialIgualdad atencionS = new AtencionSocialIgualdad();
                obs = new ArrayList<>();

                ValorDesplegable valor;
                u = (Usuario) gdao.getById(Integer.parseInt(request.getParameter("usuario")), Usuario.class);
                p = (Perfil) gdao.getById(Integer.parseInt(request.getSession().getAttribute("idAutor").toString()), Perfil.class);

                atencionS.setUsuario(u);
                atencionS.setFecha(request.getParameter("fecha"));
                atencionS.setTrabajador(p);

                valor = (ValorDesplegable) gdao.getById(Integer.parseInt(request.getParameter("procedenciaDerivacion")), ValorDesplegable.class);
                atencionS.setProcedenciaDerivacion(valor.getValor());

                valor = (ValorDesplegable) gdao.getById(Integer.parseInt(request.getParameter("motivoConsulta")), ValorDesplegable.class);
                atencionS.setMotivoConsulta(valor.getValor());

                valor = (ValorDesplegable) gdao.getById(Integer.parseInt(request.getParameter("intervencion")), ValorDesplegable.class);
                atencionS.setIntervencion(valor.getValor());

                valor = (ValorDesplegable) gdao.getById(Integer.parseInt(request.getParameter("estadoResolucion")), ValorDesplegable.class);
                atencionS.setEstadoResolucion(valor.getValor());

                if (!request.getParameter("Observaciones").equals("") && !request.getParameter("Observaciones").equals(null)) {
                    Observaciones o = new Observaciones(request.getParameter("Observaciones"), p);
                    o.setAutor(p);
                    obs.add(o);
                }
                atencionS.setObservaciones_atencionsocial_igualdad(obs);

                gdao.insertOrUpdate(atencionS);

                break;

            case "addUser":

                u = (Usuario) gdao.getById(Integer.parseInt(request.getParameter("id")), Usuario.class);

                objeto = new JSONObject();
                objeto.put("nombre", u.getNombre() + " " + u.getApellidos());
                objeto.put("id", u.getNumIntId());

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
