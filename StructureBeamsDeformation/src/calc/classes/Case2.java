package calc.classes;

public class Case2{
	
	private String type;
	private int p; // force [N]
	private int l; // total lenght [m]
	private int x; // random lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private long j;	// secInertiaMoment [mm4 -> m4]
	private int q = p*l; // razpredelen tovar
		
	public Case2(int p, int l, int x, long j, int q) {
		this.p = p;
		this.l = l;
		this.x = x;
		this.j = j;
		this.q = q;
	}

	public int getMaxMoment() {
		return (q*l)/2;
	}


	public double getxMoment() {
		return (int) ((p*Math.pow(x, 2))/2);
	}


	public double getDeformationAtP() {
		return ((p*Math.pow(l, 4))/(8*e*j));
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
