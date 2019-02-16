package nl.kolkos.telegrambot2.objects;

import org.telegram.telegrambots.meta.api.objects.Update;

public class IncomingCommand {
	private TelegramChat telegramChat;
	private TelegramUser telegramUser;
	
	private long updateId;
	private long messageId;
	private int date;
	private String text;
	private String[] arguments;
	
	
	public IncomingCommand(Update update) {
		// first the user stuff
		long userId = update.getMessage().getFrom().getId();
		String userName = update.getMessage().getFrom().getUserName();
		String firstName = update.getMessage().getFrom().getFirstName();
		String lastName = update.getMessage().getFrom().getLastName();
		String languageCode = update.getMessage().getFrom().getLanguageCode();
		boolean bot = update.getMessage().getFrom().getBot();
		
		// create TelegramUser object
		TelegramUser telegramUser = new TelegramUser(userId, userName, firstName, lastName, languageCode, bot);
		
		// the chat stuff
		long chatId = update.getMessage().getChatId();
		String chatTitle = update.getMessage().getChat().getTitle();
		String chatType = update.getMessage().getChat().getDescription();
		
		// create the chat object
		TelegramChat telegramChat = new TelegramChat(chatId, chatType, chatTitle);
		
		// finally create the incoming command object
		
	}
	
	
	public TelegramChat getTelegramChat() {
		return telegramChat;
	}
	public void setTelegramChat(TelegramChat telegramChat) {
		this.telegramChat = telegramChat;
	}
	public TelegramUser getTelegramUser() {
		return telegramUser;
	}
	public void setTelegramUser(TelegramUser telegramUser) {
		this.telegramUser = telegramUser;
	}
	public long getUpdateId() {
		return updateId;
	}
	public void setUpdateId(long updateId) {
		this.updateId = updateId;
	}
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String[] getArguments() {
		return arguments;
	}
	public void setArguments(String[] arguments) {
		this.arguments = arguments;
	}
	
	
}
