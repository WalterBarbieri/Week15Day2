package w15d2prove.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import w15d2prove.entities.StudentsDao;
import w15d2prove.util.JpaUtil;

public class App {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Ciao");

		StudentsDao sd = new StudentsDao(em);

	}

}
