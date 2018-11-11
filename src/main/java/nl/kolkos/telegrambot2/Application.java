package nl.kolkos.telegrambot2;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import nl.kolkos.telegrambot2.bots.CommandBot;
import nl.kolkos.telegrambot2.rabbitmq.MessageReceivers;
import nl.kolkos.telegrambot2.rabbitmq.receivers.DemoReceiver;

public class Application {
	public static void main(String[] args) {
        // Initializes dependencies necessary for the base bot - Guice
        ApiContextInitializer.init();

        // Create the TelegramBotsApi object to register your bots
        TelegramBotsApi botsApi = new TelegramBotsApi();
        
        
        
        CommandBot commandBot = new CommandBot(Settings.TELEGRAM_BOT_TOKEN, Settings.TELEGRAM_BOT_USERNAME);
        
        
        
        MessageReceivers.createReceivers(commandBot);
        

        try {
          
        
        	// Register your newly created AbilityBot
          botsApi.registerBot(commandBot);
          
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
