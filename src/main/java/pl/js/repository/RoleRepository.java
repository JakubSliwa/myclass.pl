package pl.js.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.js.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	/* @Query("select	r	from	Role	r	where	r.role	=	?1") */
	Role findByRole(String role);
}
