package pl.js.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.js.entity.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

	Classroom findAById(long classroomId);

}
