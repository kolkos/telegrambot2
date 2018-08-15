package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.TelegramUser;
import nl.kolkos.java.nl.kolkos.telegrambot2.repositories.TelegramUserRepository;

@Service
public class TelegramUserServiceImpl implements TelegramUserService{
	@Autowired
	private TelegramUserRepository telegramUserRepository;
	
	@Override
	public void save(TelegramUser user) {
		telegramUserRepository.save(user);
	}

	@Override
	public TelegramUser findByTelegramUserId(int userId) {
		return telegramUserRepository.findByUserId(userId);
	}

}
