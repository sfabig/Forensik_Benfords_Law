import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.contentstream.operator.text.ShowText;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Start_Benford {
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		

		Benford_Analyzer ba = new Benford_Analyzer();
		Vector<String> digits = new Vector<>();
		
		for (int i = 0; i < 30; i++) {
			digits.add("1000");
		}
		for (int i = 0; i < 18; i++) {
			digits.add("242");
		}
		for (int i = 0; i < 13; i++) {
			digits.add("31");
		}
		for (int i = 0; i < 10; i++) {
			digits.add("4");
		}
		for (int i = 0; i < 8; i++) {
			digits.add("587");
		}
		for (int i = 0; i < 7; i++) {
			digits.add("604");
		}
		for (int i = 0; i < 6; i++) {
			digits.add("79999");
		}
		for (int i = 0; i < 5; i++) {
			digits.add("8001");
		}
		for (int i = 0; i < 5; i++) {
			digits.add("93");
		}
		
		//ba.analyze_digits(digits);
		
		//AbstractFileReader afr = new CsvReader("F:\\Projekt\\Forensik_Benfords_Law\\datein\\SampleCSVFile_2kb.csv", ";");
		//Vector<String> csv = afr.read();
		//System.out.println(csv);
		//ba.analyze_digits(csv);
		
		AbstractFileReader afr = new PdfReader("F:\\Projekt\\Forensik_Benfords_Law\\datein\\Kloeckner_Co_Geschaeftsbericht_2016.pdf");
		Vector<String> pdf = afr.read();
		System.out.println(pdf);
		ba.analyze_digits(pdf);
	}

}
