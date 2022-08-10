package es.juancarlos.controllers;

import es.juancarlos.beans.FicheroAdjunto;
import es.juancarlos.beans.Observaciones;
import es.juancarlos.beans.Usuario;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.models.GuardarFicheros;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
@WebServlet(name = "GuardarCambiosUsuario", urlPatterns = {"/GuardarCambiosUsuario"})
public class GuardarCambiosUsuario extends HttpServlet {

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
        int id = Integer.parseInt(request.getSession().getAttribute("id").toString());
        Usuario u = (Usuario) gdao.getById(id, Usuario.class);
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
        //Se cogen los datos de las nuevas observaciones para añadirlas
        if(!request.getParameter("Observaciones").equals("")){
            Observaciones observacion = new Observaciones(request.getParameter("Observaciones"), request.getSession().getAttribute("autor").toString());
            u.getObservaciones_id().add(observacion);
        }
        if(!request.getParameter("ObservacionesSanitarias").equals("")){
            Observaciones observacionsanitaria = new Observaciones(request.getParameter("ObservacionesSanitarias"), request.getSession().getAttribute("autor").toString());
            u.getObservaciones_sanitarias().add(observacionsanitaria);
        }
        if(!request.getParameter("ObservacionesLaborales").equals("")){
            Observaciones observacionlaboral = new Observaciones(request.getParameter("ObservacionesLaborales"), request.getSession().getAttribute("autor").toString());
            u.getObservaciones_datos_laborales().add(observacionlaboral);
        }
        if(!request.getParameter("ObservacionesFormacion").equals("")){
            Observaciones observacionformacion = new Observaciones(request.getParameter("ObservacionesFormacion"), request.getSession().getAttribute("autor").toString());
             u.getObservaciones_formacion().add(observacionformacion);
        }
        if(!request.getParameter("ObservacionesIngresos").equals("")){
            Observaciones observacioningresos = new Observaciones(request.getParameter("ObservacionesIngresos"), request.getSession().getAttribute("autor").toString());
            u.getObservaciones_ingresos().add(observacioningresos);
        }
        if(!request.getParameter("ObservacionesConvivencia").equals("")){
            Observaciones observacionconvivencia = new Observaciones(request.getParameter("ObservacionesConvivencia"), request.getSession().getAttribute("autor").toString());
            u.getObservaciones_ficha_convivencia().add(observacionconvivencia);
        }
        if(!request.getParameter("ObservacionesOrientacion").equals("")){
            Observaciones observacionorientacion = new Observaciones(request.getParameter("ObservacionesOrientacion"), request.getSession().getAttribute("autor").toString());
            u.getObservaciones_orientacion().add(observacionorientacion);
        }

        gdao.insertOrUpdate(new Usuario(id, request.getParameter("Nombre"), request.getParameter("Apellidos"), request.getParameter("FechaAlta"), request.getParameter("FechaBaja"), request.getParameter("TipoDoc"), request.getParameter("NumDoc"), request.getParameter("Telefono"), request.getParameter("Correo"), request.getParameter("PersonaReferencia"), request.getParameter("Sexo"), request.getParameter("FechaNac"), request.getParameter("PaisOrigen"), request.getParameter("Nacionalidad"), minoria, request.getParameter("Minoria"), u.getObservaciones_id(), u.getFicheros_usuario(), ayudafarmaceutica, request.getParameter("TratSanitario"), drogodependencia, request.getParameter("TipoDiscapacidad"), request.getParameter("GradoDiscapacidad"), u.getObservaciones_sanitarias(), permisoresidencia, permisotrabajo, carnetconducir, request.getParameter("TipoCarnetConducir"), u.getOtros_carnets(), u.getProfesion_observaciones(), request.getParameter("SituacionLaboral"), request.getParameter("UltTrabajo"), request.getParameter("PrefLaboral"), u.getBolsa_trabajo(), u.getObservaciones_datos_laborales(), request.getParameter("NivelEstudios"), request.getParameter("FormacionComp"), estaestudiando, fracasoescolar, request.getParameter("CentroEst"), u.getObservaciones_formacion(), importe, request.getParameter("OrigenIngresos"), u.getObservaciones_ingresos(), request.getParameter("Denominacion"), request.getParameter("Direccion"), request.getParameter("Localidad"), familiamonoparental, sinhogar, costevivienda, request.getParameter("MotivoCoste"), u.getObservaciones_ficha_convivencia(), u.getFicheros_unidadconvivencia(), estabanco, request.getParameter("FechaAlta_BancoAlimentos"), request.getParameter("FechaBaja_BancoAlimentos"), u.getLista_recogidas(), request.getParameter("FechaOrientacion"), request.getParameter("Beneficiario"), u.getObservaciones_orientacion()));
        response.sendRedirect("./html/MenuPrincipal/Menu.html");
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
