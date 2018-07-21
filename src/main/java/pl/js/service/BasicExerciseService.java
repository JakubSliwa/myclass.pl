package pl.js.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.users.Student;
import pl.js.repository.BasicExerciseRepository;
import pl.js.repository.StudentRepository;

@Service
public class BasicExerciseService {

	@Autowired
	private BasicExerciseRepository basicExerciseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public void clearBasicExercise(Long studentId) {
		List<BasicExercise> basicExerciseList = basicExerciseRepository.findAllByStudentId(studentId);
		for (BasicExercise be : basicExerciseList) {
			be.setStudent(null);
			basicExerciseRepository.save(be);
		}
		studentRepository.delete(studentId);
	}

	@Transactional
	public void updateBasicExcercise(BasicExercise basicExercise, String title, String description, Integer daysToAdd,
			Long exerciseId, Student student) {
		Long studentId = student.getId();
		basicExercise.setId(studentId);
		basicExerciseRepository.setBasicExerciseTitleAndDescriptionAndDaysToAddAndStudentById(title, description,
				daysToAdd, student, exerciseId);
	}
}
