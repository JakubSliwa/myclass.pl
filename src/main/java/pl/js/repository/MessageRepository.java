package pl.js.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.js.entity.Message;
import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findAllBySendToTutor(Tutor tutor);

	@Query(value = "select * from messages where (sendByStudent_id =?1 and sendToTutor_id =?2) or (sendToStudent_id =?1 and sendByTutor_id =?2) order by sent desc", nativeQuery = true)
	List<Message> findAllBySendToTutorAndSendByStudentOrSendByTutorAndSendToStudentOrderBySentDesc(Student student,
			Tutor tutor);
}
