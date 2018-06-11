package pl.js.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.js.entity.users.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
	
}
