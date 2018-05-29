package pl.js.entity.users;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {
	
}
