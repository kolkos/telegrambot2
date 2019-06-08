package nl.kolkos.telegrambot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.kolkos.telegrambot2.entities.TelegramMessage;
import nl.kolkos.telegrambot2.repositories.TelegramMessageRepository;

@Service
public class TelegramMessageService {

	private final TelegramMessageRepository telegramMessageRepository;

	@Autowired
	public TelegramMessageService(TelegramMessageRepository telegramMessageRepository) {
		this.telegramMessageRepository = telegramMessageRepository;
	}
	
	public TelegramMessage save(TelegramMessage telegramMessage) {
		return telegramMessageRepository.save(telegramMessage);
	}
	
	public List<TelegramMessage> findAll() {
		return telegramMessageRepository.findAll();
	}
	
	
}
