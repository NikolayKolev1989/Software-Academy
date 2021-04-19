package upnCases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

public class TestMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
		
		Query query = (Query) em.createNativeQuery("SELECT * FROM upn");
		
	}

}
