package w15d2esercizio.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {
	@Id
	@GeneratedValue

	private long id;
	private String nome;
	private String citta;
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	private Set<Evento> eventi;

	public Location() {

	}

	public Location(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", nome=" + nome + ", citta=" + citta + "]";
	}

}
