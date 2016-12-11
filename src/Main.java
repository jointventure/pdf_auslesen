import java.util.List;


public class Main {

	public static void main(String[] args) {
		
		String xmlName = "test.xml";
		String pdfName = "test.pdf";

		List<String> pdfInhalt = DateienAuslesen.pdfAuslesen( pdfName );
		List<String> xmlInhalt = DateienAuslesen.ladeDatei( xmlName );
		for ( String current: pdfInhalt ) {
	        System.out.println( "<" + ( pdfInhalt.indexOf( current ) + 1 ) + ">" + current );
	    }
	}

}
