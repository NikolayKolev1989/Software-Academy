package calc.classes;

public abstract class Base {
	
	private int p; // force [N]
	private int l; // total lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private long j;	// secInertiaMoment [mm4 -> m4]

	public Base(long j, int p, int l) {
		this.j = j;
		this.p = p;
		this.l = l;
	}
	
	public abstract int getReactionAtA ();
	public abstract int getReactionAtB ();
	public abstract int getMaxMoment ();
	public abstract double getxMoment ();
	public abstract double getDeformationAtP ();
}
