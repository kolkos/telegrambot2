package nl.kolkos.java.nl.kolkos.telegrambot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
}
