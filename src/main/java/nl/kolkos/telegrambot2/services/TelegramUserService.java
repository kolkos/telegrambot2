package nl.kolkos.telegrambot2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.kolkos.telegrambot2.entities.TelegramUser;
import nl.kolkos.telegrambot2.repositories.TelegramUserRepository;

@Service
public class TelegramUserService {

	private final TelegramUserRepository telegramUserRepository;

	@Autowired
	public TelegramUserService(TelegramUserRepository telegramUserRepository) {
		this.telegramUserRepository = telegramUserRepository;
	}
	
	
	public TelegramUser save(TelegramUser telegramUser) {
		Optional<TelegramUser> telegramUserOptional = findById(telegramUser.getId());
		if(telegramUserOptional.isPresent()) {
			return telegramUserOptional.get();
		}
		
		return telegramUserRepository.save(telegramUser);
	}
	
	public List<TelegramUser> findAll() {
		return telegramUserRepository.findAll();
	}
	
	public Optional<TelegramUser> findById(Long id) {
		return telegramUserRepository.findById(id);
	}
	
}
