package cases;

public abstract class Base {
	private double p; // force [N]
	private double l; // total lenght [m]
	private double x; // total lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private double j;	// secInertiaMoment [mm4 -> m4]

	public Base(double p, double l, double x, double j) {
		this.j = j;
		this.p = p;
		this.l = l;
		this.x = x;
	}
	
	public abstract double getReactionAtA ();
	public abstract double getReactionAtB ();
	public abstract double getMaxMoment ();
	public abstract double getxMoment ();
	public abstract double getDeformationAtP ();
}
