package nl.kolkos.telegrambot2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.kolkos.telegrambot2.entities.TelegramMessage;
import nl.kolkos.telegrambot2.services.TelegramMessageService;

@RestController
@RequestMapping("/telegramMessage")
public class TelegramMessageController {

	private final TelegramMessageService telegramMessageService;

	@Autowired
	public TelegramMessageController(TelegramMessageService telegramMessageService) {
		this.telegramMessageService = telegramMessageService;
	}
	
	@GetMapping("/list")
	public List<TelegramMessage> listAllMessages() {
		return telegramMessageService.findAll();
	}
	
	
	
	
	
}
