package pl.js.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.js.entity.exercise.BasicSolution;
import pl.js.repository.BasicSolutionRepository;

@Service
public class BasicSolutionService {

	@Autowired
	private BasicSolutionRepository basicSolutionRepository;

	public List<BasicSolution> getBasicSolutionListByClassroomId(Long id) {
		return basicSolutionRepository.findAllByClassroomId(id);
	}
}
