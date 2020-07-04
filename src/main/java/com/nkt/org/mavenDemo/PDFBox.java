package com.nkt.org.mavenDemo;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFBox {

	public static void main(String[] args) throws Exception {
		createPDFDocument();
		loadPDFDocumet();
//		removePage();
		addContentToFile();
//		addMultipleLines();
		readDataFromPDF();
	}
	
	static void createPDFDocument() throws IOException {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		document.save("C:\\Users\\Acer\\Documents\\MongoDb\\PDF2.pdf");
		document.close();
	}
	
	static void loadPDFDocumet() throws IOException {
		File file = new File("C:\\Users\\Acer\\Documents\\MongoDb\\PDF2.pdf");
		PDDocument document = PDDocument.load(file);
		PDPage page = new PDPage();
		document.addPage(page);
		document.save(file);
		document.close();
	}
	
	static void removePage() throws Exception{
		File file = new File("C:\\Users\\Acer\\Documents\\MongoDb\\PDF1.pdf");
		PDDocument document = PDDocument.load(file);
		int noOfPages = document.getNumberOfPages();
		System.out.println(noOfPages);
		document.removePage(1);
		System.out.println(document.getNumberOfPages());
	}
	
	static void addContentToFile() throws Exception {
		File file = new File("C:\\Users\\Acer\\Documents\\MongoDb\\PDF2.pdf");
		PDDocument document = PDDocument.load(file);
		PDPage page  =  document.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.beginText();
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
		contentStream.newLineAtOffset(25, 500);
		String text = "This is a simple text. This is to check anything. Be aware of Corona";
		contentStream.showText(text);
		contentStream.endText();
		contentStream.close();
		document.save(file);
		document.close();
	}
	
	static void addMultipleLines() throws Exception{
		File file = new File("C:\\Users\\Acer\\Documents\\MongoDb\\PDF2.pdf");
		PDDocument document = PDDocument.load(file);
		PDPage page = document.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.beginText();
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 15);
		contentStream.setLeading(14.5f);
		contentStream.newLineAtOffset(25, 725);
		String text = "This is the first line";
		String text1 = "This is the second line";
		contentStream.showText(text);
		contentStream.newLine();
		contentStream.showText(text1);
		contentStream.endText();
		contentStream.close();
		document.save(file);
		document.close();
	}
	

	
	static void readDataFromPDF() throws Exception {
		File file = new File("C:\\Users\\Acer\\Documents\\MongoDb\\PDF2.pdf");
		PDDocument document = PDDocument.load(file);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String  text = pdfStripper.getText(document);
		System.out.println(text);
  	}
		
		
}


