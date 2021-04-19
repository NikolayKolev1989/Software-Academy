package chsCases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CHSCase4 {

	private String type;
	private int p; // force [N]
	private int l; // total lenght [m]
	private int x; // random lenght 1 [m]
	private int x1; // random lenght 2 [m]
	private int a; // lenght from point A to p [m]
	private int b; // lenght from point B to p [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private long j;	// secInertiaMoment [mm4 -> m4]
	private int reactA = (p*b)/l;
	private int reactB = (p*a)/l;

	
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
//	EntityManager em = emf.createEntityManager();
//	EntityTransaction tx = em.getTransaction();

	public CHSCase4(String type, int l, int x, int p) {
		this.type = type;
		this.l = l;
		this.x = x;
		this.p = p;

		switch (type) {
		case "UPN50":
			break;
		case "UPN 50":
			break;
		case "UPN 65":
			break;
		case "UPN 80":
			break;
		case "UPN 100":
			break;
		case "UPN 120":
			break;
		case "UPN 140":
			break;
		case "UPN 160":
			break;
		case "UPN 180":
			break;
		case "UPN 200":
			break;
		case "UPN 220":
			break;
		case "UPN 240":
			break;
		case "UPN 260":
			break;
		case "UPN 280":
			break;
		case "UPN 300":
			break;
		case "UPN 320":
			break;
		case "UPN 350":
			break;
		case "UPN 380":
			break;
		case "UPN 400":
			break;

		default:
			break;
		}
	}
	
	public int maxMoment () {
		return reactA *a;
	}
	public int xMoment () {
		return reactB * x;
	}
	public int x1Moment () {
		return reactA* x1;
	}
	public double deformationAtP () {
		return (p*Math.pow(a, 2)*Math.pow(a, 2))/(3*e*j*l);
	}
//	public double deformationAtX () {
//		if (a < b) {
//			return (p*Math.pow(a, 2)*Math.pow(a, 2))/(3*e*j*l);
//		}else if(a > b) {
//			return (p*Math.pow(a, 2)*Math.pow(a, 2))/(3*e*j*l);
//		} else {
//			return (p*Math.pow(a, 2)*Math.pow(a, 2))/(3*e*j*l);
//		}
//	}

}
