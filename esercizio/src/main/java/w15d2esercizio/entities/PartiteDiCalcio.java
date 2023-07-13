package w15d2esercizio.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import w15d2esercizio.Enums.TipoEvento;

@Entity
@DiscriminatorValue("Partite di Calcio")
@NamedQuery(name = "vinteCasa", query = "SELECT a FROM PartiteDiCalcio a WHERE a.squadraVincente = a.squadraCasa")
@NamedQuery(name = "vinteTrasferta", query = "SELECT a FROM PartiteDiCalcio a WHERE a.squadraVincente = a.squadraOspiti")
@NamedQuery(name = "pareggiate", query = "SELECT a FROM PartiteDiCalcio a WHERE a.squadraVincente = null")
public class PartiteDiCalcio extends Evento {
	private String squadraCasa;
	private String squadraOspiti;
	private String squadraVincente;
	private int golCasa;
	private int golOspiti;

	public PartiteDiCalcio() {

	}

	public PartiteDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, String squadraCasa, String squadraOspiti, int golCasa,
			int golOspiti) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.squadraCasa = squadraCasa;
		this.squadraOspiti = squadraOspiti;
		this.golCasa = golCasa;
		this.golOspiti = golOspiti;
		this.setSquadraVincente();
	}

	public String getSquadraCasa() {
		return squadraCasa;
	}

	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}

	public String getSquadraOspiti() {
		return squadraOspiti;
	}

	public void setSquadraOspiti(String squadraOspiti) {
		this.squadraOspiti = squadraOspiti;
	}

	public int getGolCasa() {
		return golCasa;
	}

	public void setGolCasa(int golCasa) {
		this.golCasa = golCasa;
	}

	public int getGolOspiti() {
		return golOspiti;
	}

	public void setGolOspiti(int golOspiti) {
		this.golOspiti = golOspiti;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente() {
		if (golCasa > golOspiti) {
			this.squadraVincente = this.squadraCasa;
		} else if (golOspiti > golCasa) {
			this.squadraVincente = this.squadraOspiti;
		} else {
			this.squadraVincente = null;
		}

	}

	@Override
	public String toString() {
		return "PartiteDiCalcio [squadraCasa=" + squadraCasa + ", squadraOspiti=" + squadraOspiti + ", golCasa="
				+ golCasa + ", golOspiti=" + golOspiti + ", getId()=" + getId() + ", getTitolo()=" + getTitolo()
				+ ", getDataEvento()=" + getDataEvento() + ", getDescrizione()=" + getDescrizione()
				+ ", getTipoEvento()=" + getTipoEvento() + ", getNumeroMassimoPartecipanti()="
				+ getNumeroMassimoPartecipanti() + "]";
	}

}
