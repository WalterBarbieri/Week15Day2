package w15d2esercizio.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import w15d2esercizio.entities.Evento;

public class EventiDao {
	private final EntityManager em;

	public EventiDao(EntityManager em) {
		this.em = em;
	}

	public void save(Evento s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Evento salvato con successo!");
	}

	public Evento searchById(long id) {
		Evento found = em.find(Evento.class, id);

		if (found != null) {
			return found;
		} else {
			System.out.println("Evento non trovato");
		}

		return null;
	}

	public void searchAndDestroy(long id) {
		Evento found = em.find(Evento.class, id);

		if (found != null) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();

			System.out.println("Evento eliminato correttamente");
		} else {
			System.out.println("Evento non trovato");
		}
	}

	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);

		found.setDescrizione("Questa Descrizione non è adatta ai minori");
		found.setTitolo("Vietato");

		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);

		System.out.println("POST REFRESH");

		System.out.println(found);

	}

}
