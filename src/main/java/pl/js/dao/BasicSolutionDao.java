package pl.js.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.js.entity.exercise.BasicSolution;

@Component
@Transactional
public class BasicSolutionDao extends AbstractGeneralClass<BasicSolution> {

	public BasicSolution findAById(long id) {
		return entityManager.find(BasicSolution.class, id);
	}

	public List<BasicSolution> getAll() {
		Query query = entityManager.createQuery("SELECT b FROM BasicSolution b");
		return query.getResultList();
	}
}
