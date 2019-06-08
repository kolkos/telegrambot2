package nl.kolkos.telegrambot2.components;

import nl.kolkos.telegrambot2.services.IncomingMessageService;
import nl.kolkos.telegrambot2.services.SendMessageToRabbitMQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import nl.kolkos.telegrambot2.configuration.TelegramConfiguration;
import nl.kolkos.telegrambot2.entities.TelegramMessage;
import nl.kolkos.telegrambot2.services.TelegramMessageService;

@Component
public class CryptoBot2 extends TelegramLongPollingBot {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(CryptoBot2.class);
	private final TelegramConfiguration telegramConfiguration;
	private final IncomingMessageService incomingMessageService;
	private final SendMessageToRabbitMQService sendMessageToRabbitMQService;


	@Autowired
	public CryptoBot2(TelegramConfiguration telegramConfiguration, IncomingMessageService incomingMessageService, SendMessageToRabbitMQService sendMessageToRabbitMQService) {
		this.telegramConfiguration = telegramConfiguration;
		this.incomingMessageService = incomingMessageService;
		this.sendMessageToRabbitMQService = sendMessageToRabbitMQService;
	}


	@Override
	public void onUpdateReceived(Update update) {
		TelegramMessage telegramMessage = incomingMessageService.registerIncomingMessage(update);
		try {
			sendMessageToRabbitMQService.sendMessageToQueue(telegramMessage);
		} catch (JsonProcessingException e) {
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
