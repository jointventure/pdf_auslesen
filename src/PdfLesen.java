import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfLesen {
	public static void main(String[] args) {
		StringBuffer buff = new StringBuffer();
		try {
			PdfReader reader = new PdfReader( "test.pdf" );
			int numberOfPages = reader.getNumberOfPages();
			String s;
			for (int i = 1; i <= numberOfPages; i++) {
				s = PdfTextExtractor.getTextFromPage(reader, i);
				buff.append(s + "\n");
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(buff.toString());
	}
}
