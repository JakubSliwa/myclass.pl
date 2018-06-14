package pl.js.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.js.entity.exercise.BasicSolution;
import pl.js.repository.BasicSolutionRepository;

@Service

public class BasicSolutionService {

	@Autowired
	private BasicSolutionRepository basicSolutionRepository;

	public List<BasicSolution> getBasicSolutionListByClassroomId(Long id) {
		return basicSolutionRepository.findAllByClassroomId(id);
	}
	@Transactional
	public void addGrade(@ModelAttribute BasicSolution basicSolution, Double grade) {
		basicSolutionRepository.setBasicSolutionGradeById(grade, basicSolution.getId());
	}
}
