package com.yash.mtbs.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yash.mtbs.model.Ticket;

public class PdfUtil {

	public static void generatePdfForTicket(Ticket ticket) {

		try {

			OutputStream file = new FileOutputStream(new File("src/main/resources/tickets/test.pdf"));
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			PdfPTable table = new PdfPTable(2);

			createCellsForTicket(ticket, table);
			
			document.open();
			document.add(table);
			document.close();
			file.close();

			System.out.println("Pdf created successfully..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void createCellsForTicket(Ticket ticket, PdfPTable table) {
		PdfPCell cell = new PdfPCell(new Paragraph(ticket.getShow().getMovieScreenMap().getScreen().getName()));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(10.0f);
		cell.setBackgroundColor(new BaseColor(140, 221, 8));

		table.addCell(cell);
		table.addCell("Movie");
		table.addCell(ticket.getShow().getMovieScreenMap().getMovie().getName());
		table.addCell("Date");
		table.addCell(ticket.getShow().getDate());
		table.addCell("Show");
		table.addCell(ticket.getShow().getStartTime() + " - " + ticket.getShow().getEndTime());
		table.addCell("Seat");
		table.addCell(ticket.getCategoryName() + "-" + ticket.getSeat().getRowNo() + ticket.getSeat().getSeatNo());
		table.addCell("Price");
		table.addCell(String.valueOf(ticket.getPrice()));
	}

}
