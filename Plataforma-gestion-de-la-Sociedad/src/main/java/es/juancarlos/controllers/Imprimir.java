package es.juancarlos.controllers;

import es.juancarlos.beans.ConferenciaSantaMaria;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Juan Carlos Sánchez Holguín
 */
@MultipartConfig
@WebServlet(name = "Imprimir", urlPatterns = {"/Imprimir"})
public class Imprimir extends HttpServlet {

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
            throws ServletException, IOException, COSVisitorException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        ConferenciaSantaMaria conf = (ConferenciaSantaMaria) gdao.getById(Integer.parseInt(request.getParameter("id")), ConferenciaSantaMaria.class);
        File archivo = new File(this.getClass().getClassLoader().getResource("").getPath() + "../../archivos/RECIBO_MENSUAL_VALIDO.pdf");
        PDDocument pDDocument = PDDocument.load(archivo);
        PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
        //Se rellenan los campos del PDF aqui
        PDField field = pDAcroForm.getField("NumExt");
        field.setValue(conf.getNumExtId());
        field = pDAcroForm.getField("Nombre");
        field.setValue(conf.getNombre() + " " + conf.getApellidos());
        field = pDAcroForm.getField("Direccion");
        field.setValue(conf.getDireccion() + " - " + conf.getPoblacion() + " (" + conf.getProvincia() + ") | "+conf.getCodigoPostal());
        field = pDAcroForm.getField("Telefono");
        field.setValue(conf.getTelefono());
        field = pDAcroForm.getField("Mail");
        field.setValue(conf.getMail());
        field = pDAcroForm.getField("Cuota");
        field.setValue(String.valueOf(conf.getCuota()));
        field = pDAcroForm.getField("N1");
        field.setValue("12");
        field = pDAcroForm.getField("A1");
        //Se coge el año que es (los dos ultimos digitos)
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        String year = formattedDate.split("/")[0].charAt(2) + "" + formattedDate.split("/")[0].charAt(3);
        field.setValue(String.valueOf(Integer.parseInt(year) - 1));
        field = pDAcroForm.getField("C1");
        field.setValue(String.valueOf(conf.getCuota()));
        for (int i = 2; i < 13; i++) {
            field = pDAcroForm.getField("N" + i);
            field.setValue(String.valueOf(i-1));
            field = pDAcroForm.getField("A" + i);
            field.setValue(year);
            field = pDAcroForm.getField("C" + i);
            field.setValue(String.valueOf(conf.getCuota()));
        }
        //Se guarda el recibo
        File carpeta = new File(this.getClass().getClassLoader().getResource("").getPath() + "../../recibos");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
        pDDocument.save(carpeta + "/RECIBO_" + conf.getApellidos() + ".pdf");
        pDDocument.close();
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
        try {
            processRequest(request, response);
        } catch (COSVisitorException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (COSVisitorException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
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
