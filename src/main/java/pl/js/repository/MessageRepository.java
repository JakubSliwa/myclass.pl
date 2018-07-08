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
	List<Message> findAllBySendToTutorAndReaded(Tutor tutor, String readed);

	@Query(value = "select left(text, 20) as text, sendToTutor_id,sendByStudent_id, sendByTutor_id, sendToStudent_id, readed, sent, id from messages where (readed =?1 and sendToTutor_id =?2) order by sent desc;", nativeQuery = true)
	List<Message> findAllBySendToTutorAndNotReadedAndLimited(String readed, Tutor tutor);

	@Query(value = "select * from messages where (readed =?1 and sendByTutor_id =?2) order by sent desc", nativeQuery = true)
	List<Message> findAllBySendToTutorAndNotReaded(String readed, Tutor tutor);

	@Query(value = "select * from messages where (sendByStudent_id =?1 and sendToTutor_id =?2) or (sendToStudent_id =?1 and sendByTutor_id =?2) order by sent desc", nativeQuery = true)
	List<Message> findAllBySendToTutorAndSendByStudentOrSendByTutorAndSendToStudentOrderBySentDesc(Student student,
			Tutor tutor);

	List<Message> findAllBySendToTutorOrSendByTutorOrderBySentDesc(Tutor tutor, Tutor tutor2);

	List<Message> findAllBySendByTutorAndSendToStudent(Tutor tutor, Student student);
}
