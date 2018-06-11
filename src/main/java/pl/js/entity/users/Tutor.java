package pl.js.entity.users;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tutors")
public class Tutor extends User {

	public Tutor() {
		super();
	}

}
