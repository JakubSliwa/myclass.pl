package pl.js.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.js.entity.Lesson;
import pl.js.entity.users.Student;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

	List<Lesson> findAllByClassroomId(Long id);

	List<Lesson> findAllByStudent(Student student);

}
