package calc.classes;

public class Case5{
	
	private String type;
	private int p; // force [N]
	private int l; // total lenght [m]
	private int x; // random lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private long j;	// secInertiaMoment [mm4 -> m4]
	private int q = (p*l)/2; // razpredelen tovar

	public Case5(int p, int l, int x, long j) {
		super();
		this.p = p;
		this.l = l;
		this.x = x;
		this.j = j;
	}

	public int getMaxMoment() {
		return (p*l)/4;
	}
	
	public double getxMoment() {
		return (p*x)/2;
	}

	public double getDeformationAtP() {
		return (p*Math.pow(l, 3))/(40*e*j);
	}

	public int getReactionAtA() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getReactionAtB() {
		// TODO Auto-generated method stub
		return 0;
	}

}
