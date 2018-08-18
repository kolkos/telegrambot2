package nl.kolkos.java.nl.kolkos.telegrambot2.bots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.QueueEntry;
import nl.kolkos.java.nl.kolkos.telegrambot2.objects.TelegramUser;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.QueueEntryService;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.SettingService;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.TelegramUserService;

@Component
public class TestBot extends TelegramLongPollingBot {
	
	@Autowired
	private QueueEntryService queueEntryService;
	
	@Autowired
	private TelegramUserService telegramUserService;
	
	@Autowired 
	private SettingService settingService;
	
	private String token;
	private String username;
		
	/*
	 * Getters & Setters
	 */
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
		
	@Override
    public void onUpdateReceived(Update update) {
		// We check if the update has a message and the message has text
	    if (this.updateContainsText(update) && this.updateIsCommand(update)) {
	        	    	// check if the TelegramUser exists
	    	TelegramUser telegramUser = telegramUserService.findByTelegramUserId(update.getMessage().getFrom().getId());
	    	if(telegramUser == null) {
	    		// does not exist, create one
	    		telegramUser = new TelegramUser(update.getMessage().getFrom());
	    		telegramUserService.save(telegramUser);
	    	}
	    	
	    	// now add the User to the QueueEntry
	    	QueueEntry queueEntry = new QueueEntry(update);
	    	queueEntry.setTelegramUser(telegramUser);
	    	
	    	// finally save the QueueEntry
	    	queueEntryService.save(queueEntry);
	    		    	
//    		SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
//	                .setChatId(update.getMessage().getChatId())
//	                .setText(update.getMessage().getText());
//	        try {
//	            execute(message); // Call method to send the message
//	        } catch (TelegramApiException e) {
//	            e.printStackTrace();
//	        }

	    }
    }

    @Override
    public String getBotUsername() {
    	if(this.username == null) {
    		String username = settingService.findBySettingKey("BOT_USERNAME").getSettingValue();
            this.setUsername(username);
    	}
    	
    	return this.getUsername();
    }

    @Override
    public String getBotToken() {
    	if(this.token == null) {
    		String token = settingService.findBySettingKey("BOT_TOKEN").getSettingValue();
    		this.setToken(token);
    	}
    	    	
    	return this.getToken();
    }
    
    private boolean updateContainsText(Update update) {
    	boolean containsText = false;
    	if (update.hasMessage() && update.getMessage().hasText()) {
    		containsText = true;
    	}
    	
    	return containsText;
    }
    
    private boolean updateIsCommand(Update update) {
    	boolean isCommand = false;
    	
    	String message = update.getMessage().getText();
    	if(message.matches("^\\/.*$")) {
    		isCommand = true;
    	}
    	
    	return isCommand;
    }
}
