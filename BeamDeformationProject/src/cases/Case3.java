package cases;

public class Case3 {

	private double p; // force [N]
	private double l; // total lenght [m]
	private double x; // random lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private double j; // secInertiaMoment [mm4 -> m4]
	private double q = (p * l) / 2; // razpredelen tovar

	public Case3(double p, double l, double x, double j) {
		this.p = p;
		this.l = l;
		this.x = x;
		this.j = j;
	}

	public double getMaxMoment() {
		return (q * l) / 3;
	}

	public double getxMoment() {
		return ((p * Math.pow(x, 3)) / (6 * l));
	}

	public double getDeformationAtP() {
		return ((p * Math.pow(l, 4)) / (30 * e * j));
	}

	public double getReactionAtA() {
		// TODO Auto-generated method stub
		return q;
	}

	public double getReactionAtB() {
		// TODO Auto-generated method stub
		return 0;
	}

}
