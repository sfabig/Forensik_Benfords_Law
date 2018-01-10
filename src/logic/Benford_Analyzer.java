package logic;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import logic.Regression;
public class Benford_Analyzer {
	private Regression regressionGerade;
	private double benfordError = 0;
	private double regressionError = 0;
	private double normalError = 0;
	
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

		regressionGerade = new Regression(new double[] {anz1,anz2,anz3,anz4,anz5,anz6,anz7,anz8,anz9});

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
		
		berechneFehler(occurences);
		return occurences;
	}
	
	private void berechneFehler(Vector<Double> occurences) {
		List<Double> benfordVerteilung = new ArrayList<Double>();
		benfordVerteilung.add(0.301);
		benfordVerteilung.add(0.176);
		benfordVerteilung.add(0.125);
		benfordVerteilung.add(0.097);
		benfordVerteilung.add(0.079);
		benfordVerteilung.add(0.067);
		benfordVerteilung.add(0.058);
		benfordVerteilung.add(0.051);
		benfordVerteilung.add(0.046);
		
		for(int i = 0; i < occurences.size(); i++) {
			benfordError += (benfordVerteilung.get(i) - occurences.get(i)) * (benfordVerteilung.get(i) - occurences.get(i));
			normalError += (1.0/9 - occurences.get(i)) * (1.0/9 - occurences.get(i));
			regressionError += ((regressionGerade.getW1() * (i+1) + regressionGerade.getW0()) - occurences.get(i))
					* ((regressionGerade.getW1() * (i+1) + regressionGerade.getW0()) - occurences.get(i));
		}
		
		benfordError /= 9;
		normalError /= 9;
		regressionError /= 9;
	}

	public void showBarChart(Vector<Double> occurences) {
		JFrame resultWindow = new JFrame("Auswertung");
		final CategoryDataset datasetBenford =createDataset(occurences);
		final DefaultCategoryDataset datasetRegression = new DefaultCategoryDataset();
		final DefaultCategoryDataset datasetNormalverteilung = new DefaultCategoryDataset();
		
		datasetRegression.addValue(regressionGerade.getW1() * 1 + regressionGerade.getW0(), "Regressionsgerade", "1");
		datasetRegression.addValue(regressionGerade.getW1() * 2 + regressionGerade.getW0(), "Regressionsgerade", "2");
		datasetRegression.addValue(regressionGerade.getW1() * 3 + regressionGerade.getW0(), "Regressionsgerade", "3");
		datasetRegression.addValue(regressionGerade.getW1() * 4 + regressionGerade.getW0(), "Regressionsgerade", "4");
		datasetRegression.addValue(regressionGerade.getW1() * 5 + regressionGerade.getW0(), "Regressionsgerade", "5");
		datasetRegression.addValue(regressionGerade.getW1() * 6 + regressionGerade.getW0(), "Regressionsgerade", "6");
		datasetRegression.addValue(regressionGerade.getW1() * 7 + regressionGerade.getW0(), "Regressionsgerade", "7");
		datasetRegression.addValue(regressionGerade.getW1() * 8 + regressionGerade.getW0(), "Regressionsgerade", "8");
		datasetRegression.addValue(regressionGerade.getW1() * 9 + regressionGerade.getW0(), "Regressionsgerade", "9");

		datasetNormalverteilung.addValue(1.0/9, "Normalverteilung", "1");
		datasetNormalverteilung.addValue(1.0/9, "Normalverteilung", "2");
		datasetNormalverteilung.addValue(1.0/9, "Normalverteilung", "3");
		datasetNormalverteilung.addValue(1.0/9, "Normalverteilung", "4");
		datasetNormalverteilung.addValue(1.0/9, "Normalverteilung", "5");
		datasetNormalverteilung.addValue(1.0/9, "Normalverteilung", "6");
		datasetNormalverteilung.addValue(1.0/9, "Normalverteilung", "7");
		datasetNormalverteilung.addValue(1.0/9, "Normalverteilung", "8");
		datasetNormalverteilung.addValue(1.0/9, "Normalverteilung", "9");
		
		final CategoryPlot plot = new CategoryPlot();
		// Add the first dataset and render as bar
		CategoryItemRenderer lineRenderer1 = new LineAndShapeRenderer();
		plot.setDataset(0, datasetRegression);
		plot.setRenderer(0, lineRenderer1);

		CategoryItemRenderer lineRenderer2 = new LineAndShapeRenderer();
		plot.setDataset(1, datasetNormalverteilung);
		plot.setRenderer(1, lineRenderer2);
		
		// Add the second dataset and render as lines
		CategoryItemRenderer baRenderer = new BarRenderer();
		plot.setDataset(2, datasetBenford);
		plot.setRenderer(2, baRenderer);
		
	    plot.setDomainAxis(new CategoryAxis("Ziffer"));
	    plot.setRangeAxis(new NumberAxis("Häufigkeit"));
	    
	    JFreeChart chart = new JFreeChart("Auswertung Benford",null, plot, true);
	    LegendTitle legendTitle = chart.getLegend();
	    List<Title> subtitles = new ArrayList<Title>();
	    subtitles.add(new TextTitle("Benford Fehler: " + benfordError + " MSE"));
	    subtitles.add(new TextTitle("Regression Fehler: " + regressionError + " MSE"));
	    subtitles.add(new TextTitle("Normalverteilung Fehler: " + normalError + " MSE"));
	    chart.setSubtitles(subtitles);
	    chart.addLegend(legendTitle);
	    
	    ChartPanel chartPanel = new ChartPanel(chart);
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

		final String b = "Benford-Verteilung";
		final String d = "Ist-Verteilung";
		
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
