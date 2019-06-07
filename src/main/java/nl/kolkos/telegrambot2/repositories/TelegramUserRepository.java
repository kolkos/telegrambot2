package nl.kolkos.telegrambot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.kolkos.telegrambot2.entities.TelegramUser;

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long>{

}
