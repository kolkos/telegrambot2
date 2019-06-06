package nl.kolkos.telegrambot2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.telegram.telegrambots.meta.api.objects.Update;

import lombok.Data;

@Entity
@Data
public class TelegramUser {
	
	@Id
	private long id;
		
	private boolean bot;
	private String firstName;
	private String lastName;
	private String username;
	private String languageCode;
	
	public TelegramUser(Update update) {
		this.bot = update.getMessage().getFrom().getBot();
		this.id = update.getMessage().getFrom().getId();
		this.firstName = update.getMessage().getFrom().getFirstName();
		this.lastName = update.getMessage().getFrom().getLastName();
		this.languageCode = update.getMessage().getFrom().getLanguageCode();
	}
	
	
}
