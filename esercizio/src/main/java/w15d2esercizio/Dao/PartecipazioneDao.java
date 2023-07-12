package w15d2esercizio.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import w15d2esercizio.entities.Partecipazione;

public class PartecipazioneDao {
	private final EntityManager em;

	public PartecipazioneDao(EntityManager em) {
		this.em = em;
	}

	public void save(Partecipazione s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Partecipazione salvato con successo!");
	}

	public Partecipazione searchById(long id) {
		Partecipazione found = em.find(Partecipazione.class, id);

		if (found != null) {
			return found;
		} else {
			System.out.println("Partecipazione non trovato");
		}

		return null;
	}

	public void searchAndDestroy(long id) {
		Partecipazione found = em.find(Partecipazione.class, id);

		if (found != null) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();

			System.out.println("Partecipazione eliminato correttamente");
		} else {
			System.out.println("Partecipazione non trovato");
		}
	}
}
