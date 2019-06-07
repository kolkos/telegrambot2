package nl.kolkos.telegrambot2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.kolkos.telegrambot2.entities.TelegramChat;
import nl.kolkos.telegrambot2.services.TelegramChatService;


@RestController
@RequestMapping("/telegramChat")
public class TelegramChatController {
	
	private final TelegramChatService telegramChatService;
	
	
	@Autowired
	public TelegramChatController(TelegramChatService telegramChatService) {
		this.telegramChatService = telegramChatService;
	}

	@GetMapping("/list")
	public List<TelegramChat> getAllChats(){
		return telegramChatService.getAll();
	}
	
}
