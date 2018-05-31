package pl.js.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.js.entity.users.Admin;

@Component
@Transactional
public class AdminDao extends AbstractGeneralClass<Admin> {

	public Admin findAById(long id) {
		return entityManager.find(Admin.class, id);
	}

	public List<Admin> getAll() {
		Query query = entityManager.createQuery("SELECT a FROM Admin a");
		return query.getResultList();
	}
}
