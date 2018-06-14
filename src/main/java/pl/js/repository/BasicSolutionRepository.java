package pl.js.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.js.entity.exercise.BasicSolution;

@Repository
public interface BasicSolutionRepository extends JpaRepository<BasicSolution, Long> {

	List<BasicSolution> findAllByClassroomId(Long id);

	@Modifying
	@Transactional
	@Query("update BasicSolution b set b.grade = ?1 where b.id = ?2")
	void setBasicSolutionGradeById(Double grade, Long solutionId);
}
