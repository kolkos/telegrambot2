package nl.kolkos.telegrambot2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.kolkos.telegrambot2.entities.TelegramChat;

@Repository
public interface TelegramChatRepository extends JpaRepository<TelegramChat, Long>{
	
	Optional<TelegramChat> findById(Long id);

}
