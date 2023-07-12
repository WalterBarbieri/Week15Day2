package w15d2esercizio.Dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import w15d2esercizio.entities.Persona;

public class PersonaDao {
	private final EntityManager em;

	public PersonaDao(EntityManager em) {
		this.em = em;
	}

	public void save(Persona s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Persona salvato con successo!");
	}

	public Persona searchById(UUID id) {
		Persona found = em.find(Persona.class, id);

		if (found != null) {
			return found;
		} else {
			System.out.println("Persona non trovato");
		}

		return null;
	}

	public void searchAndDestroy(UUID id) {
		Persona found = em.find(Persona.class, id);

		if (found != null) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();

			System.out.println("Persona eliminato correttamente");
		} else {
			System.out.println("Persona non trovato");
		}
	}

//	public void refresh(UUID id) {
//		Persona found = em.find(Persona.class, id);
//
//		found.setDescrizione("Questa Descrizione non è adatta ai minori");
//		found.setTitolo("Vietato");
//
//		System.out.println("PRE REFRESH");
//		System.out.println(found);
//		em.refresh(found);
//
//		System.out.println("POST REFRESH");
//
//		System.out.println(found);
//
//	}
}
