package pl.js.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.js.entity.exercise.BasicSolution;
import pl.js.repository.BasicExerciseRepository;
import pl.js.repository.BasicSolutionRepository;

@Service

public class BasicSolutionService {

	@Autowired
	private BasicSolutionRepository basicSolutionRepository;

	@Autowired
	private BasicExerciseRepository basicExerciseRepository;

	public List<BasicSolution> getBasicSolutionListByClassroomId(Long id) {
		return basicSolutionRepository.findAllByClassroomIdOrderByAddedDesc(id);
	}

	public List<BasicSolution> getFirst10BasicSolutionListByClassroomId(Long id) {
		return basicSolutionRepository.findFirst10ByClassroomIdOrderByAddedDesc(id);
	}

	@Transactional
	public void addGrade(@ModelAttribute BasicSolution basicSolution, Double grade) {
		basicSolutionRepository.setBasicSolutionGradeById(grade, basicSolution.getId());
	}

	public void basicSolutionSetNullForExerciseId(Long exerciseId) {
		List<BasicSolution> basicSolutionsList = basicSolutionRepository.findAllByBasicExerciseId(exerciseId);
		for (BasicSolution bs : basicSolutionsList) {
			bs.setBasicExercise(null);
			basicSolutionRepository.save(bs);
		}
		basicExerciseRepository.delete(exerciseId);
	}
}
