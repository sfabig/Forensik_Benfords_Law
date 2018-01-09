package logic;

public class Regression {
	private double w1;
	private double w0;
	
	public Regression(double[] ds) {
		calculateGerade(ds);
	}

	private void calculateGerade(double[] y) {
		double[] x = new double[] {1,2,3,4,5,6,7,8,9};
		final int N = 9;
		double summeX = 0;
		double summeY = 0;
		double[] xMalY = new double[9];
		double[] xQuadrat = new double[9];
		double summeXMalY = 0;
		double summeXQuadrat = 0;
		
		for(int i = 0; i < N; i++) {
			xMalY[i] = x[i] * y[i];
			xQuadrat[i] = x[i]*x[i];
			summeX = summeX + x[i];
			summeY = summeY + y[i];
			summeXMalY = summeXMalY + xMalY[i];
			summeXQuadrat = summeXQuadrat + xQuadrat[i];
		}
		double zaehler = N * summeXMalY - summeX * summeY;
		double nenner = N * summeXQuadrat - (summeX * summeX);
		System.out.println("N: " + N);
		System.out.println("Summe X: " + summeX);
		System.out.println("Summe Y :" + summeY);
		System.out.println("Summe X * Y: " + summeXMalY);
		System.out.println("Summe X^2: " + summeXQuadrat);
		System.out.println("Zähler: " + zaehler);
		System.out.println("Nenner: " + nenner);
		this.w1 = zaehler / nenner;
		System.out.println(1.0/N * summeY);
		System.out.println(this.w1/N * summeX);
		this.w0 = 1.0/N * summeY - this.w1/N * summeX;
		System.out.println("W1: " + this.w1);
		System.out.println("W0: " + this.w0);
	}

	public double getW1() {
		return w1;
	}

	public void setW1(double m1) {
		this.w1 = m1;
	}

	public double getW0() {
		return w0;
	}

	public void setW0(double m2) {
		this.w0 = m2;
	}
}
