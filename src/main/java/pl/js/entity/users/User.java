package pl.js.entity.users;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.mindrot.jbcrypt.BCrypt;

@MappedSuperclass
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String login;
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		return this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public User(String login, String password) {
		this.login = login;
		this.setPassword(password);
	}

	public User() {
	}

}
