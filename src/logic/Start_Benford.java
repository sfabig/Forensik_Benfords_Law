package logic;
import java.util.Vector;

public class Start_Benford {
	
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
		System.out.println("Reading PDF");
		AbstractFileReader afr = new PdfReader("F:\\Studium\\Master\\IT & Medienforensik\\Forensik_Benfords_Law\\Test Data\\Kloeckner_Co_Geschaeftsbericht_2016.pdf");
		Vector<String> pdf = afr.read();
		System.out.println(pdf);
		ba.analyze_digits(pdf);
	}

}
