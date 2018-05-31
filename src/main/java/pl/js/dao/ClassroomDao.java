package pl.js.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.js.entity.Classroom;

@Component
@Transactional
public class ClassroomDao extends AbstractGeneralClass<Classroom> {

	public Classroom findAById(long id) {
		return entityManager.find(Classroom.class, id);
	}

	public List<Classroom> getAll() {
		Query query = entityManager.createQuery("SELECT c FROM Classroom c");
		return query.getResultList();
	}
}
