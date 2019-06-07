package nl.kolkos.telegrambot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.kolkos.telegrambot2.entities.TelegramChat;
import nl.kolkos.telegrambot2.repositories.TelegramChatRepository;

@Service
public class TelegramChatService {

	private final TelegramChatRepository telegramChatRepository;

	@Autowired
	public TelegramChatService(TelegramChatRepository telegramChatRepository) {
		this.telegramChatRepository = telegramChatRepository;
	}
	
	public TelegramChat save(TelegramChat telegramChat) {
		return telegramChatRepository.save(telegramChat);
	}
	
	public List<TelegramChat> getAll() {
		return telegramChatRepository.findAll();
	}
	
	
}
