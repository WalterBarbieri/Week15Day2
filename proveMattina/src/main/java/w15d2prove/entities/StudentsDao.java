package w15d2prove.entities;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentsDao {
	private final EntityManager em;

	public StudentsDao(EntityManager em) {
		this.em = em;
	}

	public void save(Student s) {
		EntityTransaction t = em.getTransaction();
		t.begin(); // inizia transaction

		em.persist(s); // oggetto aggiunto al persistence context ma ancora non salvato nel db

		t.commit(); // conclude transaction e salva l'oggetto nel db

		System.out.println("Studente salvato correttamente");
	}

	public Student findById(UUID id) {
		Student found = em.find(Student.class, id);
		if (found != null) {
			return found;
		} else {
			System.out.println("Studente non trovato");
		}
		return null;

	}

	public void findByIdAndDelete(UUID id) {
		Student found = em.find(Student.class, id);

		if (found != null) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();
			System.out.println("Studente eliminato correttamente");
		} else {
			System.out.println("Studente non trovato");
		}
	}

	public void refresh(UUID id) {
		Student found = em.find(Student.class, id);

		found.setFirstName("Fischia");
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);

		System.out.println("POST REFRESH");

		System.out.println(found);

	}
}
