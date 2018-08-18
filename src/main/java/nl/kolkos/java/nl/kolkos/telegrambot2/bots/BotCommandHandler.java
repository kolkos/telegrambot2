package nl.kolkos.java.nl.kolkos.telegrambot2.bots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import nl.kolkos.java.nl.kolkos.telegrambot2.objects.QueueEntry;

@Component
public class BotCommandHandler {
	
	@Autowired
	private TestBot bot;
	
	private QueueEntry queueEntry;
	
	public QueueEntry getQueueEntry() {
		return queueEntry;
	}

	public void setQueueEntry(QueueEntry queueEntry) {
		this.queueEntry = queueEntry;
	}
	
	public void handleCommand() {
		this.stub();
	}
	
	public void stub() {
		SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                .setChatId(this.queueEntry.getChatId())
                .setText("Let's pretend I've handled " + this.queueEntry.getMessageText());
		try {
            bot.execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}
	
}
