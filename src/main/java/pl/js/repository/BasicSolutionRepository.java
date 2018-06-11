package pl.js.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.js.entity.exercise.BasicSolution;

@Repository
public interface BasicSolutionRepository extends JpaRepository<BasicSolution, Long> {
	
}
