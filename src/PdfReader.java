import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class PdfReader extends  AbstractFileReader {
    public PdfReader(String path) {
		super(path);
		// TODO Auto-generated constructor stub
		
	}
	
    @Override
    public Vector<String> read() {
		// TODO Auto-generated method stub
		File pdfFile = new File(pathToFile);
        PDDocument document = null; 
        String pdfText = null;
               
        try 
        {
        	 document = PDDocument.load(pdfFile);
        	 PDFTextStripper stripper = new PDFTextStripper();
        	  pdfText = stripper.getText(document).toString();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally
        {
        	if (document != null)
        	{
        		try {
					document.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
        // extract number
        
      String[] number = pdfText.split("[^ 0-9]");
      Vector<String> vector = new Vector<String>(); 
      for (int i=0;i<number.length;i++){
    	  vector.add(number[i].replaceAll("\\D+",""));
    	  }
      vector.removeAll(Arrays.asList("",null));
      //convert array of String to vector
      
      return vector;
    }

    	
}