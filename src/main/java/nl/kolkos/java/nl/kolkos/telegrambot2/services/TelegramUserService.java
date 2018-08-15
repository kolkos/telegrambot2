package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.TelegramUser;

public interface TelegramUserService {
	public void save(TelegramUser user);
	public TelegramUser findByTelegramUserId(int userId);
	
}
