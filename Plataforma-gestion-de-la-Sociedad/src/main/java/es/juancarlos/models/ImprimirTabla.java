/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juancarlos.models;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import es.juancarlos.beans.MiembrosFamilia;
import es.juancarlos.beans.Usuario;
import es.juancarlos.beans.ValorDesplegable;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IDesplegablesDAO;
import es.juancarlos.interfaces.IListaDao;
import java.io.*;
import java.util.Iterator;

/**
 *
 * @author junco
 */
public class ImprimirTabla {
    // Fonts definitions (Definición de fuentes).

    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    /**
     * We create a PDF document with iText using different elements to learn to
     * use this library. Creamos un documento PDF con iText usando diferentes
     * elementos para aprender a usar esta librería.
     *
     * @param pdfNewFile  <code>String</code> pdf File we are going to write.
     * Fichero pdf en el que vamos a escribir.
     */
    DAOFactory daof = DAOFactory.getDAOFactory();
    IListaDao ldao = daof.getListaDAO();
    IDesplegablesDAO ddao = daof.getDesplegablesDAO();

    public void createPDFListadoAyudas(File pdfNewFile) throws FileNotFoundException {
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Rotate event = new Rotate();
            event.setOrientation(PdfPage.LANDSCAPE);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile)).setPageEvent(event);

            document.setPageSize(PageSize.A4.rotate());
            document.open();

            // We add metadata to PDF
            // Añadimos los metadatos del PDF
            document.addTitle("Listado Beneficiarios Banco de Alimentos");
            document.addAuthor("GENERADO AUTOMATICAMENTE");
            document.addCreator("SAN VICENTE DE PAUL - MERIDA");

            // First page
            // Primera página 
            Chunk chunk = new Chunk("CONFERENCIAS SAN VICENTE DE PAUL - MERIDA", chapterFont);
            chunk.setBackground(BaseColor.LIGHT_GRAY);

            // Let's create de first Chapter (Creemos el primer capítulo)
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);

            document.add(chapter);

            Integer numColumns = 6;
            Integer numRows = 120;
            // We create the table (Creamos la tabla).
            PdfPTable table = new PdfPTable(numColumns);

            float[] relativeWidths = {0.3f, 1.2f, 0.4f, 0.6f, 0.6f, 0.7f};
            table.setWidths(relativeWidths);
            table.setTotalWidth(105);
            table.setWidthPercentage(105);
            table.setSpacingBefore(25);
            // Now we fill the PDF table 
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            // Fill table rows (rellenamos las filas de la tabla).                

            columnHeader = new PdfPCell(new Phrase("Nº ORDEN"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(columnHeader);

            columnHeader = new PdfPCell(new Phrase("NOMBRE BENEFICIARIO"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(columnHeader);

            columnHeader = new PdfPCell(new Phrase("RP UNIDAD FAMILIAR"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(columnHeader);

            columnHeader = new PdfPCell(new Phrase("DNI/NIE"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(columnHeader);

            columnHeader = new PdfPCell(new Phrase("PASAPORTE"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(columnHeader);

            columnHeader = new PdfPCell(new Phrase("FECHA NACIMIENTO"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(columnHeader);

            table.setHeaderRows(1);
            // Fill table rows (rellenamos las filas de la tabla).       f
            Iterator i = ldao.ListadoXBanco_Fega(Boolean.TRUE, Boolean.FALSE).iterator();

            while (i.hasNext()) {
                Usuario u = (Usuario) i.next();
                int cont = 1;
                for (int column = 0; column < numColumns; column++) {
                    switch (column) {
                        case 0:
                            table.addCell(String.valueOf(cont));
                            break;
                        case 1:
                            table.addCell(String.valueOf(u.getNombre() + " " + u.getApellidos()));
                            break;
                        case 2:
                            table.addCell("X");
                            break;
                        case 3:
                            ValorDesplegable vDesDNI = ddao.getByID("DNI");
                            ValorDesplegable vDesPass = ddao.getByID("PASAPORTE");
                            if (u.getTipoDoc().equals(String.valueOf(vDesDNI.getId()))) {
                                table.addCell(u.getNumDoc());
                                table.addCell("");
                            }
                            if (u.getTipoDoc().equals(String.valueOf(vDesPass.getId()))) {
                                table.addCell("");
                                table.addCell(u.getNumDoc());
                            }
                            if (!u.getTipoDoc().equals(String.valueOf(vDesDNI.getId())) && !u.getTipoDoc().equals(String.valueOf(vDesPass.getId()))){
                                         table.addCell(""); table.addCell("");
                                         
                                    }

                            break;

                        case 5:
                            table.addCell(String.valueOf(u.getFechaNac()));
                            break;
                    }
                }
                cont++;
                if (!u.getFamiliares().isEmpty()) {

                    Iterator i2 = u.getFamiliares().iterator();

                    while (i2.hasNext()) {
                        MiembrosFamilia mF = (MiembrosFamilia) i2.next();

                        for (int column2 = 0; column2 < numColumns; column2++) {

                            switch (column2) {
                                case 0:
                                    table.addCell(String.valueOf(cont));
                                    break;
                                case 1:
                                    table.addCell(mF.getNombre());
                                    break;
                                case 2:
                                    table.addCell("");
                                    break;
                                case 3:
                                    ValorDesplegable vDesDNI = ddao.getByID("DNI");
                                    ValorDesplegable vDesPass = ddao.getByID("PASAPORTE");
                                    if (mF.getTipoDoc() == vDesDNI.getId()) {
                                        table.addCell(mF.getNumDoc());
                                        table.addCell("");
                                    } 
                                    if (mF.getTipoDoc() == vDesPass.getId()) {
                                        table.addCell("");
                                        table.addCell(mF.getNumDoc());
                                    }
                                    if (mF.getTipoDoc() != vDesPass.getId() && mF.getTipoDoc() != vDesDNI.getId()){
                                         table.addCell(""); table.addCell("");
                                         
                                    }

                                    break;

                                case 5:
                                    table.addCell(String.valueOf(mF.getFechaNacimiento()));
                                    break;
                            }

                        }

                    }

                    cont++;
                }

            }
            // We add the table (Añadimos la tabla)
            document.add(table);
            // We add the paragraph with the table (Añadimos el elemento con la tabla).;
            document.close();
            


        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }

    public class Rotate extends PdfPageEventHelper {

        protected PdfNumber orientation = PdfPage.PORTRAIT;

        public void setOrientation(PdfNumber orientation) {
            this.orientation = orientation;
        }

        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            writer.addPageDictEntry(PdfName.ROTATE, orientation);
        }
    }
}
