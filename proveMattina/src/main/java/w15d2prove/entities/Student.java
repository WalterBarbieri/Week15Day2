package w15d2prove.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "students")
public class Student {
	@Id
	private long Id;
	private String firstName;
	private String lastName;

	public Student() {

	}

	public Student(String firstName, String lastName) {

		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public long getId() {
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

}
