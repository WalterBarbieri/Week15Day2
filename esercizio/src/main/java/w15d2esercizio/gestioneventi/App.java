package w15d2esercizio.gestioneventi;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import w15d2esercizio.Dao.EventiDao;
import w15d2esercizio.Dao.LocationDao;
import w15d2esercizio.Dao.PartecipazioneDao;
import w15d2esercizio.Dao.PersonaDao;
import w15d2esercizio.Enums.Sesso;
import w15d2esercizio.Enums.Stato;
import w15d2esercizio.Enums.TipoEvento;
import w15d2esercizio.entities.Evento;
import w15d2esercizio.entities.Location;
import w15d2esercizio.entities.Partecipazione;
import w15d2esercizio.entities.Persona;
import w15d2esercizio.utils.JpaUtil;

public class App {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		EventiDao ed = new EventiDao(em);
		PersonaDao pd = new PersonaDao(em);
		LocationDao ld = new LocationDao(em);
		PartecipazioneDao pad = new PartecipazioneDao(em);

		// CREATE AND SAVE EVENT
		Location loc1 = new Location("Piazza dei Miracoli", "Pisa");
		Location loc2 = new Location("Spiagge Bianche", "Lipari");

//		ld.save(loc1);
//		ld.save(loc2);
		Location location1 = ld.searchById(1);
		Location location2 = ld.searchById(2);

		Evento ev1 = new Evento("Gita in Città", LocalDate.now(), "Visitiamo luoghi culturali", TipoEvento.PUBBLICO, 30,
				location1);
		Evento ev2 = new Evento("Gita al Mare", LocalDate.now(), "Andiamo al mare", TipoEvento.PRIVATO, 6, location2);
//		ed.save(ev1);
//		ed.save(ev2);

		Evento event1 = ed.searchById(5);
		Evento event2 = ed.searchById(6);

		Persona p1 = new Persona("Mangia", "Lamela", "123@456.ml", LocalDate.of(1990, 9, 10), Sesso.FEMMINA);
		Persona p2 = new Persona("Bevi", "Labotte", "987@654.bl", LocalDate.of(1980, 3, 21), Sesso.MASCHIO);

//		pd.save(p1);
//		pd.save(p2);

		Persona pers1 = pd.searchById(7);
		Persona pers2 = pd.searchById(8);

		Partecipazione par1 = new Partecipazione(pers1, event1, Stato.DA_CONFERMARE);
		Partecipazione par2 = new Partecipazione(pers2, event2, Stato.CONFERMATA);

//		pad.save(par1);
//		pad.save(par2);

		Partecipazione partecipazione1 = pad.searchById(12);
		Partecipazione partecipazione2 = pad.searchById(13);

		System.out.println(partecipazione1);
		System.out.println(partecipazione2);

		em.close();
		emf.close();

		// ******************* METODI ESERCIZIO WEEK15 DAY2 *************************
		// ed.save(mare);

		// SEARCH BY ID

//		Evento eventoTrovato = ed.searchById(UUID.fromString("206e303f-13b9-4c5f-8745-5c333cfc7d22"));
//		System.out.println(eventoTrovato);

		// SEARCH AND DESTROY

//		ed.searchAndDestroy(UUID.fromString("6b10bca4-b9af-446e-8e14-c29078b24ca5"));

		// REFRESH

//		ed.refresh(UUID.fromString("5b93ef44-e7d7-4daf-8f21-b052a447e766"));
		// CLOSE EM AND EMF

	}

}
