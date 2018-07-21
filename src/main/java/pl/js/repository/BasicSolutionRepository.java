package pl.js.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pl.js.entity.exercise.BasicSolution;
import pl.js.entity.users.Student;

public interface BasicSolutionRepository extends JpaRepository<BasicSolution, Long> {

	List<BasicSolution> findAllByClassroomIdOrderByAddedDesc(Long id);

	List<BasicSolution> findFirst10ByClassroomIdOrderByAddedDesc(Long id);

	@Modifying
	@Transactional
	@Query("update BasicSolution b set b.grade = ?1 where b.id = ?2")
	void setBasicSolutionGradeById(Double grade, Long solutionId);

	List<BasicSolution> findAllByBasicExerciseId(Long id);

	@Query(value = "SELECT AVG(grade) FROM basicSolutions WHERE student_id = ?1", nativeQuery = true)
	Double getAvgGradeByStudentId(Student student);

	List<BasicSolution> findAllByStudentId(Long studentId);
}
