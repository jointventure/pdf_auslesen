import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfLesen {
	public static void main(String[] args) {
		StringBuffer buff = new StringBuffer();
		try {
			PdfReader reader = new PdfReader( "test.pdf" );
			int numberOfPages = reader.getNumberOfPages();
			String text;
			
			for (int i = 1; i <= numberOfPages; i++) {
				text = PdfTextExtractor.getTextFromPage(reader, i);
				
				if (text.equals("")) {
					System.out.println("Seite " + i + " ist leer.");
				
				} else {
					buff.append("<Seite " + i + " >" + text + "\n");
				}
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(buff.toString());
	}
}
