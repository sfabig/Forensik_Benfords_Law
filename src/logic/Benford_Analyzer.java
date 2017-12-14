package logic;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Benford_Analyzer {
	
	public Vector<Double> analyze_digits(Vector<String> digits) {
		
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
		
		
		Vector<Double> occurences = new Vector<>();
		occurences.add(anz1);
		occurences.add(anz2);
		occurences.add(anz3);
		occurences.add(anz4);
		occurences.add(anz5);
		occurences.add(anz6);
		occurences.add(anz7);
		occurences.add(anz8);
		occurences.add(anz9);
		
		return occurences;
	}
	
	public void showBarChart(Vector<Double> occurences) {
		JFrame resultWindow = new JFrame("Auswertung");
		final CategoryDataset dataset =createDataset(occurences);
		
		JFreeChart barChart = ChartFactory.createBarChart(
				"Auswertung Benford", 
				"Ziffern", 
				"Häufigkeiten", 
				dataset, 
				PlotOrientation.VERTICAL, 
				true, true, false);
		
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(560, 367));
		resultWindow.setContentPane(chartPanel);
		resultWindow.pack();
		resultWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resultWindow.setVisible(true);
		
	}

	private CategoryDataset createDataset(Vector<Double> occurences) {
		//Categories
		final String x1 = "1";
		final String x2 = "2";
		final String x3 = "3";
		final String x4 = "4";
		final String x5 = "5";
		final String x6 = "6";
		final String x7 = "7";
		final String x8 = "8";
		final String x9 = "9";

		final String b = "Benford";
		final String d = "Ist";
		
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		// add Benford-Digits
		dataset.addValue(0.301, b, x1);
		dataset.addValue(0.176, b, x2);
		dataset.addValue(0.125, b, x3);
		dataset.addValue(0.097, b, x4);
		dataset.addValue(0.079, b, x5);
		dataset.addValue(0.067, b, x6);
		dataset.addValue(0.058, b, x7);
		dataset.addValue(0.051, b, x8);
		dataset.addValue(0.046, b, x9);
		
		// add digits to analyze
		dataset.addValue(occurences.elementAt(0), d, x1);
		dataset.addValue(occurences.elementAt(1), d, x2);
		dataset.addValue(occurences.elementAt(2), d, x3);
		dataset.addValue(occurences.elementAt(3), d, x4);
		dataset.addValue(occurences.elementAt(4), d, x5);
		dataset.addValue(occurences.elementAt(5), d, x6);
		dataset.addValue(occurences.elementAt(6), d, x7);
		dataset.addValue(occurences.elementAt(7), d, x8);
		dataset.addValue(occurences.elementAt(8), d, x9);
		
		return dataset;
	};
}
