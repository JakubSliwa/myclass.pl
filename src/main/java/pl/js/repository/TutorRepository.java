package pl.js.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.js.entity.users.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

	Tutor findByEmail(String email);

	@Query("select	t	from	Tutor	t	where	t.username	=	?1")
	Tutor findByUsername(String username);

	@Modifying
	@Transactional
	@Query("UPDATE Tutor t SET t.username = :username, t.email = :email  WHERE t.id = :id")
	void setTutorLoginAndEmailById(@Param("username") String username, @Param("email") String email,
			@Param("id") Long id);

}
