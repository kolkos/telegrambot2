package nl.kolkos.telegrambot2.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import nl.kolkos.telegrambot2.configuration.TelegramConfiguration;

@Component
public class CryptoBot2 extends TelegramLongPollingBot {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(CryptoBot2.class);
	private final TelegramConfiguration telegramConfiguration;
	
	@Autowired
	public CryptoBot2(TelegramConfiguration telegramConfiguration) {
		this.telegramConfiguration = telegramConfiguration;
	}

	@Override
	public void onUpdateReceived(Update update) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		try {
			String json = objectMapper.writeValueAsString(update);
			LOGGER.info(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		return telegramConfiguration.getBotname();
	}

	@Override
	public String getBotToken() {
		return telegramConfiguration.getToken();
	}
	
}
