import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class DateienAuslesen {
	
	public static List<String> pdfAuslesen( String datName ) {
		// Liest den rohen Pdf-Text und die Seitenzahlen aus und 
		// gibt den Inhalt in einer gerdneten Liste wieder.
		// (Jede Seite ein Listeneintrag.)
			
		String text;
		List<String> inhalt = new ArrayList<String>();
		
		try {
			PdfReader reader = new PdfReader( datName );
			int numberOfPages = reader.getNumberOfPages();
			
			
			for ( int i = 1; i <= numberOfPages; i++ ) {
				text = PdfTextExtractor.getTextFromPage( reader, i );
				
				if ( text.equals( "" ) ) {
					System.out.println( "Seite " + i + " ist leer." );
				}
				
				inhalt.add( text );
			}
				
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		
		return( inhalt );
	}
	
	
	    public static List<String> ladeDatei( String datName ) {
	    	// Liest eine Datei zeilenweise aus und gibt sie als Liste aus.
	    	// Pro Zeile ein Listeneintrag.
	        File file = new File( datName );

	        if ( !file.canRead() || !file.isFile() )
	            System.exit(0);

	            BufferedReader in = null;
	            List<String> inhalt = new ArrayList<String>();
	            String zeile = null;
	            
	        try {
	            in = new BufferedReader( new FileReader( datName ) );
	            while ( ( zeile = in.readLine() ) != null ) {
	            	inhalt.add( zeile );
//	                System.out.println( "Gelesene Zeile: " + zeile ) ;
	            }
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        } finally {
	            if ( in != null )
	                try {
	                    in.close();
	                } catch ( IOException e ) {
	                }
	        }
	        return( inhalt );
	    }
	}

