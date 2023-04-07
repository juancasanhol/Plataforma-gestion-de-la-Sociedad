package es.juancarlos.controllers;

import es.juancarlos.beans.BancoAlimentos;
import es.juancarlos.beans.FicheroAdjunto;
import es.juancarlos.beans.Observaciones;
import es.juancarlos.beans.Perfil;
import es.juancarlos.beans.Usuario;
import es.juancarlos.beans.ValorDesplegable;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.models.GuardarFicheros;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig
@WebServlet(name = "RegistroUsuario", urlPatterns = {"/RegistroUsuario"})
public class RegistroUsuario extends HttpServlet {

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
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
        Usuario u = new Usuario();

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        Observaciones obsB = null;
        List<Observaciones> Lobs = new ArrayList<>();
        //todos aquellos campos de request que coincidan con el nombre de las variables del bean se insertaran
        if (request.getParameter("accion").equals("primeraVez")) {
           
            Boolean minoria = false, ayudafarmaceutica = false, drogodependencia = false, permisoresidencia = false, permisotrabajo = false, carnetconducir = false, estaestudiando = false, fracasoescolar = false, familiamonoparental = false, sinhogar = false, estabanco = false;
            if (request.getParameter("PerteneceMinoria") != null) {
                minoria = true;
            }
            if (request.getParameter("SolicitaAyudaFarmaceutica") != null) {
                ayudafarmaceutica = true;
            }
            if (request.getParameter("Drogodependencia") != null) {
                drogodependencia = true;
            }
            if (request.getParameter("PermisoResidencia") != null) {
                permisoresidencia = true;
            }
            if (request.getParameter("PermisoTrabajo") != null) {
                permisotrabajo = true;
            }
            if (request.getParameter("CarnetConducir") != null) {
                carnetconducir = true;
            }
            if (request.getParameter("EstaEstudiando") != null) {
                estaestudiando = true;
            }
            if (request.getParameter("FracasoEscolar") != null) {
                fracasoescolar = true;
            }
            if (request.getParameter("FamiliaMonoparental") != null) {
                familiamonoparental = true;
            }
            if (request.getParameter("SinHogar") != null) {
                sinhogar = true;
            }
            if (request.getParameter("EstaBanco") != null) {
                estabanco = true;
            }
            float importe, costevivienda;
            try {
                importe = Float.parseFloat(request.getParameter("Importe"));
            } catch (Exception e) {
                importe = 0;
            }
            try {
                costevivienda = Float.parseFloat(request.getParameter("CosteVivienda"));
            } catch (Exception e) {
                costevivienda = 0;
            }

            Perfil p = (Perfil) gdao.getById(Integer.parseInt(request.getSession().getAttribute("idAutor").toString()), Perfil.class);
            //Se cogen los datos de las nuevas observaciones para añadirlas
            if (!request.getParameter("Observaciones").equals("")) {
                Observaciones observacion = new Observaciones(request.getParameter("Observaciones"), p);
                u.getObservaciones().add(observacion);
            }
            if (request.getParameter("ObservacionesSanitarias") != null && !request.getParameter("ObservacionesSanitarias").equals("")) {
                Observaciones observacionsanitaria = new Observaciones(request.getParameter("ObservacionesSanitarias"), p);
                u.getObservaciones_sanitarias().add(observacionsanitaria);
            }
            if (request.getParameter("ObservacionesLaborales") != null && !request.getParameter("ObservacionesLaborales").equals("")) {
                Observaciones observacionlaboral = new Observaciones(request.getParameter("ObservacionesLaborales"), p);
                u.getObservaciones_datos_laborales().add(observacionlaboral);
            }
            if (request.getParameter("ObservacionesFormacion") != null && !request.getParameter("ObservacionesFormacion").equals("")) {
                Observaciones observacionformacion = new Observaciones(request.getParameter("ObservacionesFormacion"), p);
                u.getObservaciones_formacion().add(observacionformacion);
            }
            if (request.getParameter("ObservacionesIngresos") != null && !request.getParameter("ObservacionesIngresos").equals("")) {
                Observaciones observacioningresos = new Observaciones(request.getParameter("ObservacionesIngresos"), p);
                u.getObservaciones_ingresos().add(observacioningresos);
            }
            if (request.getParameter("ObservacionesConvivencia") != null && !request.getParameter("ObservacionesConvivencia").equals("")) {
                Observaciones observacionconvivencia = new Observaciones(request.getParameter("ObservacionesConvivencia"), p);
                u.getObservaciones_ficha_convivencia().add(observacionconvivencia);
            }
            if (request.getParameter("ObservacionesOrientacion") != null && !request.getParameter("ObservacionesOrientacion").equals("")) {
                Observaciones observacionorientacion = new Observaciones(request.getParameter("ObservacionesOrientacion"), p);
                u.getObservaciones_orientacion().add(observacionorientacion);
            }
            //Se añade el fichero adjunto a los que ya hay
            List<FicheroAdjunto> ficheros = u.getFicheros_usuario();
            try {
                FicheroAdjunto f = new FicheroAdjunto(GuardarFicheros.GuardarFichero(request, getServletContext().getRealPath(getServletContext().getInitParameter("rutaFicheros")), "Fichero", request.getParameter("Nombre") + "_" + request.getParameter("Apellidos")), false);
                ficheros.add(f);
            } catch (Exception e) {
                //No hay fichero para hacer el submit
                //He usado try catch porque para comprobar si hay fichero o no no sirve con comaprar el campo a null
            }

            List<ValorDesplegable> listacarnets = new ArrayList<ValorDesplegable>();
            List<ValorDesplegable> bolsatrabajo = new ArrayList<ValorDesplegable>();
            List<BancoAlimentos> listarecogidas = new ArrayList<BancoAlimentos>();
            String[] carnets = request.getParameterValues("DesplegablesTipoCarnetConducir");
            String[] trabajos = request.getParameterValues("DesplegablesBolsaTrabajo");
            String[] recogidas = request.getParameterValues("DesplegablesListaRecogidas");
            if (carnets != null) {
                for (int i = 0; i < carnets.length; i++) {
                    listacarnets.add(new ValorDesplegable(carnets[i]));
                }
            }
            if (trabajos != null) {
                for (int i = 0; i < trabajos.length; i++) {
                    bolsatrabajo.add(new ValorDesplegable(trabajos[i]));
                }
            }
            /*for(int i=0;i<recogidas.length;i++){
            listarecogidas.add(new ValorDesplegable(recogidas[i]));
        }*/
            u.setNombre(request.getParameter("Nombre"));
            if (request.getParameter("Localidad") != null && !request.getParameter("Localidad").equals("")) {
                u.setLocalidad(request.getParameter("Localidad"));
            }
            u.setCorreo(request.getParameter("Correo"));
            u.setApellidos(request.getParameter("Apellidos"));
            u.setDireccion(request.getParameter("Domicilio"));
            u.setTelefono(request.getParameter("Contacto") + " -- " + request.getParameter("Movil"));
            u.setNumDoc(request.getParameter("NumDoc"));
            u.setFechaNac(request.getParameter("FechaNac"));

            gdao.insertOrUpdate(u);
            response.sendRedirect("./html/MenuPrincipal/Menu.html");
        } else {
            if (request.getParameter("id") != null && !request.getParameter("id").equals("") && Usuario.isNumeric(request.getParameter("id"))) {
                u.setNumIntId(Integer.parseInt(request.getParameter("id")));
            }
            u.Cargar(request.getParameterMap());

            if (!request.getParameter("Observaciones").equals("") || !request.getParameter("Observaciones").equals(null)) {
                Lobs = new ArrayList<>();
                Lobs.add(new Observaciones(request.getParameter("Observaciones"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
                u.setObservaciones(Lobs);
            }

            if (!request.getParameter("ObservacionesSanitarias").equals("") || !request.getParameter("ObservacionesSanitarias").equals(null)) {
                Lobs = new ArrayList<>();
                Lobs.add(new Observaciones(request.getParameter("ObservacionesSanitarias"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
                u.setObservaciones_sanitarias(Lobs);
            }

            if (!request.getParameter("ObservacionesLaborales").equals("") || !request.getParameter("ObservacionesLaborales").equals(null)) {
                Lobs = new ArrayList<>();
                Lobs.add(new Observaciones(request.getParameter("ObservacionesLaborales"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
                u.setObservaciones_sanitarias(Lobs);
            }

            if (!request.getParameter("ObservacionesFormacion").equals("") || !request.getParameter("ObservacionesFormacion").equals(null)) {
                Lobs = new ArrayList<>();
                Lobs.add(new Observaciones(request.getParameter("ObservacionesFormacion"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
                u.setObservaciones_sanitarias(Lobs);
            }

            if (!request.getParameter("ObservacionesIngresos").equals("") || !request.getParameter("ObservacionesIngresos").equals(null)) {
                Lobs = new ArrayList<>();
                Lobs.add(new Observaciones(request.getParameter("ObservacionesIngresos"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
                u.setObservaciones_sanitarias(Lobs);
            }

            if (!request.getParameter("ObservacionesConvivencia").equals("") || !request.getParameter("ObservacionesConvivencia").equals(null)) {
                Lobs = new ArrayList<>();
                Lobs.add(new Observaciones(request.getParameter("ObservacionesConvivencia"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
                u.setObservaciones_sanitarias(Lobs);
            }

            if (!request.getParameter("ObservacionesOrientacion").equals("") || !request.getParameter("ObservacionesOrientacion").equals(null)) {
                Lobs = new ArrayList<>();
                Lobs.add(new Observaciones(request.getParameter("ObservacionesOrientacion"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
                u.setObservaciones_sanitarias(Lobs);
            }

            gdao.insertOrUpdate(u);
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
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
