package pl.js.entity.users;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.js.entity.Classroom;

@Entity
@Table(name = "tutors")
public class Tutor extends User {

	public Tutor(String login, String password, String email) {
		super(login, password, email);
	}

	public Tutor() {

	}



}
