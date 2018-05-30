package pl.js.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.js.entity.users.Admin;

@Component
@Transactional
public class AdminDao extends AbstractGeneralClass<Admin> {

	@Override
	public void save(Admin entity) {
		entityManager.persist(entity);
	}

}
