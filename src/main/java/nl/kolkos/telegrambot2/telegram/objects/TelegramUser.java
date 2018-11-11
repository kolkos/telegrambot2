package nl.kolkos.telegrambot2.telegram.objects;

import org.telegram.abilitybots.api.objects.MessageContext;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramUser {
	private long userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String languageCode;
	private boolean bot;
	
	public TelegramUser(MessageContext ctx) {
		this.setUserId(ctx.user().getId());
		this.setFirstName(ctx.user().getFirstName());
		this.setLastName(ctx.user().getLastName());
		this.setUserName(ctx.user().getUserName());
		this.setLanguageCode(ctx.user().getLanguageCode());
		this.setBot(ctx.user().getBot());
	}
	
	public TelegramUser(Update upd) {
		this.setUserId(upd.getMessage().getFrom().getId());
		this.setFirstName(upd.getMessage().getFrom().getFirstName());
		this.setLastName(upd.getMessage().getFrom().getLastName());
		this.setUserName(upd.getMessage().getFrom().getUserName());
		this.setLanguageCode(upd.getMessage().getFrom().getLanguageCode());
		this.setBot(upd.getMessage().getFrom().getBot());
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public boolean isBot() {
		return bot;
	}
	public void setBot(boolean bot) {
		this.bot = bot;
	}
	
	
}
