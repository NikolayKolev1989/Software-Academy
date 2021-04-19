package chsCases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CHSCase1 {

	private String type;
	private int p; // force [N]
	private int l; // total lenght [m]
	private int x; // random lenght [m]
	private final double e = 2.1e11; // elastic Modulus [MPa -> N/m2]
	private long j;	// secInertiaMoment [mm4 -> m4]

	
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
//	EntityManager em = emf.createEntityManager();
//	EntityTransaction tx = em.getTransaction();

	public CHSCase1(String type, int l, int x, int p) {
		this.type = type;
		this.l = l;
		this.x = x;
		this.p = p;

		switch (type) {
		case "CHS+21.3x2.3":
			break;
		case "CHS+21.3x2.6":
			break;
		case "CHS+21.3x3.2":
			break;
		case "CHS+26.9x2.3":
			break;
		case "CHS+26.9x2.6":
			break;
		case "CHS+26.9x3.2":
			break;
		case "CHS+33.7x2.6":
			break;
		case "CHS+33.7x3.2":
			break;
		case "CHS+33.7x4":
			break;
		case "CHS+42.4x2.6":
			break;
		case "CHS+42.4x3.2":
			break;
		case "CHS+42.4x4":
			break;
		case "CHS+48.3x2.6":
			break;
		case "CHS+48.3x3.2":
			break;
		case "CHS+48.3x4":
			break;
		case "CHS+48.3x5":
			break;
		case "CHS+60.3x2.6":
			break;
		case "CHS+60.3x3.2":
			break;
		case "CHS+60.3x4":
			break;
		case "CHS+60.3x5":
			break;
		case "CHS+76.1x2.6":
			break;
		case "CHS+76.1x3.2":
			break;
		case "CHS+76.1x4":
			break;
		case "CHS+76.1x5":
			break;
		case "CHS+88.9x3.2":
			break;
		case "CHS+88.9x4":
			break;
		case "CHS+88.9x5":
			break;
		case "CHS+88.9x6.3":
			break;
		case "CHS+101.6x3.2":
			break;
		case "CHS+101.6x4":
			break;
		case "CHS+101.6x5":
			break;
		case "CHS+101.6x6.3":
			break;
		case "CHS+101.6x8":
			break;
		case "CHS+101.6x10":
			break;
		case "CHS+114.3x3.2":
			break;
		case "CHS+114.3x4":
			break;
		case "CHS+114.3x5":
			break;
		case "CHS+114.3x6.3":
			break;
		case "CHS+114.3x8":
			break;
		case "CHS+114.3x10":
			break;
		case "CHS+139.7x4":
			break;
		case "CHS+139.7x5":
			break;
		case "CHS+139.7x6.3":
			break;
		case "CHS+139.7x8":
			break;
		case "CHS+139.7x10":
			break;
		case "CHS+139.7x12.5":
			break;
		case "CHS+168.3x4":
			break;
		case "CHS+168.3x5":
			break;
		case "CHS+168.3x6.3":
			break;
		case "CHS+168.3x8":
			break;
		case "CHS+168.3x10":
			break;
		case "CHS+168.3x12.5":
			break;
		case "CHS+177.8x5":
			break;
		case "CHS+177.8x6.3":
			break;
		case "CHS+177.8x8":
			break;
		case "CHS+177.8x10":
			break;
		case "CHS+177.8x12.5":
			break;
		case "CHS+193.7x5":
			break;
		case "CHS+193.7x6.3":
			break;
		case "CHS+193.7x8":
			break;
		case "CHS+193.7x10":
			break;
		case "CHS+193.7x12.5":
			break;
		case "CHS+193.7x14.2":
			break;
		case "CHS+193.7x16":
			break;
		case "CHS+219.1x5":
			break;
		case "CHS+219.1x6.3":
			break;
		case "CHS+219.1x8":
			break;
		case "CHS+219.1x10":
			break;
		case "CHS+219.1x12.5":
			break;
		case "CHS+219.1x14.2":
			break;
		case "CHS+219.1x16":
			break;
		case "CHS+219.1x20":
			break;
		case "CHS+244.5x5":
			break;
		case "CHS+244.5x6.3":
			break;
		case "CHS+244.5x8":
			break;
		case "CHS+244.5x10":
			break;
		case "CHS+244.5x12.5":
			break;
		case "CHS+244.5x14.2":
			break;
		case "CHS+244.5x16":
			break;
		case "CHS+244.5x20":
			break;
		case "CHS+244.5x25":
			break;
		case "CHS+273x5":
			break;
		case "CHS+273x6.3":
			break;
		case "CHS+273x8":
			break;
		case "CHS+273x10":
			break;
		case "CHS+273x12.5":
			break;
		case "CHS+273x14.2":
			break;
		case "CHS+273x16":
			break;
		case "CHS+273x20":
			break;
		case "CHS+273x25":
			break;
		case "CHS+323.9x5":
			break;
		case "CHS+323.9x6.3":
			break;
		case "CHS+323.9x8":
			break;
		case "CHS+323.9x10":
			break;
		case "CHS+323.9x12.5":
			break;
		case "CHS+323.9x14.2":
			break;
		case "CHS+323.9x16":
			break;
		case "CHS+323.9x20":
			break;
		case "CHS+323.9x25":
			break;
		case "CHS+355.6x6.3":
			break;
		case "CHS+355.6x8":
			break;
		case "CHS+355.6x10":
			break;
		case "CHS+355.6x12.5":
			break;
		case "CHS+355.6x14.2":
			break;
		case "CHS+355.6x16":
			break;
		case "CHS+355.6x20":
			break;
		case "CHS+355.6x25":
			break;
		case "CHS+406.4x6.3":
			break;
		case "CHS+406.4x8":
			break;
		case "CHS+406.4x10":
			break;
		case "CHS+406.4x12.5":
			break;
		case "CHS+406.4x14.2":
			break;
		case "CHS+406.4x16":
			break;
		case "CHS+406.4x20":
			break;
		case "CHS+406.4x25":
			break;
		case "CHS+406.4x30":
			break;
		case "CHS+406.4x40":
			break;
		case "CHS+457x6.3":
			break;
		case "CHS+457x8":
			break;
		case "CHS+457x10":
			break;
		case "CHS+457x12.5":
			break;
		case "CHS+457x14.2":
			break;
		case "CHS+457x16":
			break;
		case "CHS+457x20":
			break;
		case "CHS+457x25":
			break;
		case "CHS+457x30":
			break;
		case "CHS+457x40":
			break;
		case "CHS+508x6.3":
			break;
		case "CHS+508x8":
			break;
		case "CHS+508x10":
			break;
		case "CHS+508x12.5":
			break;
		case "CHS+508x14.2":
			break;
		case "CHS+508x16":
			break;
		case "CHS+508x20":
			break;
		case "CHS+508x25":
			break;
		case "CHS+508x30":
			break;
		case "CHS+508x40":
			break;
		case "CHS+508x50":
			break;
		case "CHS+610x6.3":
			break;
		case "CHS+610x8":
			break;
		case "CHS+610x10":
			break;
		case "CHS+610x12.5":
			break;
		case "CHS+610x14.2":
			break;
		case "CHS+610x16":
			break;
		case "CHS+610x20":
			break;
		case "CHS+610x25":
			break;
		case "CHS+610x30":
			break;
		case "CHS+610x40":
			break;
		case "CHS+610x50":
			break;
		case "CHS+711x6.3":
			break;
		case "CHS+711x8":
			break;
		case "CHS+711x10":
			break;
		case "CHS+711x12.5":
			break;
		case "CHS+711x14.2":
			break;
		case "CHS+711x16":
			break;
		case "CHS+711x20":
			break;
		case "CHS+711x25":
			break;
		case "CHS+711x30":
			break;
		case "CHS+711x40":
			break;
		case "CHS+711x50":
			break;
		case "CHS+711x60":
			break;
		case "CHS+762x6":
			break;
		case "CHS+762x6.3":
			break;
		case "CHS+762x8":
			break;
		case "CHS+762x10":
			break;
		case "CHS+762x12.5":
			break;
		case "CHS+762x14.2":
			break;
		case "CHS+762x16":
			break;
		case "CHS+762x20":
			break;
		case "CHS+762x25":
			break;
		case "CHS+762x30":
			break;
		case "CHS+762x40":
			break;
		case "CHS+762x50":
			break;
		case "CHS+813x8":
			break;
		case "CHS+813x10":
			break;
		case "CHS+813x12.5":
			break;
		case "CHS+813x14.2":
			break;
		case "CHS+813x16":
			break;
		case "CHS+813x20":
			break;
		case "CHS+813x25":
			break;
		case "CHS+813x30":
			break;
		case "CHS+914x8":
			break;
		case "CHS+914x10":
			break;
		case "CHS+914x12.5":
			break;
		case "CHS+914x14.2":
			break;
		case "CHS+914x16":
			break;
		case "CHS+914x20":
			break;
		case "CHS+914x25":
			break;
		case "CHS+914x30":
			break;
		case "CHS+1016x8":
			break;
		case "CHS+1016x10":
			break;
		case "CHS+1016x12.5":
			break;
		case "CHS+1016x14.2":
			break;
		case "CHS+1016x16":
			break;
		case "CHS+1016x20":
			break;
		case "CHS+1016x25":
			break;
		case "CHS+1016x30":
			break;
		case "CHS+1067x10":
			break;
		case "CHS+1067x12.5":
			break;
		case "CHS+1067x14.2":
			break;
		case "CHS+1067x16":
			break;
		case "CHS+1067x20":
			break;
		case "CHS+1067x25":
			break;
		case "CHS+1067x30":
			break;
		case "CHS+1168x10":
			break;
		case "CHS+1168x12.5":
			break;
		case "CHS+1168x14.2":
			break;
		case "CHS+1168x16":
			break;
		case "CHS+1168x20":
			break;
		case "CHS+1168x25":
			break;
		case "CHS+1219x10":
			break;
		case "CHS+1219x12.5":
			break;
		case "CHS+1219x16":
			break;
		case "CHS+1219x14.2":
			break;
		case "CHS+1219x20":
			break;
		case "CHS+1219x25":
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
