package Cases;

import javax.swing.*;

public class Case1 extends JPanel {
	
	
	private double p;		//force
	private double l;		//beam lenght
	private double x;		//distance to y
	private double a;		//reaction
	private double y;		//
	private double mmax;	// max bending moment
	private double mx;		// bending moment from x
	private double fmax;	// max deformation
	private double e;		//elastic modulus
	private double j;		//moment of inertia 
	
	public Case1(){
		a = p;
		mmax = p*l;
		mx = p*x;
		fmax = (p*l)/(3*e*j);
	}
	
	
}
