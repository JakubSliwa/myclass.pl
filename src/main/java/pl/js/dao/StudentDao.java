package pl.js.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.js.entity.users.Student;

@Component
@Transactional
public class StudentDao extends AbstractGeneralClass<Student> {

	public Student findAById(long id) {
		return entityManager.find(Student.class, id);
	}

	public List<Student> getAll() {
		Query query = entityManager.createQuery("SELECT s FROM Student s");
		return query.getResultList();
	}
}
