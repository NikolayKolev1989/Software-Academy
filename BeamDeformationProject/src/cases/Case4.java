package cases;

public class Case4 {

	private double p; // force [N]
	private double l; // total lenght [m]
	private double x; // random lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private double j; // secInertiaMoment [mm4 -> m4]

	public Case4(double p, double l, double x, double j) {
		this.p = p;
		this.l = l;
		this.j = j;
		this.x = x;
	}

	public double getMaxMoment() {
		return (p * l) / 4;
	}

	public double getxMoment() {
		return (p * x) / 2;
	}

	public double getDeformationAtP() {
		return (p * Math.pow(l, 3)) / (40 * e * j);
	}

	public double getReactionAtA() {
		// TODO Auto-generated method stub
		return p / 2;
	}

	public double getReactionAtB() {
		// TODO Auto-generated method stub
		return p / 2;
	}

}
