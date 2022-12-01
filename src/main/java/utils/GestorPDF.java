package utils;

import model.Pasajero;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.Date;

public class GestorPDF {
    public void generarBoleta(Pasajero pasajero) throws IOException {
//Se crea un nuevo documento
        PDDocument documento = new PDDocument();
//Al documento se le crea y agrega una nueva página, en este caso en formato A6
        PDPage pagina = new PDPage(PDRectangle.A6);
        documento.addPage(pagina);
//Se genera un arreglo de líneas que va a tener el archivo PDF
        String[] lineasPdf= this.obtenerLíneasPdf(pasajero);
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
    public String[] obtenerLíneasPdf(Pasajero pasajero){
        String[] lineasPdf= new String[10];
        lineasPdf[0]="Boleta electrónica - venta pasaje";
        lineasPdf[1]="Travel Pet";

        //posible uso
        /*lineasPdf[2]="Fecha ="+pasajero.getFecha();
        lineasPdf[3]= "Nombre ="+pasajero.getNombre();
        lineasPdf[4]= "Rut ="+pasajero.getRut();
        lineasPdf[5]= "Correo ="+pasajero.getCorreo();
        lineasPdf[6]= "Numero telefono ="+pasajero.getNumeroTelefono();*/

        lineasPdf[2]="Fecha ="+pasajero.getFecha();
        lineasPdf[3]= "Nombre Comprador= Gustavo";
        lineasPdf[4]= "Origen = Pucon";
        lineasPdf[5]= "Destino =Chillan";
        lineasPdf[6]= "Nombre de mascota =Juanin";
        lineasPdf[7]= "Tipo de mascota =Perro";
        lineasPdf[8]= "Peso de mascota =10kg";
        lineasPdf[9]="---------------------------------------------------------------------";
        return lineasPdf;
    }
    private String generarNombrePdf(Date fecha){
        System.out.println(fecha.toString());
        String fechaArchivo= fecha.toString();
        fechaArchivo=fechaArchivo.replace(" ","").replace(":","");
        String nombreArchivo="target/"+"boleta"+fechaArchivo+".pdf";
        return nombreArchivo;
    }

}