package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.kolkos.java.nl.kolkos.telegrambot2.controllers.BotController;
import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Setting;

@Service
public class BotServiceImpl implements BotService{
	Logger logger = LoggerFactory.getLogger(BotService.class);
	
	@Autowired
	private SettingService settingService;
	
	@Override
	public String startBot(String username) {
		logger.info(String.format("Received a request from %s to START the bot", username));
		
		// get the setting
		Setting setting = settingService.findBySettingKey("BOT_STOPPED");
		if(setting.getSettingValue().equals("False")) {
			logger.info("Bot was already started");
			return "Bot was already started";
		}
		
		// update the setting
		setting.setSettingValue("False");
		
		// save the new value
		settingService.saveSetting(setting);
		logger.info("Bot started");
		
		return "Bot is now started";
	}

	@Override
	public String stopBot(String username) {
		logger.info(String.format("Received a request from %s to STOP the bot", username));
		
		// get the setting
		Setting setting = settingService.findBySettingKey("BOT_STOPPED");
		if(setting.getSettingValue().equals("True")) {
			logger.info("Bot was already stopped");
			return "Bot was already stopped";
		}
		
		// update the setting
		setting.setSettingValue("True");
		
		// save the new value
		settingService.saveSetting(setting);
		logger.info("Bot stopped");
		
		return "Bot is now stopped";
	}
	
}
