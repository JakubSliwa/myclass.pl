package pl.js.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public abstract class AbstractGeneralClass<T> {
	private Class<T> clazz;

	@PersistenceContext
	EntityManager entityManager;

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public T findById(long id) {
		return entityManager.find(clazz, id);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}


}
