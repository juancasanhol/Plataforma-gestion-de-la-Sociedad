package es.juancarlos.controllers;

import es.juancarlos.beans.Desplegables;
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
        Iterator i, it;
        Desplegables d;
        List desplegables;
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
                it = gdao.get(Usuario.class).iterator();
                while (it.hasNext()) {
                    u = (Usuario) it.next();
                    objeto = new JSONObject();
                    objeto.put("usuarios", u.getNombre() + " " + u.getApellidos());
                    desplegables.add(objeto);

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
                u = (Usuario) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()),Usuario.class);
                objeto = new JSONObject();
                objeto.put("id", u.getNumIntId());
                objeto.put("nombre", u.getNombre());
                objeto.put("apellidos", u.getApellidos());
                objeto.put("fechaalta",u.getFechaAlta());
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
                it = gdao.get(Usuario.class).iterator();
                while (it.hasNext()) {
                    u = (Usuario) it.next();
                    objeto = new JSONObject();
                    objeto.put("usuarios", u.getNombre() + " " + u.getApellidos());
                    desplegables.add(objeto);

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
                case "AtencionSocialIgualdad":
                //Primero se hace el desplegable para los usuarios y luego los demas
                desplegables = new ArrayList();
                it = gdao.get(Usuario.class).iterator();
                while (it.hasNext()) {
                    u = (Usuario) it.next();
                    objeto = new JSONObject();
                    objeto.put("usuarios", u.getNombre() + " " + u.getApellidos());
                    desplegables.add(objeto);

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
            case "VerUsuarios":
                List usuarios = new ArrayList();
                i = gdao.get(Usuario.class).iterator();
                while (i.hasNext()) {
                    u = (Usuario) i.next();
                    objeto = new JSONObject();
                    objeto.put("id", u.getNumIntId());
                    objeto.put("nombre", u.getNombre());
                    objeto.put("apellidos", u.getApellidos());
                    usuarios.add(objeto);
                }
                arrayJSON = new JSONArray(usuarios);
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
                List valores = new ArrayList();

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
