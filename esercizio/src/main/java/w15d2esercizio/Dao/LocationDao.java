package w15d2esercizio.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import w15d2esercizio.entities.Location;

public class LocationDao {
	private final EntityManager em;

	public LocationDao(EntityManager em) {
		this.em = em;
	}

	public void save(Location s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Location salvato con successo!");
	}

	public Location searchById(long id) {
		Location found = em.find(Location.class, id);

		if (found != null) {
			return found;
		} else {
			System.out.println("Location non trovato");
		}

		return null;
	}

	public void searchAndDestroy(long id) {
		Location found = em.find(Location.class, id);

		if (found != null) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();

			System.out.println("Location eliminato correttamente");
		} else {
			System.out.println("Location non trovato");
		}
	}

//	public void refresh(long id) {
//		Location found = em.find(Location.class, id);
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
