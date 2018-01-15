package logic;
import java.util.Vector;

public class Start_Benford {
	
	public static void main(String[] args) {
		
		Benford_Analyzer ba = new Benford_Analyzer();
		Vector<Double> occ;
		
		// Geschäftsberichte
		AbstractFileReader afr = new PdfReader("F:\\Studium\\Master\\IT & Medienforensik\\Forensik_Benfords_Law\\TestData\\Geschäftsbericht\\Berichte\\DSGV_FB-2016_Online_DE.pdf");
		occ = ba.analyze_digits(afr.read());
		ba.showBarChart(occ);
		
		// Paper
//		AbstractFileReader afr = new PdfReader("F:\\Studium\\Master\\IT & Medienforensik\\Forensik_Benfords_Law\\TestData\\Benford's Law Paper\\Paper\\IMAGE FORENSICS USING GENERALISED BENFORD'S LAW FOR ACCURATE.pdf");
//		occ = ba.analyze_digits(afr.read());
//		ba.showBarChart(occ);
	}
}
