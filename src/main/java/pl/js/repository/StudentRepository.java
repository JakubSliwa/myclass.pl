package pl.js.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.js.entity.users.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByEmail(String email);

	List<Student> findAllByClassroomId(Long id);

	@Query("select	s	from	Student	s	where	s.username	=	?1")
	Student findByUserName(String username);
}
