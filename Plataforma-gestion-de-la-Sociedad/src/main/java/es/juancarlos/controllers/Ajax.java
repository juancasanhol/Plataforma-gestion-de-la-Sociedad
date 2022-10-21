package es.juancarlos.controllers;

import es.juancarlos.beans.Acogida;
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
import es.juancarlos.beans.Usuario;
import es.juancarlos.beans.ValorDesplegable;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IAjaxDAO;
import es.juancarlos.interfaces.IGenericoDAO;
import java.io.IOException;
import java.util.ArrayList;
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
        List desplegables, cursos, aulas, empresas, acogidas, atenciones, alumnos, conferencias, bancos, observaciones, valores;
        BancoAlimentos b;
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

                objeto = new JSONObject();
                objeto.put("aceso", adao.Login(request.getParameter("usuario"), request.getParameter("passwd")));

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                //Para obtener el autor de las observaciones
                request.getSession().setAttribute("autor", request.getParameter("usuario"));
                break;

            case "addPerfil":
                gdao.insertOrUpdate(new Perfil(request.getParameter("usuario"), request.getParameter("passwd")));

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
                            objeto.put("tipodocumento", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Sexo")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("sexo", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("PaisOrigen")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("paisorigen", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Nacionalidad")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("nacionalidad", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("MinoriaEtnica")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
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
                            objeto.put("nombreBolsa", lista.get(j).getValor());
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
            case "AulaMagica":
                desplegables = new ArrayList();
                it = gdao.get(Desplegables.class).iterator();
                while (it.hasNext()) {
                    d = (Desplegables) it.next();
                    if (d.getNombre().equals("Profesores")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("profesores", lista.get(j).getValor());
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
                objeto.put("perteneceminoria", u.getPerteneceMinoria());
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
                objeto.put("importe", u.getImporte());
                objeto.put("origeningresos", u.getOrigenIngresos());
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
                    objeto.put("solicitante", (u.getNombre() + " " + u.getApellidos()).replaceAll(" ", "_"));
                    objeto.put("seleccionado", (u.getNombre() + " " + u.getApellidos()).replaceAll(" ", "_"));
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
                    objeto.put("alumno", am.getLista_alumnos().get(tam).getValor().replaceAll(" ", "_"));
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
                            objeto.put("actividad", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("TiposColaboracion")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
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
                            objeto.put("procedenciaderivacion", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("AyudaGeneral")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("ayudageneral", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("AyudaRecibos")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("ayudarecibos", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("AyudaAsistenciaSanitaria")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("ayudasanitaria", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("OtrasAyudas")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("ayudaotra", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("EstadoResolucion")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
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
                            objeto.put("procedenciaderivacion", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Intervencion")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("intervencion", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("MotivoConsulta")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            objeto.put("motivoconsulta", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("EstadoResolucion")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
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
                            objeto.put("actividad", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Categoria")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("categoria", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Cargo")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("cargo", lista.get(j).getValor());
                            desplegables.add(objeto);
                        }
                    }
                    if (d.getNombre().equals("Sexo")) {
                        List<ValorDesplegable> lista = d.getValores();
                        for (int j = 0; j < lista.size(); j++) {
                            objeto = new JSONObject();
                            //Se coge cada campo del desplegable para pasarlo
                            objeto.put("sexo", lista.get(j).getValor());
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
                List usuarios = new ArrayList();
                try {
                    i = gdao.get(Usuario.class).iterator();
                    while (i.hasNext()) {
                        u = (Usuario) i.next();
                        objeto = new JSONObject();
                        objeto.put("id", u.getNumIntId());
                        objeto.put("nombre", u.getNombre());
                        objeto.put("apellidos", u.getApellidos());
                        usuarios.add(objeto);
                    }
                } catch (Exception exc) {
                    //Para cargar los desplegables sin errores
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
                a = (AulaMagica) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), AulaMagica.class);
                objeto = new JSONObject();
                objeto.put("id", a.getNumIntId());
                objeto.put("denominacion", a.getDenominacion());
                objeto.put("profesor", a.getProfesor());
                //COMPLETAR DATOS DE LISTAS AQUI

                //log("EL BOOLEAN SE VE ASI: "+u.getPerteneceMinoria());
                response.setContentType("application/json");
                response.getWriter().print(objeto);
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
                        objeto.put("localidad", e.getPoblacion());
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
                objeto.put("poblacion", e.getPoblacion());
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
                objeto.put("estadoresolucion", ac.getEstadoResolucion());
                objeto.put("trabajador", ac.getTrabajador());
                objeto.put("usuario", ac.getUsuario());
                objeto.put("procedenciaderivacion", ac.getProcedenciaDerivacion());
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
                        objeto.put("nombre", asi.getUsuario());
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
                objeto.put("trabajador", asi.getTrabajador());
                objeto.put("usuario", asi.getUsuario());
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
                        objeto.put("titular", b.getTitularUnidad());
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
                objeto.put("titular", b.getTitularUnidad());
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
                for (int tam = 0; tam < u.getObservaciones_id().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobs", u.getObservaciones_id().get(tam).getTexto());
                    objeto.put("fechaobs", u.getObservaciones_id().get(tam).getFecha());
                    objeto.put("autorobs", u.getObservaciones_id().get(tam).getAutor());
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
                observaciones = new ArrayList();
                for (int tam = 0; tam < b.getObservaciones_id().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobs", b.getObservaciones_id().get(tam).getTexto());
                    objeto.put("fechaobs", b.getObservaciones_id().get(tam).getFecha());
                    objeto.put("autorobs", b.getObservaciones_id().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                arrayJSON = new JSONArray(observaciones);
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
                c = (CursosFormacion) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), CursosFormacion.class);
                observaciones = new ArrayList();
                for (int tam = 0; tam < c.getObservaciones_cursos_formacion().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("textoobs", c.getObservaciones_cursos_formacion().get(tam).getTexto());
                    objeto.put("fechaobs", c.getObservaciones_cursos_formacion().get(tam).getFecha());
                    objeto.put("autorobs", c.getObservaciones_cursos_formacion().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                //Apovecho esta parte para mostrar los alumnos
                for (int tam = 0; tam < c.getLista_alumnos().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("alumno", c.getLista_alumnos().get(tam).getValor());
                    observaciones.add(objeto);
                }
                //Seleccionados
                for (int tam = 0; tam < c.getLista_aseleccionados().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("seleccionado", c.getLista_aseleccionados().get(tam).getValor());
                    observaciones.add(objeto);
                }
                //Solicitantes
                for (int tam = 0; tam < c.getLista_solicitantes().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("solicitante", c.getLista_solicitantes().get(tam).getValor());
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
                    objeto.put("autorobs", ac.getObservaciones_acogida().get(tam).getAutor());
                    observaciones.add(objeto);
                }
                for (int tam = 0; tam < ac.getFicheros_acogida().size(); tam++) {
                    objeto = new JSONObject();
                    objeto.put("fichero", ac.getFicheros_acogida().get(tam).getRuta());
                    objeto.put("fecha", ac.getFicheros_acogida().get(tam).getFecha());
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
                valores = new ArrayList();

                d = (Desplegables) gdao.getById(request.getParameter("nombre"), Desplegables.class);
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
                
            case "VisualizarAlimentos":
                d = (Desplegables) gdao.getById("Alimento", Desplegables.class);
                i = d.getValores().iterator();
                valores = new ArrayList();                    
                    while (i.hasNext()) {
                        ValorDesplegable v = (ValorDesplegable) i.next();
                        objeto = new JSONObject();
                        objeto.put("alimento", v.getValor());
                        valores.add(objeto);
                    }
                arrayJSON = new JSONArray(valores);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                
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
