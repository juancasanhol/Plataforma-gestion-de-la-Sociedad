package es.juancarlos.controllers;

import es.juancarlos.beans.Acogida;
import es.juancarlos.beans.AtencionSocialIgualdad;
import es.juancarlos.beans.FicheroAdjunto;
import es.juancarlos.beans.Observaciones;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.models.GuardarFicheros;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "AtencionSocial", urlPatterns = {"/AtencionSocial"})
public class AtencionSocial extends HttpServlet {

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
        //OBTENER TRABAJDOR DEL LOGIN Y CAMBIARLO POR ADMIN
        Observaciones observacion = new Observaciones(request.getParameter("Observaciones"), request.getSession().getAttribute("autor").toString());
        List<Observaciones> observaciones = new ArrayList<Observaciones>();
        observaciones.add(observacion);
        List<FicheroAdjunto> ficheros = new ArrayList<FicheroAdjunto>();
        try{
            FicheroAdjunto f = new FicheroAdjunto(GuardarFicheros.GuardarFichero(request, getServletContext().getRealPath(getServletContext().getInitParameter("rutaFicheros")), "Fichero", "AtencionSocialIgualdad_"+request.getParameter("Usuario")), false);
            ficheros.add(f);
        }
        catch(Exception e){
            //No hay fichero para hacer el submit
            //He usado try catch porque para comprobar si hay fichero o no no sirve con comparar el campo a null
        }
        gdao.insertOrUpdate(new AtencionSocialIgualdad(request.getParameter("Fecha"),request.getSession().getAttribute("autor").toString(),request.getParameter("Usuario"),request.getParameter("ProcedenciaDerivacion"),request.getParameter("MotivoConsulta"),request.getParameter("Intervencion"),request.getParameter("EstadoResolucion"), observaciones, ficheros));
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
