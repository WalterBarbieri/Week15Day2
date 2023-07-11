package w15d2prove.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

//@Table(name = "students", uniqueConstraints = { @UniqueConstraint(columnNames = { "firstName", "lastName" }) })
@Table(name = "students")
public class Student {
	@Id // imposta chiave primaria
	@GeneratedValue // per gestire automaticamente e random il valore tramite db
	private UUID Id;
	private String firstName;
	private String lastName;

	public Student() {

	}

	public Student(String firstName, String lastName) {

		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public UUID getId() {
		return Id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
