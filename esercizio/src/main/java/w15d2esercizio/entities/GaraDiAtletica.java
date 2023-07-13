package w15d2esercizio.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import w15d2esercizio.Enums.TipoEvento;

@Entity
@DiscriminatorValue("Gara di Atletica")
@NamedQuery(name = "atleticaVincitore", query = "SELECT a FROM GaraDiAtletica a WHERE a.vincitore = :vincitore")
@NamedQuery(name = "atleticaPartecipante", query = "SELECT a FROM GaraDiAtletica a JOIN a.setAtleti b WHERE b = :partecipante")
public class GaraDiAtletica extends Evento {

	@ManyToMany
	@JoinTable(name = "lista_atleti", joinColumns = @JoinColumn(name = "gara_id"), inverseJoinColumns = @JoinColumn(name = "persona_id"))
	private Set<Persona> setAtleti;

	@ManyToOne
	private Persona vincitore;

	public GaraDiAtletica() {

	}

	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, Set<Persona> setAtleti, Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.setAtleti = setAtleti;
		this.vincitore = vincitore;
	}

	public Set<Persona> getSetAtleti() {
		return setAtleti;
	}

	public void setSetAtleti(Set<Persona> setAtleti) {
		this.setAtleti = setAtleti;
	}

	public Persona getVincitore() {
		return vincitore;
	}

	public void setVincitore(Persona vincitore) {
		this.vincitore = vincitore;
	}

	@Override
	public String toString() {
		return "GaraDiAtletica [setAtleti=" + setAtleti + ", vincitore=" + vincitore + ", getId()=" + getId()
				+ ", getTitolo()=" + getTitolo() + ", getDataEvento()=" + getDataEvento() + ", getDescrizione()="
				+ getDescrizione() + ", getTipoEvento()=" + getTipoEvento() + ", getNumeroMassimoPartecipanti()="
				+ getNumeroMassimoPartecipanti() + "]";
	}

}
