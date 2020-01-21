package lgscourse.javaadvanced.homeworks.university;

public class Lector {
	private int id;
	private String firstName;
	private String lastName;
	private Degree degree;

	public Lector(int id, String firstName, String lastName, Degree degree) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.degree = degree;
	}

	public Lector(String firstName, String lastName, Degree degree) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.degree = degree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Lector [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", degree=" + degree + "]";
	}

}
