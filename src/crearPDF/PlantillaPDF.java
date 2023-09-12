package crearPDF;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import control.PedidoDetalle;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vistas.JFrameBoleta;
import vistas.ResumenComprasContinuacion;

public class PlantillaPDF {

    String nombreDeArchivo;
    String fecha;
    String rutaImagen;
    String total;
    int nom = 0;

    ResumenComprasContinuacion ResumenComCon;
    ArrayList<PedidoDetalle> carrito;
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    public PlantillaPDF(String nombreDirector, String fecha, String rutaImagen, ArrayList<PedidoDetalle> carrito, String total) {
        this.nombreDeArchivo = nombreDirector;
        this.fecha = fecha;
        this.rutaImagen = rutaImagen;
        this.carrito = carrito;
        this.total = total;
        documento = new Document();
        titulo = new Paragraph("Comprobante de Pago");
    }

    public void crearPlantilla() {
       ;
        try {
            archivo = new FileOutputStream(nombreDeArchivo + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(1);

            Image image = null;
            try {
                image = Image.getInstance(rutaImagen);//carga imagen
                image.scaleAbsolute(150, 100);//cambia tamaño
                image.setAbsolutePosition(415, 750);//coloca imagen en la posicion

            } catch (BadElementException | IOException e) {
            }

            documento.add(image);//agrega la imagen al documento
            documento.add(titulo);
            documento.add(new Paragraph("Dirección: " + nombreDeArchivo));
            documento.add(Chunk.NEWLINE);

            Paragraph texto = new Paragraph("Resumen de compras del cliente:");
            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            documento.add(texto);
            documento.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            PdfPCell indice = new PdfPCell(new Phrase("Indice"));
            indice.setBackgroundColor(BaseColor.ORANGE);

            PdfPCell nombre = new PdfPCell(new Phrase("Nombre"));
            nombre.setBackgroundColor(BaseColor.ORANGE);

            PdfPCell precio = new PdfPCell(new Phrase("Precio"));
            precio.setBackgroundColor(BaseColor.ORANGE);

            PdfPCell cantidad = new PdfPCell(new Phrase("Cantidad"));
            cantidad.setBackgroundColor(BaseColor.ORANGE);

            tabla.addCell(indice);
            tabla.addCell(nombre);
            tabla.addCell(precio);
            tabla.addCell(cantidad);

            for (PedidoDetalle postre : this.carrito) {
                tabla.addCell(postre.getIdpostre() + "");
                tabla.addCell(JFrameBoleta.jTable1.getValueAt(nom++, 0) + "");
                tabla.addCell(postre.getPrecio() + "");
                tabla.addCell(postre.getCantidad() + "");
            }
            
            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Fecha: " + fecha));

            documento.add(Chunk.NEWLINE);
            Paragraph resultado = new Paragraph("Resumen de compras del cliente: " + total);
            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            documento.add(resultado);

            documento.close();
            JOptionPane.showMessageDialog(null, "El archivo PDF se a creado correctamente!");
        } catch (FileNotFoundException | DocumentException e) {
            System.err.println(e.getMessage());
        }

    }

}
