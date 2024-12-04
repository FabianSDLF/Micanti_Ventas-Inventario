package org.example.miscanti_ventainventario.Logica;

public class Boleta {

    public static String print(String[] texto, int total) {
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
                .append("<< /Length 200 >>\n")
                .append("stream\n");

        // Texto: Título de la boleta
        pdfContent.append("BT\n")
                .append("/F1 16 Tf\n")
                .append("70 750 Td\n")
                .append("(AGUAS MISCANTI - COMPROBANTE DE COMPRA) Tj\n")
                .append("0 -20 Td\n");

        // Texto: Fecha de la boleta
        pdfContent.append("0 -20 Td\n")
                .append("("+java.time.LocalDate.now()+") Tj\n");

        // Línea separadora
        pdfContent.append("0 -20 Td\n")
                .append("(------------------------------------------) Tj\n");

        // Texto: Encabezado de la tabla de compra
        pdfContent.append("0 -20 Td\n")
                .append("(Producto               Cantidad  Precio  Subtotal) Tj\n");

        // Iterar sobre los productos o texto para imprimir en formato de tabla
        for (int i = 0; i < texto.length; i++) {
            pdfContent.append("0 -20 Td\n");
            pdfContent.append("("+texto[i]+") Tj\n");
        }

        // Línea separadora para el total
        pdfContent.append("0 -20 Td\n")
                .append("(------------------------------------------) Tj\n");

        // Mostrar el total de la boleta
        pdfContent.append("0 -20 Td\n")
                .append("(TOTAL: $ " + total + ") Tj\n");

        // Pie de página con información adicional
        pdfContent.append("0 -20 Td\n")
                .append("(Gracias por su compra. Aguas Miscanti) Tj\n");

        pdfContent.append("ET\n");  // Fin del texto
        pdfContent.append("endstream\n");
        pdfContent.append("endobj\n");

        // Tabla de referencias cruzadas (xref)
        pdfContent.append("xref\n");
        pdfContent.append("0 5\n");
        pdfContent.append("0000000000 65535 f \n");
        pdfContent.append("0000000010 00000 n \n");
        pdfContent.append("0000000053 00000 n \n");
        pdfContent.append("0000000102 00000 n \n");
        pdfContent.append("0000000222 00000 n \n");

        pdfContent.append("trailer\n");
        pdfContent.append("<< /Root 1 0 R /Size 5 >>\n");
        pdfContent.append("startxref\n");
        pdfContent.append("277\n");
        pdfContent.append("%%EOF\n");

        return pdfContent.toString();
    }
}
