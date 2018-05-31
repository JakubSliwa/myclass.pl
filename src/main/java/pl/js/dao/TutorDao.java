package pl.js.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.js.entity.users.Tutor;

@Component
@Transactional
public class TutorDao extends AbstractGeneralClass<Tutor> {

	public Tutor findAById(long id) {
		return entityManager.find(Tutor.class, id);
	}

	public List<Student> getAll() {
		Query query = entityManager.createQuery("SELECT t FROM Tutor t");
		return query.getResultList();
	}
}
