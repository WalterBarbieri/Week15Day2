package w15d2prove.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentsDao {
	private final EntityManager em;

	public StudentsDao(EntityManager em) {
		this.em = em;
	}

	public void save(Student s) {
		EntityTransaction t = em.getTransaction();
	}

	public void findById(long id) {

	}

	public void findByIdAndDelete(long id) {

	}
}
