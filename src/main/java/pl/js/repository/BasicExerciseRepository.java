package pl.js.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.users.Student;

public interface BasicExerciseRepository extends JpaRepository<BasicExercise, Long> {

	List<BasicExercise> findAllByClassroomId(Long id);

	List<BasicExercise> findAllByStudentId(Long studentId);

	@Modifying
	@Transactional
	@Query("UPDATE BasicExercise b SET b.title = :title, b.description = :description,  b.daysToAdd=:daysToAdd, b.student=:student WHERE b.id = :exerciseId")
	void setBasicExerciseTitleAndDescriptionAndDaysToAddAndStudentById(@Param("title") String title,
			@Param("description") String description, @Param("daysToAdd") Integer daysToAdd,
			@Param("student") Student student, @Param("exerciseId") Long exerciseId);

}
