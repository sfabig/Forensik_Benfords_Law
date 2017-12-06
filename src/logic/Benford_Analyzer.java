package logic;
import java.util.Vector;

public class Benford_Analyzer {
	
	public void analyze_digits(Vector<String> digits) {
		
		double anz1 = 0.0;
		double anz2 = 0.0;
		double anz3 = 0.0;
		double anz4 = 0.0;
		double anz5 = 0.0;
		double anz6 = 0.0;
		double anz7 = 0.0;
		double anz8 = 0.0;
		double anz9 = 0.0;
		int akt;
		
		for (String i : digits) {
			
			akt = Integer.parseInt(i.substring(0, 1));
			
			if(akt == 1) {
				anz1++;
			}
			if(akt == 2) {
				anz2++;
			}
			if(akt == 3) {
				anz3++;
			}
			if(akt == 4) {
				anz4++;
			}
			if(akt == 5) {
				anz5++;
			}
			if(akt == 6) {
				anz6++;
			}
			if(akt == 7) {
				anz7++;
			}
			if(akt == 8) {
				anz8++;
			}
			if(akt == 9) {
				anz9++;
			}
		}
		
		anz1 = anz1 / digits.size();
		anz2 = anz2 / digits.size();
		anz3 = anz3 / digits.size();
		anz4 = anz4 / digits.size();
		anz5 = anz5 / digits.size();
		anz6 = anz6 / digits.size();
		anz7 = anz7 / digits.size();
		anz8 = anz8 / digits.size();
		anz9 = anz9 / digits.size();
		
		System.out.println("1--> Benford: 0,301 Ist: " + anz1);
		System.out.println("2--> Benford: 0,176 Ist: " + anz2);
		System.out.println("3--> Benford: 0,125 Ist: " + anz3);
		System.out.println("4--> Benford: 0,097 Ist: " + anz4);
		System.out.println("5--> Benford: 0,079 Ist: " + anz5);
		System.out.println("6--> Benford: 0,067 Ist: " + anz6);
		System.out.println("7--> Benford: 0,058 Ist: " + anz7);
		System.out.println("8--> Benford: 0,051 Ist: " + anz8);
		System.out.println("9--> Benford: 0,046 Ist: " + anz9);
		
	}
}
