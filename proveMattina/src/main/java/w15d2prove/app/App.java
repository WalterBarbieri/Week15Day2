package w15d2prove.app;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import w15d2prove.entities.Student;
import w15d2prove.entities.StudentsDao;
import w15d2prove.util.JpaUtil;

public class App {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Ciao");

		Student mangia = new Student("Mangia", "Lamela");

		StudentsDao sd = new StudentsDao(em);

		// ************* SAVE **************
		// sd.save(mangia);

		// ************ FIND BY ID **************

		Student myStudentFromDb = sd.findById(UUID.fromString("1cee9b9d-03d7-4182-8937-aef5fe664f10"));
		System.out.println(myStudentFromDb);

		// ************ DELETE BY ID **************

		// sd.findByIdAndDelete(UUID.fromString("20416809-7be0-47ea-9c94-89dc5a06bb3c"));

		// ************ REFRESH ******************
		sd.refresh(UUID.fromString("383cfda4-c46b-4fea-8c4a-5d93c7cc59ee"));

		// entitymanager e entitymanagerfactory devono essere chiusi come lo scanner
		em.close();
		emf.close();

	}

}
