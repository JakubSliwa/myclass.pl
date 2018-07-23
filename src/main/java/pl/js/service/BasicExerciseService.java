package pl.js.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.users.Student;
import pl.js.repository.BasicExerciseRepository;

@Service
public class BasicExerciseService {

	@Autowired
	private BasicExerciseRepository basicExerciseRepository;



	

	@Transactional
	public void updateBasicExcercise(BasicExercise basicExercise, String title, String description, Integer daysToAdd,
			Long exerciseId, Student student) {
		Long studentId = student.getId();
		basicExercise.setId(studentId);
		basicExerciseRepository.setBasicExerciseTitleAndDescriptionAndDaysToAddAndStudentById(title, description,
				daysToAdd, student, exerciseId);
	}
}
