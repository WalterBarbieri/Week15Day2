package w15d2esercizio.gestioneventi;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Enums.TipoEvento;
import w15d2esercizio.Dao.EventiDao;
import w15d2esercizio.entities.Evento;
import w15d2esercizio.utils.JpaUtil;

public class App {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		System.out.println("Non è scoppiato");
		// CREATE AND SAVE EVENT
		Evento mare = new Evento("Gita al Fiume", LocalDate.now(), "Andiamo a pescare", TipoEvento.PRIVATO, 10);

		EventiDao ed = new EventiDao(em);

		// ed.save(mare);

		// SEARCH BY ID

		Evento eventoTrovato = ed.searchById(UUID.fromString("206e303f-13b9-4c5f-8745-5c333cfc7d22"));
		System.out.println(eventoTrovato);

		// SEARCH AND DESTROY

		ed.searchAndDestroy(UUID.fromString("6b10bca4-b9af-446e-8e14-c29078b24ca5"));

		// REFRESH

		ed.refresh(UUID.fromString("5b93ef44-e7d7-4daf-8f21-b052a447e766"));
		// CLOSE EM AND EMF

		em.close();
		emf.close();

	}

}
