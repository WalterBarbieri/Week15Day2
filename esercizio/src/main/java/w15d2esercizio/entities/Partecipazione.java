package w15d2esercizio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import w15d2esercizio.Enums.Stato;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Persona persona;
	@ManyToOne
	@JoinColumn
	private Evento evento;
	private Stato stato;

	public Partecipazione() {

	}

	public Partecipazione(Persona persona, Evento evento, Stato stato) {
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", persona=" + persona + ", evento=" + evento + ", stato=" + stato + "]";
	}

}
