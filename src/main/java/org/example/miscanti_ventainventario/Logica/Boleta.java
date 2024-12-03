package org.example.miscanti_ventainventario.Logica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Boleta {

    public static String print(String[] texto) {
        // Definir el contenido básico de un PDF en formato texto plano.
        StringBuilder pdfContent = new StringBuilder();

        // Encabezado de PDF y versión
        pdfContent.append("%PDF-1.4\n");

        // Objeto raíz
        pdfContent.append("1 0 obj\n")
                .append("<< /Type /Catalog /Pages 2 0 R >>\n")
                .append("endobj\n");

        // Objeto de la página
        pdfContent.append("2 0 obj\n")
                .append("<< /Type /Pages /Count 1 /Kids [3 0 R] >>\n")
                .append("endobj\n");

        // Objeto de la página
        pdfContent.append("3 0 obj\n")
                .append("<< /Type /Page /Parent 2 0 R /MediaBox [0 0 612 792] /Contents 4 0 R /Resources << >> >>\n")
                .append("endobj\n");

        // Contenido de la página (texto)
        pdfContent.append("4 0 obj\n")
                .append("<< /Length 44 >>\n")
                .append("stream\n");

        // Texto
        pdfContent.append("BT\n")
                .append("/F1 12 Tf\n")  // Fuente y tamaño de texto
                .append("70 700 Td\n")  // Posición del texto (x, y)
                .append("(AGUAS MISCANTI - COMPROBANTE DE COMPRA) Tj\n")
                .append("0 -20 Td\n");

        // Iterar sobre los productos o texto para imprimir
        for (int i = 0; i < texto.length; i++) {
            pdfContent.append("(------------------------------------------) Tj\n");

            pdfContent.append("0 -20 Td\n");
            pdfContent.append("(" + texto[i] + ") Tj\n");
            pdfContent.append("0 -20 Td\n");
        }

        pdfContent.append("ET\n");  // Fin del texto
        pdfContent.append("endstream\n");
        pdfContent.append("endobj\n");

        // Tabla de referencias cruzadas (xref)
        pdfContent.append("xref\n");
        pdfContent.append("0 5\n");  // Número de objetos
        pdfContent.append("0000000000 65535 f \n");
        pdfContent.append("0000000010 00000 n \n");
        pdfContent.append("0000000053 00000 n \n");
        pdfContent.append("0000000102 00000 n \n");
        pdfContent.append("0000000178 00000 n \n");

        // Trailer
        pdfContent.append("trailer\n")
                .append("<< /Root 1 0 R /Size 5 >>\n");

        // Posición de xref
        pdfContent.append("startxref\n")
                .append("256\n");

        // Fin del archivo PDF
        pdfContent.append("%%EOF");

        return pdfContent.toString();
    }}

