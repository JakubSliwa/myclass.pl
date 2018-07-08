package pl.js.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.js.entity.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
