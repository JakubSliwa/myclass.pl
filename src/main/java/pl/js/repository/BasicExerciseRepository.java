package pl.js.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.js.entity.exercise.BasicExercise;

@Repository
public interface BasicExerciseRepository extends JpaRepository<BasicExercise, Long> {

	List<BasicExercise> findAllByClassroomId(Long id);

}
