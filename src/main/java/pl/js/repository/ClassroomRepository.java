package pl.js.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.js.entity.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

	Classroom findAById(long classroomId);

}
