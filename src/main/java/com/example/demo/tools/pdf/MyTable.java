package com.example.demo.tools.pdf;

import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class MyTable extends PdfPTable {

	private PdfPCell[] cell = null;

	private int index = 0;

	public MyTable(int numColumns) {
		super(numColumns);
		this.cell = new PdfPCell[numColumns];
		intiPdfPCell();

	}

	private void intiPdfPCell() {
		for (int i = 0; i < cell.length; i++) {
			cell[i] = new PdfPCell();
			cell[i].setHorizontalAlignment(Element.ALIGN_CENTER);
			cell[i].setBorder(0);
			cell[i].setPaddingRight(6f);
			cell[i].setPaddingLeft(6f);
		}
	}

	public void addImage(Image image) {
		cell[index].addElement(image);
		this.addCell(cell[index]);
		++index;
	}

}
