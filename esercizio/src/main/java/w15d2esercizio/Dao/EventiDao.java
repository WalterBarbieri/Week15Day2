package w15d2esercizio.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import w15d2esercizio.Enums.TipoConcerto;
import w15d2esercizio.entities.Concerto;
import w15d2esercizio.entities.Evento;
import w15d2esercizio.gestioneventi.App;

public class EventiDao {
	private static Logger log = LoggerFactory.getLogger(App.class);
	private final EntityManager em;

	public EventiDao(EntityManager em) {
		this.em = em;
	}

	public void save(Evento s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		log.info("Evento salvato con successo!");
	}

	public Evento searchById(long id) {
		Evento found = em.find(Evento.class, id);

		if (found != null) {
			return found;
		} else {
			log.info("Evento non trovato");
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

			log.info("Evento eliminato correttamente");
		} else {
			log.info("Evento non trovato");
		}
	}

	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);

		found.setDescrizione("Questa Descrizione non è adatta ai minori");
		found.setTitolo("Vietato");

		log.info("PRE REFRESH");
		log.info(found.toString());
		em.refresh(found);

		log.info("POST REFRESH");

		log.info(found.toString());

	}

	public List<Concerto> getConcertiStreaming(Boolean myBoo) {
		TypedQuery<Concerto> getAllQuery = em.createQuery("SELECT a FROM Concerto a where inStreaming = :boolean",
				Concerto.class);
		getAllQuery.setParameter("boolean", myBoo);
		return getAllQuery.getResultList();
	}

	public List<Concerto> getConcertiPerGenere(TipoConcerto genere) {
		TypedQuery<Concerto> getAllQuery = em.createQuery("SELECT a FROM Concerto a WHERE genere = :genere",
				Concerto.class);
		getAllQuery.setParameter("genere", genere);
		return getAllQuery.getResultList();
	}

}
