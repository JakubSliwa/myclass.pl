package pl.js.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.js.entity.Message;
import pl.js.entity.users.Tutor;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findAllBySendToTutor(Tutor tutor);;

	@Query("select count(readed =:readed)	from Message m where	m.tutor	=	:tutor")
	long countMessages(@Param("readed") String readed, @Param("tutor") Tutor tutor);
}
