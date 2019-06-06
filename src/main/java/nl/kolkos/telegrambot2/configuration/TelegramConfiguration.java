package nl.kolkos.telegrambot2.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "telegram")
@Data
public class TelegramConfiguration {
	private String botname;
	private String token;
	
	
}
