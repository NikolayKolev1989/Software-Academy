package rhsCases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RHSCase1 {

	private String type;
	private int p; // force [N]
	private int l; // total lenght [m]
	private int x; // random lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private long j;	// secInertiaMoment [mm4 -> m4]

	
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
//	EntityManager em = emf.createEntityManager();
//	EntityTransaction tx = em.getTransaction();

	public RHSCase1(String type, int l, int x, int p) {
		this.type = type;
		this.l = l;
		this.x = x;
		this.p = p;

		switch (type) {
		case "RHS+50x30x2.6":
			break;
		case "RHS+50x30x3.2":
			break;
		case "RHS+50x30x4":
			break;
		case "RHS+50x30x5":
			break;
		case "RHS+60x40x2.6":
			break;
		case "RHS+60x40x3.2":
			break;
		case "RHS+60x40x4":
			break;
		case "RHS+60x40x5":
			break;
		case "RHS+60x40x6.3":
			break;
		case "RHS+80x40x3.2":
			break;
		case "RHS+80x40x4":
			break;
		case "RHS+80x40x5":
			break;
		case "RHS+80x40x6.3":
			break;
		case "RHS+80x40x8":
			break;
		case "RHS+90x50x3.2":
			break;
		case "RHS+90x50x4":
			break;
		case "RHS+90x50x5":
			break;
		case "RHS+90x50x6.3":
			break;
		case "RHS+90x50x8":
			break;
		case "RHS+100x50x3.2":
			break;
		case "RHS+100x50x4":
			break;
		case "RHS+100x50x5":
			break;
		case "RHS+100x50x6.3":
			break;
		case "RHS+100x50x8":
			break;
		case "RHS+100x60x3.2":
			break;
		case "RHS+100x60x4":
			break;
		case "RHS+100x60x5":
			break;
		case "RHS+100x60x6.3":
			break;
		case "RHS+100x60x8":
			break;
		case "RHS+120x60x4":
			break;
		case "RHS+120x60x5":
			break;
		case "RHS+120x60x6.3":
			break;
		case "RHS+120x60x8":
			break;
		case "RHS+120x60x10":
			break;
		case "RHS+120x80x4":
			break;
		case "RHS+120x80x5":
			break;
		case "RHS+120x80x6.3":
			break;
		case "RHS+120x80x8":
			break;
		case "RHS+120x80x10":
			break;
		case "RHS+140x80x4":
			break;
		case "RHS+140x80x5":
			break;
		case "RHS+140x80x6.3":
			break;
		case "RHS+140x80x8":
			break;
		case "RHS+140x80x10":
			break;
		case "RHS+150x100x4":
			break;
		case "RHS+150x100x5":
			break;
		case "RHS+150x100x6.3":
			break;
		case "RHS+150x100x8":
			break;
		case "RHS+150x100x10":
			break;
		case "RHS+150x100x12.5":
			break;
		case "RHS+160x80x4":
			break;
		case "RHS+160x80x5":
			break;
		case "RHS+160x80x6.3":
			break;
		case "RHS+160x80x8":
			break;
		case "RHS+160x80x10":
			break;
		case "RHS+160x80x12.5":
			break;
		case "RHS+180x100x4":
			break;
		case "RHS+180x100x5":
			break;
		case "RHS+180x100x6.3":
			break;
		case "RHS+180x100x8":
			break;
		case "RHS+180x100x10":
			break;
		case "RHS+180x100x12.5":
			break;
		case "RHS+200x100x4":
			break;
		case "RHS+200x100x5":
			break;
		case "RHS+200x100x6.3":
			break;
		case "RHS+200x100x8":
			break;
		case "RHS+200x100x10":
			break;
		case "RHS+200x100x12.5":
			break;
		case "RHS+200x100x16":
			break;
		case "RHS+200x120x6.3":
			break;
		case "RHS+200x120x8":
			break;
		case "RHS+200x120x10":
			break;
		case "RHS+200x120x12.5":
			break;
		case "RHS+250x150x6.3":
			break;
		case "RHS+250x150x8":
			break;
		case "RHS+250x150x10":
			break;
		case "RHS+250x150x12.5":
			break;
		case "RHS+250x150x14.2":
			break;
		case "RHS+250x150x16":
			break;
		case "RHS+260x180x6.3":
			break;
		case "RHS+260x180x8":
			break;
		case "RHS+260x180x10":
			break;
		case "RHS+260x180x12.5":
			break;
		case "RHS+260x180x14.2":
			break;
		case "RHS+260x180x16":
			break;
		case "RHS+300x200x6.3":
			break;
		case "RHS+300x200x8":
			break;
		case "RHS+300x200x10":
			break;
		case "RHS+300x200x12.5":
			break;
		case "RHS+300x200x14.2":
			break;
		case "RHS+300x200x16":
			break;
		case "RHS+350x250x6.3":
			break;
		case "RHS+350x250x8":
			break;
		case "RHS+350x250x10":
			break;
		case "RHS+350x250x12.5":
			break;
		case "RHS+350x250x14.2":
			break;
		case "RHS+350x250x16":
			break;
		case "RHS+400x200x8":
			break;
		case "RHS+400x200x10":
			break;
		case "RHS+400x200x12.5":
			break;
		case "RHS+400x200x14.2":
			break;
		case "RHS+400x200x16":
			break;
		case "RHS+450x250x8":
			break;
		case "RHS+450x250x10":
			break;
		case "RHS+450x250x12.5":
			break;
		case "RHS+450x250x14.2":
			break;
		case "RHS+450x250x16":
			break;
		case "RHS+500x300x10":
			break;
		case "RHS+500x300x12.5":
			break;
		case "RHS+500x300x14.2":
			break;
		case "RHS+500x300x16":
			break;
		case "RHS+500x300x20":
			break;

		default:
			break;
		}
	}
	
	public int maxMoment () {
		return p*l;
	}
	public int xMoment () {
		return p*x;
	}
	public double deformationAtP () {
		return ((p*l)/(3*e*j));
	}

}
