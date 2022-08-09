package es.juancarlos.controllers;

import es.juancarlos.beans.Acogida;
import es.juancarlos.beans.Alumno;
import es.juancarlos.beans.AtencionSocialIgualdad;
import es.juancarlos.beans.AulaMagica;
import es.juancarlos.beans.BancoAlimentos;
import es.juancarlos.beans.ConferenciaSantaMaria;
import es.juancarlos.beans.CursosFormacion;
import es.juancarlos.beans.Empresa;
import es.juancarlos.beans.Usuario;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Carlos Sánchez Holguín
 */
@WebServlet(name = "Borrar", urlPatterns = {"/Borrar"})
public class Borrar extends HttpServlet {

    /**
     * Procesa solicitudes para ambos HTTP <code>GET</code> y <code>POST</code>
     * métodos.
     *
     * Servlet usado para las diferentes redireciones de la aplicación de una
     * página html a otra
     *
     * @param request Servlet request
     * @param response Servlet response
     * @throws ServletException Si ocurre un error específico del Servlet
     * @throws IOException Si ocurre un error de I/O
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log("ID  " + request.getParameter("id"));
        if (request.getParameter("id") != null) {
            request.getSession().setAttribute("id", request.getParameter("id"));
        }
        String url = "";
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        switch (request.getParameter("accion")) {
            case "borrarusuario":
                url = "./html/usuario/VerUsuarios.html";
                Usuario u = (Usuario) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Usuario.class);
                gdao.delete(u);
                break;
            case "borrarcursoformacion":
                url = "./html/visualizaciones/VerCursosFormacion.html";
                CursosFormacion cf = (CursosFormacion) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), CursosFormacion.class);
                gdao.delete(cf);
                break;
            case "borrarempresa":
                url = "./html/visualizaciones/VerEmpresas.html";
                Empresa e = (Empresa) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Empresa.class);
                gdao.delete(e);
                break;
            case "borrarfichaacogida":
                url = "./html/visualizaciones/VerAcogidas.html";
                Acogida a = (Acogida) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Acogida.class);
                gdao.delete(a);
                break;
            case "borraraulamagica":
                url = "./html/visualizaciones/VerAulasMagicas.html";
                AulaMagica am = (AulaMagica) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), AulaMagica.class);
                gdao.delete(am);
                break;
            case "borrarfichaatencionsocialigualdad":
                url = "./html/visualizaciones/VerFichasAtencionSocialIgualdad.html";
                AtencionSocialIgualdad asi = (AtencionSocialIgualdad) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), AtencionSocialIgualdad.class);
                gdao.delete(asi);
                break;
            case "borrarconferencia":
                url = "./html/visualizaciones/VerConferencias.html";
                ConferenciaSantaMaria csm = (ConferenciaSantaMaria) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), ConferenciaSantaMaria.class);
                gdao.delete(csm);
                break;
            case "borraralumnos":
                url = "./html/visualizaciones/VerAlumnos.html";
                Alumno al = (Alumno) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), Alumno.class);
                gdao.delete(al);
                break;
            case "borrarbancos":
                url = "./html/visualizaciones/VerBancosAlimentos.html";
                BancoAlimentos ba = (BancoAlimentos) gdao.getById(Integer.parseInt(request.getSession().getAttribute("id").toString()), BancoAlimentos.class);
                gdao.delete(ba);
                break;
            default:

                break;
        }
        response.sendRedirect(url);
        //request.getRequestDispatcher(url).forward(request, response);

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
