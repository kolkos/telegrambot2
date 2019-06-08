package nl.kolkos.telegrambot2.services;

import java.util.List;
import java.util.Optional;

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
		// check if the chat is already saved
		Optional<TelegramChat> telegramChatByIdOptional = findById(telegramChat.getId());
		if(telegramChatByIdOptional.isPresent()) {
			return telegramChatByIdOptional.get();
		}
				
		return telegramChatRepository.save(telegramChat);
	}
	
	public List<TelegramChat> findAll() {
		return telegramChatRepository.findAll();
	}
	
	public Optional<TelegramChat> findById(Long id){
		return telegramChatRepository.findById(id);
	}
	
}
