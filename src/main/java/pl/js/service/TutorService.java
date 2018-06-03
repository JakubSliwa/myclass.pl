package pl.js.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.js.dao.BasicExcerciseDao;
import pl.js.dao.StudentDao;
import pl.js.entity.exercise.BasicExercise;

@Service
public class TutorService {
	@Autowired
	StudentDao studentDao;

	@Autowired
	BasicExcerciseDao basicExcerciseDao;


	public void addNewExercise(BasicExercise basicExercise) {
		basicExcerciseDao.save(basicExercise);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public BasicExcerciseDao getBasicExcerciseDao() {
		return basicExcerciseDao;
	}

	public void setBasicExcerciseDao(BasicExcerciseDao basicExcerciseDao) {
		this.basicExcerciseDao = basicExcerciseDao;
	}
}
