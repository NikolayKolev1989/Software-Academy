package calc.classes;

public class Case4{
	
	private String type;
	private int p; // force [N]
	private int l; // total lenght [m]
	private int x; // random lenght [m]
	private int x1; // random lenght 2 [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private long j;	// secInertiaMoment [mm4 -> m4]
	private int q = (p*l)/2; // razpredelen tovar
	private int a; // lenght from point A to p [m]
	private int b; // lenght from point B to p [m]
	private int reactA = (p*b)/l;
	private int reactB = (p*a)/l;


	public Case4(int p, int l, int x, int x1, long j, int q, int a, int b) {
		this.p = p;
		this.l = l;
		this.x = x;
		this.x1 = x1;
		this.j = j;
		this.q = q;
		this.a = a;
		this.b = b;

	}

	public int getMaxMoment() {
		return reactA *a;
	}

	public double getxMoment() {
		return reactB * x;
	}

	public double getDeformationAtP() {
		return (p*Math.pow(a, 2)*Math.pow(a, 2))/(3*e*j*l);
	}

	public int getReactionAtA() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getReactionAtB() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int x1Moment () {
		return reactA* x1;
	}

}
