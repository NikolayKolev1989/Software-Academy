package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import calc.classes.Case1;


public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
//		Pipe pipe = em.find(Pipe.class, "ÜPN+120");
//		System.out.println(pipe.getType() + " poluchi se " + pipe.getValue()+1);
//		
//		em.close();
//		emf.close();
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
//		EntityManager em = emf.createEntityManager();
//		CircularHollowSection chs = em.find(CircularHollowSection.class, "CHS+21.3x2.3");
//		System.out.println(chs.getInertia());
//		em.close();
//		emf.close();
		
		Calculations profile = new Calculations("CHS+21.3x2.3");
		System.out.println(profile.getInertia());
		
//		Case1 case1 = new Case1(1, 2, 3, "CHS+21.3x2.3");
//		System.out.println(case1.getInertia());
	}

}
