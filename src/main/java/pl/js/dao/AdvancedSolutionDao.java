package pl.js.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.js.entity.exercise.AdvancedSolution;

@Component
@Transactional
public class AdvancedSolutionDao extends AbstractGeneralClass<AdvancedSolution> {

	public AdvancedSolution findAById(long id) {
		return entityManager.find(AdvancedSolution.class, id);
	}

	public List<AdvancedSolution> getAll() {
		Query query = entityManager.createQuery("SELECT a FROM AdvancedSolution a");
		return query.getResultList();
	}
}
