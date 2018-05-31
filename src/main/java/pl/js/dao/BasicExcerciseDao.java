package pl.js.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.js.entity.exercise.BasicExercise;

@Component
@Transactional
public class BasicExcerciseDao extends AbstractGeneralClass<BasicExercise> {

	public BasicExercise findAById(long id) {
		return entityManager.find(BasicExercise.class, id);
	}

	public List<BasicExercise> getAll() {
		Query query = entityManager.createQuery("SELECT b FROM BasicExercise b");
		return query.getResultList();
	}
}
