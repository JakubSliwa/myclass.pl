package pl.js.entity.users;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {

	public Admin(String login, String password) {
		super(login, password);

	}

	public Admin() {

	}
	
}
