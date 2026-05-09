package com.upc.trabajoparcial.Servicios;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfServicio {

    public byte[] generarPdfPacientes() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(out);

        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf);

        document.add(new Paragraph("REPORTE DE PACIENTES"));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("Paciente 1"));
        document.add(new Paragraph("Paciente 2"));
        document.add(new Paragraph("Paciente 3"));

        document.close();

        return out.toByteArray();
    }
}
