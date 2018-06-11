package pl.js.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.js.entity.users.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

	Tutor findByEmail(String email);

	@Query("select	t	from	Tutor	t	where	t.username	=	?1")
	Tutor findByUsername(String username);

}
