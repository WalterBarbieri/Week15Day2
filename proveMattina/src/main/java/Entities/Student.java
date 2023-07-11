package Entities;

public class Student {
	long id;
	String name;
	String lastname;

	public Student() {

	}

	public Student(String name, String lastname) {

		this.setName(name);
		this.setLastname(lastname);
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
