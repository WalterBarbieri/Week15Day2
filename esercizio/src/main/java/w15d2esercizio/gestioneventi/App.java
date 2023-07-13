package w15d2esercizio.gestioneventi;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import w15d2esercizio.Dao.EventiDao;
import w15d2esercizio.Dao.LocationDao;
import w15d2esercizio.Dao.PartecipazioneDao;
import w15d2esercizio.Dao.PersonaDao;
import w15d2esercizio.Enums.Sesso;
import w15d2esercizio.Enums.TipoConcerto;
import w15d2esercizio.Enums.TipoEvento;
import w15d2esercizio.entities.Concerto;
import w15d2esercizio.entities.Location;
import w15d2esercizio.entities.Persona;
import w15d2esercizio.utils.JpaUtil;

public class App {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	private static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		EventiDao ed = new EventiDao(em);
		PersonaDao pd = new PersonaDao(em);
		LocationDao ld = new LocationDao(em);
		PartecipazioneDao pad = new PartecipazioneDao(em);

		// CREATE AND SAVE EVENT
		Location loc1 = new Location("Piazza dei Miracoli", "Pisa");
		Location loc2 = new Location("Spiagge Bianche", "Lipari");
		Location loc3 = new Location("Stadio Calcio", "Nonmipiace");
		Location loc4 = new Location("Stadio di Atletica", "Lapponia");
		Location loc5 = new Location("Stadio Picchi", "Livorno");

//		ld.save(loc1);
//		ld.save(loc2);
//		ld.save(loc3);
//		ld.save(loc4);
//		ld.save(loc5);
		Location location1 = ld.searchById(2);
		Location location2 = ld.searchById(3);
		Location location3 = ld.searchById(4);
		Location location4 = ld.searchById(5);
		Location location5 = ld.searchById(1);

//		Evento ev1 = new Evento("Gita in Città", LocalDate.now(), "Visitiamo luoghi culturali", TipoEvento.PUBBLICO, 30,
//				location1);
//		Evento ev2 = new Evento("Gita al Mare", LocalDate.now(), "Andiamo al mare", TipoEvento.PRIVATO, 6, location2);
//		ed.save(ev1);
//		ed.save(ev2);

		Concerto zeppelin = new Concerto("Concerto Led Zeppelin", LocalDate.of(1970, 6, 2),
				"Super concerto non mancare", TipoEvento.PUBBLICO, 10000, location2, TipoConcerto.ROCK, true);
		Concerto chopin = new Concerto("Chopin Etude op. 25", LocalDate.of(1837, 12, 25), "Concerto di natale per DIO",
				TipoEvento.PRIVATO, 1, location5, TipoConcerto.CLASSICO, false);
		Concerto vivaldi = new Concerto("Vivaldi Le 4 Stagioni - Estate", LocalDate.of(1715, 8, 15),
				"Concerto di Ferragosto per la Madonna", TipoEvento.PRIVATO, 1, location1, TipoConcerto.CLASSICO,
				false);
		Concerto muddy = new Concerto("Concerto Muddy Waters", LocalDate.of(1961, 3, 11), "Super concerto non mancare",
				TipoEvento.PUBBLICO, 10000, location4, TipoConcerto.ROCK, true);

//		ed.save(zeppelin);
//		ed.save(chopin);
//		ed.save(vivaldi);
//		ed.save(muddy);

		log.info("Concerti in Streaming: ");
		ed.getConcertiStreaming(true).forEach(el -> log.info(el.toString()));
		log.info("Concerti non in Streaming: ");
		ed.getConcertiStreaming(false).forEach(el -> log.info(el.toString()));

		log.info("Concerti Rock: ");
		ed.getConcertiPerGenere(TipoConcerto.ROCK).forEach(el -> log.info(el.toString()));
		;
		log.info("Concerti Classica: ");
		ed.getConcertiPerGenere(TipoConcerto.CLASSICO).forEach(el -> log.info(el.toString()));

//		Evento event1 = ed.searchById(28);
//		Evento event2 = ed.searchById(29);

		Persona p1 = new Persona("Mangia", "Lamela", "123@456.ml", LocalDate.of(1990, 9, 10), Sesso.FEMMINA);
		Persona p2 = new Persona("Bevi", "Labotte", "987@654.bl", LocalDate.of(1980, 3, 21), Sesso.MASCHIO);
		Persona p3 = new Persona("Fischia", "Lafoglia", "???@!!!.fl", LocalDate.of(2000, 6, 2), Sesso.MASCHIO);
		Persona p4 = new Persona("Lancia", "Labomba", "357@951.ll", LocalDate.of(1969, 12, 30), Sesso.FEMMINA);

//		pd.save(p1);
//		pd.save(p2);
//		pd.save(p3);
//		pd.save(p4);

//		Persona pers1 = pd.searchById(30);
//		Persona pers2 = pd.searchById(31);

//		Partecipazione par1 = new Partecipazione(pers1, event1, Stato.DA_CONFERMARE);
//		Partecipazione par2 = new Partecipazione(pers2, event2, Stato.CONFERMATA);

//		pad.save(par1);
//		pad.save(par2);

//		Partecipazione partecipazione1 = pad.searchById(32);
//		Partecipazione partecipazione2 = pad.searchById(33);

//		pers1.getPartecipazioni().add(par2);
//		pers2.getPartecipazioni().add(par1);
//
//		pd.save(pers1);
//		pd.save(pers2);

//		System.out.println(partecipazione1);
//		System.out.println(partecipazione2);
//		pers1.getPartecipazioni().forEach(el -> System.out.println(el));
//		pers2.getPartecipazioni().forEach(el -> System.out.println(el));
//		event1.getPartecipazioni().forEach(el -> System.out.println(el));

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
