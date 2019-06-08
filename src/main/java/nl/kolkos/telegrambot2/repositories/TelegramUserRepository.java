package nl.kolkos.telegrambot2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lombok.extern.java.Log;
import nl.kolkos.telegrambot2.entities.TelegramUser;

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long>{
	Optional<TelegramUser> findById(Long id);
}
