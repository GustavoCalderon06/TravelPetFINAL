package utils;

import GUIs.VentanaAsientos;
import model.Mascota;
import model.Pasajero;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.Date;

public class GestorPDF {

    public void generarBoleta(Pasajero pasajero, Mascota mascota) throws IOException {
//Se crea un nuevo documento
        PDDocument documento = new PDDocument();
//Al documento se le crea y agrega una nueva página, en este caso en formato A6
        PDPage pagina = new PDPage(PDRectangle.A6);
        documento.addPage(pagina);
//Se genera un arreglo de líneas que va a tener el archivo PDF
        String[] lineasPdf= this.obtenerLíneasPdf(pasajero,mascota);
        this.rellenarPDF(documento,pagina,lineasPdf);
//Se guarda el documento en la ubicación descrita
        documento.save(this.generarNombrePdf(pasajero.getFecha()));
        documento.close();
    }
    public void rellenarPDF(PDDocument documento, PDPage pagina, String[] lineasVenta){
//Por cada linea del arreglo, se irá agregando texto
        try (PDPageContentStream contenidoPagina = new PDPageContentStream(documento, pagina)) {
            for(int linea=0; linea<lineasVenta.length; linea++) {
                contenidoPagina.beginText();
//Se define en que posición del documento estará el texto
                contenidoPagina.newLineAtOffset(10, pagina.getMediaBox().getHeight()-(10*linea));
                contenidoPagina.setFont(PDType1Font.HELVETICA_BOLD, 8f);
//Agrega el texto al documento
                contenidoPagina.showText(lineasVenta[linea]);
                contenidoPagina.endText();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] obtenerLíneasPdf(Pasajero pasajero,Mascota mascota){


        String[] lineasPdf= new String[19];
        lineasPdf[0]= "--------------------------------------------------------------------";
        lineasPdf[1]="Boleta electrónica - venta pasaje";
        lineasPdf[2]="Travel Pet";
        lineasPdf[3]= "--------------------------------------------------------------------";
        lineasPdf[4]="Fecha de compra ="+pasajero.getFecha();
        lineasPdf[5]= "Asiento comprador="+pasajero.getAsiento();
        lineasPdf[6]= "Nombre Comprador= "+pasajero.getNombre();
        lineasPdf[7]= "Rut="+pasajero.getRut();
        lineasPdf[8]= "Correo de comprador="+pasajero.getCorreo();
        lineasPdf[9]= "Numero telefonico="+pasajero.getNumeroTelefono();
        lineasPdf[10]= "--------------------------------------------------------------------";
        lineasPdf[11]= "Origen = Pucon";
        lineasPdf[12]= "Destino =Chillan";
        lineasPdf[13]= "--------------------------------------------------------------------";
        lineasPdf[14]= "Asiento mascota="+mascota.getAsiento();
        lineasPdf[15]= "Nombre de mascota ="+mascota.getNombre();
        lineasPdf[16]= "Tipo de mascota ="+mascota.getTipo();
        lineasPdf[17]= "Peso de mascota ="+mascota.getPeso();
        lineasPdf[18]="---------------------------------------------------------------------";
        return lineasPdf;
    }
    private String generarNombrePdf(Date fecha){
        System.out.println(fecha.toString());
        String fechaArchivo= fecha.toString();
        fechaArchivo=fechaArchivo.replace(" ","").replace(":","");
        //String nombreArchivo="target/"+"boleta"+fechaArchivo+".pdf";
        String nombreArchivo="src\\main\\resources\\PDFs\\"+"boleta"+fechaArchivo+".pdf";
        return nombreArchivo;
    }

}