package nl.kolkos.telegrambot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.telegram.telegrambots.ApiContextInitializer;

import nl.kolkos.telegrambot2.configuration.TelegramConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(TelegramConfiguration.class)
public class Telegrambot2Application {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		
		SpringApplication.run(Telegrambot2Application.class, args);
	}

}
