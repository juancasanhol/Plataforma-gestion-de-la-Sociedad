package es.juancarlos.controllers;

import es.juancarlos.beans.Acogida;
import es.juancarlos.beans.Alumno;
import es.juancarlos.beans.AtencionSocialIgualdad;
import es.juancarlos.beans.CursosFormacion;
import es.juancarlos.beans.FicheroAdjunto;
import es.juancarlos.beans.Observaciones;
import es.juancarlos.beans.ValorDesplegable;
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
@WebServlet(name = "Observacion", urlPatterns = {"/Observacion"})
public class Observacion extends HttpServlet {

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
        int id = 0;
        String url = "./html/MenuPrincipal/Menu.html";
        if (request.getSession().getAttribute("id") != null) {
            //request.getSession().setAttribute("id", request.getParameter("id"));
            id = Integer.parseInt(request.getSession().getAttribute("id").toString());
            //DAOFactory daof = DAOFactory.getDAOFactory();
            //IGenericoDAO gdao = daof.getGenericoDAO();
            switch (request.getParameter("tipo")) {
                case "cursoformacion":
                    log("OBSERVACION CURSO FORMACION AÑADIDA");
                    url = "./html/visualizaciones/VerCursosFormacion.html";
                    CursosFormacion c = (CursosFormacion) gdao.getById(id, CursosFormacion.class);
                    Observaciones observacioncurso = new Observaciones(request.getParameter("Observaciones"), request.getSession().getAttribute("autor").toString());
                    c.getObservaciones_cursos_formacion().add(observacioncurso);
                    gdao.insertOrUpdate(c);
                    break;
                case "acogida":
                    //AÑADIR FICHEROS TAMBIEN
                    url = "";

                    break;
                case "atencionsocialigualdad":
                    //AÑADIR FICHEROS TAMBIEN
                    url = "";

                    break;
                case "conferenciasantamaria":
                    //AÑADIR FICHEROS TAMBIEN
                    url = "";

                    break;
                case "bancoalimentos":
                    url = "";

                    break;
                case "alumno":
                    url = "";

                    break;
                default:

                    break;
            }
        }
        response.sendRedirect(url);

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
