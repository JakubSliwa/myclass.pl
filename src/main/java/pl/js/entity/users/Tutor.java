package pl.js.entity.users;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.js.entity.Classroom;


@Entity
@Table(name = "tutors")
public class Tutor extends User {

	public Tutor(String login, String password) {
		super(login, password);

	}

	public Tutor() {

	}

	@ManyToOne
	Classroom classroom;

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

}
