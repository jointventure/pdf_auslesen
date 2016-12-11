import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfLesen {
	public static void main(String[] args) {
		List<String> inhalt = new ArrayList<String>();
		
		try {
			PdfReader reader = new PdfReader( "test.pdf" );
			int numberOfPages = reader.getNumberOfPages();
			String text;
			
			for (int i = 1; i <= numberOfPages; i++) {
				text = PdfTextExtractor.getTextFromPage(reader, i);
				
				if (text.equals("")) {
					System.out.println("Seite " + i + " ist leer.");
					
				}
				inhalt.add(text);
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String current: inhalt) {
	        System.out.println("<" + (inhalt.indexOf(current) + 1) + ">" + current);
	    }
	}
}
