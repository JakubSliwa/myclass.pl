package pl.js.dao;

import java.util.List;

public interface GeneralDao<T> {

	void save();

	void findById(long id);

	void update();

	void delete();

	List<T> findAll();

}
