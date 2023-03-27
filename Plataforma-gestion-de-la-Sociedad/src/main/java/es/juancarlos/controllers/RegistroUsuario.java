package es.juancarlos.controllers;

import es.juancarlos.beans.Observaciones;
import es.juancarlos.beans.Perfil;
import es.juancarlos.beans.Usuario;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
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
        Observaciones obsB=null;
        List <Observaciones> Lobs=new ArrayList<>();
        //todos aquellos campos de request que coincidan con el nombre de las variables del bean se insertaran
        
        if (request.getParameter("id")!=null && !request.getParameter("id").equals("") && Usuario.isNumeric(request.getParameter("id"))){
            u.setNumIntId(Integer.parseInt(request.getParameter("id")));
        }
        u.Cargar(request.getParameterMap());
        
        if(!request.getParameter("Observaciones").equals("")|| !request.getParameter("Observaciones").equals(null) ){
            Lobs=new ArrayList<>();
            Lobs.add(new Observaciones(request.getParameter("Observaciones"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
            u.setObservaciones(Lobs);
        }
        
        if(!request.getParameter("ObservacionesSanitarias").equals("")|| !request.getParameter("ObservacionesSanitarias").equals(null) ){
            Lobs=new ArrayList<>();
            Lobs.add(new Observaciones(request.getParameter("ObservacionesSanitarias"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
            u.setObservaciones_sanitarias(Lobs);
        }
        
         if(!request.getParameter("ObservacionesLaborales").equals("")|| !request.getParameter("ObservacionesLaborales").equals(null) ){
            Lobs=new ArrayList<>();
             Lobs.add(new Observaciones(request.getParameter("ObservacionesLaborales"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
            u.setObservaciones_sanitarias(Lobs);
        }
         
        if(!request.getParameter("ObservacionesFormacion").equals("")|| !request.getParameter("ObservacionesFormacion").equals(null) ){
            Lobs=new ArrayList<>();
            Lobs.add(new Observaciones(request.getParameter("ObservacionesFormacion"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
            u.setObservaciones_sanitarias(Lobs);
        } 
        
        if(!request.getParameter("ObservacionesIngresos").equals("")|| !request.getParameter("ObservacionesIngresos").equals(null) ){
            Lobs=new ArrayList<>();
            Lobs.add(new Observaciones(request.getParameter("ObservacionesIngresos"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
            u.setObservaciones_sanitarias(Lobs);
        }
        
        if(!request.getParameter("ObservacionesConvivencia").equals("")|| !request.getParameter("ObservacionesConvivencia").equals(null) ){
            Lobs=new ArrayList<>();
            Lobs.add(new Observaciones(request.getParameter("ObservacionesConvivencia"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
            u.setObservaciones_sanitarias(Lobs);
        } 
        
        if(!request.getParameter("ObservacionesOrientacion").equals("")|| !request.getParameter("ObservacionesOrientacion").equals(null) ){
            Lobs=new ArrayList<>();
            Lobs.add(new Observaciones(request.getParameter("ObservacionesOrientacion"), (Perfil) gdao.getById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idAutor"))), Perfil.class)));
            u.setObservaciones_sanitarias(Lobs);
        }

        
        gdao.insertOrUpdate(u);
  
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
