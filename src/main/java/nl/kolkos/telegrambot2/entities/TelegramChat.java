package nl.kolkos.telegrambot2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.telegram.telegrambots.meta.api.objects.Update;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TelegramChat {
	@Id
	private long id;
	
	private boolean groupChat;
	private String title;
	
	public TelegramChat(Update update) {
		this.groupChat = update.getMessage().getChat().isGroupChat();
		this.id = update.getMessage().getChatId();
		
		if(this.groupChat) {
			this.setTitleForGroupChat(update);
		} else {
			this.setTitleForPersonalChat(update);
		}
		
		
	}
	
	private void setTitleForGroupChat(Update update) {
		this.title = update.getMessage().getChat().getTitle();
	}
	
	private void setTitleForPersonalChat(Update update) {
		this.title = update.getMessage().getChat().getUserName();
	}
	
}
