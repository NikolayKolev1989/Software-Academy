package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import db.CircularHollowSection;
import db.EqualAngleL;
import db.RectangularHollowSection;
import db.SquareHollowSection;
import db.UnequalAngleL;

public class Calculations2 {
	
	private CircularHollowSection chs;
	private EqualAngleL le;
	private UnequalAngleL lu;
	private RectangularHollowSection rhs;
	private SquareHollowSection shs;
	private String type;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
	EntityManager em = emf.createEntityManager();
	
	public Calculations2() {
	}
	
	
	public Double getInetria() {
		if (type.contains("CHS")) {
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
//			EntityManager em = emf.createEntityManager();
			chs = em.find(CircularHollowSection.class, type);
			return (chs.getInertia() / 1000000000000L);
		}
		if (type.contains("RHS")) {
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
//			EntityManager em = emf.createEntityManager();
			rhs=em.find(RectangularHollowSection.class, type);
			return (rhs.getInertia()/ 1000000000000L);
		}
		if (type.contains("SHS")) {
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
//			EntityManager em = emf.createEntityManager();
			shs=em.find(SquareHollowSection.class, type);
			return (shs.getInertia()/ 1000000000000L);
		}
		if (type.contains("Le")) {
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
//			EntityManager em = emf.createEntityManager();
			le=em.find(EqualAngleL.class, type);
			return (le.getInertia()/ 1000000000000L);
		}
		if (type.contains("Lu")) {
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
//			EntityManager em = emf.createEntityManager();
			lu=em.find(UnequalAngleL.class, type);
			return (lu.getInertia()/ 1000000000000L);
		}
		return null;
		
	}
}
