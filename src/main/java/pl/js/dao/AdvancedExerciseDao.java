package pl.js.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.js.entity.exercise.AdvancedExercise;

@Component
@Transactional
public class AdvancedExerciseDao extends AbstractGeneralClass<AdvancedExercise> {

	public AdvancedExercise findsAById(long id) {
		return entityManager.find(AdvancedExercise.class, id);
	}

	public List<AdvancedExercise> getAll() {
		Query query = entityManager.createQuery("SELECT a FROM AdvancedExercise a");
		return query.getResultList();
	}
}
