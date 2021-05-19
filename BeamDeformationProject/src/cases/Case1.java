package cases;


public class Case1 {
	
	private double p; // force [N]
	private double l; // total lenght [m]
	private double x; // random lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private double j;	// secInertiaMoment [mm4 -> m4]
	
		
	public Case1(double p, double l, double x, double j) {
		this.p = p;
		this.l = l;
		this.x = x;
		this.j = j;
	}

	public double getMaxMoment() {
		return p*l;
	}


	public double getxMoment() {
		return p*x;
	}

	public double getDeformationAtP() {
		
		return ((p*l)/(3*e*j));
	}

	public double getReactionAtA() {
		return p;
	}


	public double getReactionAtB() {
		// TODO Auto-generated method stub
		return 0;
	}
}
