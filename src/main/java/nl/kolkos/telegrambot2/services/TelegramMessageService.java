package nl.kolkos.telegrambot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.kolkos.telegrambot2.entities.TelegramMessage;
import nl.kolkos.telegrambot2.repositories.TelegramMessageRepository;

@Service
public class TelegramMessageService {

	private final TelegramMessageRepository telegramMessageRepository;
	private final TelegramChatService telegramChatService;
	private final TelegramUserService telegramUserService;

	@Autowired
	public TelegramMessageService(TelegramMessageRepository telegramMessageRepository, TelegramChatService telegramChatService, TelegramUserService telegramUserService) {
		this.telegramMessageRepository = telegramMessageRepository;
		this.telegramChatService = telegramChatService;
		this.telegramUserService = telegramUserService;
	}

	public TelegramMessage save(TelegramMessage telegramMessage) {
		return telegramMessageRepository.save(telegramMessage);
	}
	
	public List<TelegramMessage> findAll() {
		return telegramMessageRepository.findAll();
	}
	
	
}
