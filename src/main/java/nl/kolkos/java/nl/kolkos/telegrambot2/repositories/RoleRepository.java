package nl.kolkos.java.nl.kolkos.telegrambot2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRole(String role);
	List<Role> findAllByOrderByRoleAsc();
}
