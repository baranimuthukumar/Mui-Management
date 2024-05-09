package com.user.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.user.entity.AdditionDetailsEntity;
import com.user.services.AdditionDetailsService;

public class PDFGenerator {

	// List to hold all AdditionalDetails
	private List<AdditionDetailsEntity> AdditionDetailsEntityList;
	private String totalAmount;
	private String trustName;

	public String getTrustName() {
		return trustName;
	}

	public void setTrustName(String trustName) {
		this.trustName = trustName;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<AdditionDetailsEntity> getAdditionDetailsEntityList() {
		return AdditionDetailsEntityList;
	}

	public void setAdditionDetailsEntityList(List<AdditionDetailsEntity> additionDetailsEntityList) {
		AdditionDetailsEntityList = additionDetailsEntityList;
	}

	public void generate(HttpServletResponse response) throws DocumentException, IOException {

		// Creating the Object of Document
		Document document = new Document(PageSize.A4);

		// Getting instance of PdfWriter
		PdfWriter.getInstance(document, response.getOutputStream());

		// Opening the created document to modify it
		document.open();

		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Payment Details: "+getTrustName(), fontTiltle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);

		// Creating a table of 4 columns
		PdfPTable table = new PdfPTable(4);

		// Setting width of table, its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3, 3, 3});
		table.setSpacingBefore(5);

		// Create Table Cells for table header
		PdfPCell cell = new PdfPCell();

		// Setting the background color and padding
		cell.setBackgroundColor(CMYKColor.LIGHT_GRAY);
		cell.setPadding(5);

		// Creating font
		// Setting font style and size
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		// Adding headings in the created table cell/ header
		// Adding Cell to table
		cell.setPhrase(new Phrase("Sno", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Person Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Person Native", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Amount", font));
		table.addCell(cell);

		// Iterating over the list of students
		for (AdditionDetailsEntity additionDetailsEntityList : AdditionDetailsEntityList) {
			// Adding Sno
			table.addCell(String.valueOf(additionDetailsEntityList.getPostionSno()));
			// Adding name
			table.addCell(additionDetailsEntityList.getPersonName());
			// Adding Native
			table.addCell(additionDetailsEntityList.getPersonNative());
			// Adding Amount
			table.addCell(additionDetailsEntityList.getAmountdetails());
		}
		//TotalAmount
		cell.setPhrase(new Phrase("", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("TotalAmount", font));
		table.addCell(cell);
		String totalAmount=getTotalAmount();
		table.addCell(totalAmount);
		
		// Adding the created table to document
		document.add(table);

		// Closing the document
		document.close();

	}
}
