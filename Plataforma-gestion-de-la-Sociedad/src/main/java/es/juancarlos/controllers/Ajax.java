package es.juancarlos.controllers;

import es.juancarlos.beans.Usuario;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        
        
       gdao.insertOrUpdate(new Usuario("PROBANDO0","PROBANDO0"));
       gdao.insertOrUpdate(new Usuario("PROBANDO1","PROBANDO1"));
       gdao.insertOrUpdate(new Usuario("PROBANDO2","PROBANDO2"));
         switch (request.getParameter("accion")) {
             
             case "prueba1":
                Usuario u = (Usuario) gdao.getById(Integer.parseInt(request.getParameter("dato")), Usuario.class);
                
                objeto = new JSONObject();
                objeto.put("id", u.getNumIntId());
                objeto.put("nombre", u.getNombre());//...
                
                response.setContentType("application/json");
                response.getWriter().print(objeto);
                
                
                 break;
                 
                  case "prueba2":


                    List retorno = new ArrayList();
                    Iterator i =  gdao.get(Usuario.class).iterator();
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
