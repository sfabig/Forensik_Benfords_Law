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
        File pdfFile = new File(pathToFile);
        Vector<String> result = new Vector<String>();
        List<List<String>> lines = new ArrayList<>();
        PDDocument document = null; 
        Scanner inputStream;
        String separator = " ";
        try 
        {
        	 document = PDDocument.load(pdfFile);
        	 PDFTextStripper stripper = new PDFTextStripper();
        	 String pdfText = stripper.getText(document).toString();
        	 inputStream = new Scanner(pdfText);
        	 while(inputStream.hasNext()){
                 String line= inputStream.next();
                 String[] values = line.split(separator);
                 lines.add(Arrays.asList(values));
             }

             inputStream.close();      	 
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
        
        for(List<String> l : lines) 
        	for(String s : l) 
        		result.add(s.replaceAll("\\D+",""));
        	
        result.removeAll(Arrays.asList("",null));
        
        return result;
    }

	@Override
	public String showTextPdf() {
		// TODO Auto-generated method stub
		File pdfFile = new File(pathToFile);
        Vector<String> result = new Vector<String>();
        List<List<String>> lines = new ArrayList<>();
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
        
        return pdfText;
	}
    	
}