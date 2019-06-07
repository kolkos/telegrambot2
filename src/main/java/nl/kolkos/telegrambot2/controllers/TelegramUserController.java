package nl.kolkos.telegrambot2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.kolkos.telegrambot2.entities.TelegramUser;
import nl.kolkos.telegrambot2.services.TelegramUserService;


@RestController
@RequestMapping("/telegramUser")
public class TelegramUserController {
	
	private final TelegramUserService telegramUserService;
	
	
	@Autowired
	public TelegramUserController(TelegramUserService telegramUserService) {
		this.telegramUserService = telegramUserService;
	}

	@GetMapping("/list")
	public List<TelegramUser> getAllUsers() {
		return telegramUserService.getAll();
	}
}
