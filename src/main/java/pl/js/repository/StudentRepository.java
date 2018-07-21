package pl.js.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.js.entity.users.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByEmail(String email);

	List<Student> findAllByClassroomId(Long id);

	@Query("select	s	from	Student	s	where	s.username	=	?1")
	Student findByUserName(String username);

	@Modifying
	@Transactional
	@Query("UPDATE Student s SET s.username = :username, s.email = :email WHERE s.id = :studentId")
	void setStudentLoginAndEmailById(@Param("username") String username, @Param("email") String email,
			@Param("studentId") Long studentId);

	@Modifying
	@Transactional
	@Query("UPDATE Student s SET s.status = :status  WHERE s.id = :id")
	void setStudentStatusById(@Param("status") String status, @Param("id") Long id);
}
