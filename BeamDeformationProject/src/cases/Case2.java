package cases;

public class Case2{
	
	private double p; // force [N]
	private double l; // total lenght [m]
	private double x; // random lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private double j;	// secInertiaMoment [mm4 -> m4]
	private double q = p*l; // razpredelen tovar
		
	public Case2(double p, double l, double x, double j) {
		this.p = p;
		this.l = l;
		this.x = x;
		this.j = j;
	}

	public double getMaxMoment() {
		return (q*l)/2;
	}


	public double getxMoment() {
		return (int) ((p*Math.pow(x, 2))/2);
	}


	public double getDeformationAtP() {
		return ((p*Math.pow(l, 4))/(8*e*j));
	}


	public double getReactionAtA() {
		return q;
	}


	public double getReactionAtB() {
		// TODO Auto-generated method stub
		return 0;
	}

}
