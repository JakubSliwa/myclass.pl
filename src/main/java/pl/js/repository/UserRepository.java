package pl.js.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.js.entity.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
