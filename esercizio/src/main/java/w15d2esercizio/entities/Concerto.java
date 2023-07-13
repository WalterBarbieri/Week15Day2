package w15d2esercizio.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import w15d2esercizio.Enums.TipoConcerto;
import w15d2esercizio.Enums.TipoEvento;

@Entity
@DiscriminatorValue("Concerti")
public class Concerto extends Evento {
	private TipoConcerto genere;
	private Boolean inStreaming;

	public Concerto() {

	}

	public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, TipoConcerto genere, Boolean inStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.genere = genere;
		this.inStreaming = inStreaming;

	}

	public TipoConcerto getGenere() {
		return genere;
	}

	public void setGenere(TipoConcerto genere) {
		this.genere = genere;
	}

	public Boolean getInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(Boolean inStreaming) {
		this.inStreaming = inStreaming;
	}

	@Override
	public String toString() {
		return "Concerto [genere=" + genere + ", inStreaming=" + inStreaming + ", getId()=" + getId() + ", getTitolo()="
				+ getTitolo() + ", getDataEvento()=" + getDataEvento() + ", getDescrizione()=" + getDescrizione()
				+ ", getTipoEvento()=" + getTipoEvento() + ", getNumeroMassimoPartecipanti()="
				+ getNumeroMassimoPartecipanti() + "]";
	}

}
