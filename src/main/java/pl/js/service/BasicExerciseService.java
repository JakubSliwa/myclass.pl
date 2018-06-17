package pl.js.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.exercise.BasicSolution;
import pl.js.entity.users.Student;
import pl.js.repository.BasicExerciseRepository;
import pl.js.repository.BasicSolutionRepository;
import pl.js.repository.StudentRepository;

@Service
public class BasicExerciseService {

	@Autowired
	private BasicSolutionRepository basicSolutionRepository;

	@Autowired
	private BasicExerciseRepository basicExerciseRepository;
	@Autowired
	private StudentRepository studentRepository;

	public void basicSolutionSetNullForExerciseId(Long exerciseId) {
		List<BasicSolution> basicSolutionsList = basicSolutionRepository.findAllByBasicExerciseId(exerciseId);
		for (BasicSolution bs : basicSolutionsList) {
			bs.setBasicExercise(null);
			basicSolutionRepository.save(bs);
		}
		basicExerciseRepository.delete(exerciseId);
	}

	public void basicExerciseSetNullForStudentId(Long studentId) {
		List<BasicExercise> basicExerciseList = basicExerciseRepository.findAllByStudentId(studentId);
		for (BasicExercise be : basicExerciseList) {
			be.setStudent(null);
			basicExerciseRepository.save(be);
		}
		studentRepository.delete(studentId);
	}

	public void basicExcerciseUpdate(BasicExercise basicExercise, String title, String description, Integer daysToAdd,
			Long exerciseId, Student student) {
		Long studentId = student.getId();
		basicExercise.setId(studentId);
		basicExerciseRepository.setBasicExerciseTitleAndDescriptionAndDaysToAddAndStudentById(title, description,
				daysToAdd, student, exerciseId);
	}
}
