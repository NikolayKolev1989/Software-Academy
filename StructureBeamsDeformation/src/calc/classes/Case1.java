package calc.classes;

import main.Calculations;

public class Case1 {
	
	private String type;
	private int p; // force [N]
	private int l; // total lenght [m]
	private int x; // random lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private Double j;	// secInertiaMoment [mm4 -> m4]
	
		
	public Case1(int p, int l, int x, String type) {
		this.p = p;
		this.l = l;
		this.x = x;
		this.type = type;
	}

	public int getMaxMoment() {
		return p*l;
	}


	public double getxMoment() {
		return p*x;
	}
	public double getInertia() {
		Calculations calculations = new Calculations(this.type);
		j=calculations.getInertia();
		return j;
	}


	public double getDeformationAtP() {
		
		return ((p*l)/(3*e*j));
	}


	public int getReactionAtA() {
		return 0;
	}


	public int getReactionAtB() {
		// TODO Auto-generated method stub
		return 0;
	}
}
