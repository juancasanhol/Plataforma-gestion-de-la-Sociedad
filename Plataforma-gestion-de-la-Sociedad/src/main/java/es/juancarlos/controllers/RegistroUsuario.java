package es.juancarlos.controllers;

import es.juancarlos.beans.Observaciones;
import es.juancarlos.beans.Usuario;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import java.io.IOException;
import java.util.ArrayList;
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        Observaciones observacion = new Observaciones(request.getParameter("Observaciones"),"ADMIN");
        Boolean minoria = false;
        List<Observaciones> observaciones = new ArrayList<Observaciones>();
        if(request.getParameter("PerteneceMinoria")!=null){
            minoria = true;
        }
        observaciones.add(observacion);
        gdao.insertOrUpdate(new Usuario(request.getParameter("Nombre"),request.getParameter("Apellidos"),request.getParameter("FechaAlta"),request.getParameter("FechaBaja"),request.getParameter("TipoDoc"),request.getParameter("NumDoc"),request.getParameter("Telefono"),request.getParameter("Correo"),request.getParameter("PersonaReferencia"),request.getParameter("Sexo"),request.getParameter("FechaNac"),request.getParameter("PaisOrigen"),request.getParameter("Nacionalidad"),minoria,request.getParameter("Minoria"),observaciones));
        /*gdao.insertOrUpdate(new Usuario("PROBANDO0", "PROBANDO0"));
        gdao.insertOrUpdate(new Usuario("PROBANDO1", "PROBANDO1"));
        gdao.insertOrUpdate(new Usuario("PROBANDO2", "PROBANDO2"));*/
        

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
