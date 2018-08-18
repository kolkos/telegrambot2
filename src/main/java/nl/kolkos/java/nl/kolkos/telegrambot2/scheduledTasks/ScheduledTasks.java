package nl.kolkos.java.nl.kolkos.telegrambot2.scheduledTasks;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import nl.kolkos.java.nl.kolkos.telegrambot2.bots.BotCommandHandler;
import nl.kolkos.java.nl.kolkos.telegrambot2.bots.TestBot;
import nl.kolkos.java.nl.kolkos.telegrambot2.objects.ArchivedEntry;
import nl.kolkos.java.nl.kolkos.telegrambot2.objects.QueueEntry;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.ArchivedEntryService;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.QueueEntryService;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.SettingService;

@Component
public class ScheduledTasks{
	@Autowired
	private QueueEntryService queueEntryService;
	
	@Autowired
	private ArchivedEntryService archivedEntryService;
	
	@Autowired
	private SettingService settingsService;
	
	@Autowired
	private BotCommandHandler botCommandHandler;
	
//	@Autowired
//	private TestBot bot;
	
	Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Scheduled(fixedRate=30000, initialDelay = 5000)
	public void handleQueueEntries() {
		
		// check if the bot is stopped
		String botStopped = settingsService.findBySettingKey("BOT_STOPPED").getSettingValue();
		if(botStopped.equals("True")) {
			logger.info("The bot is stopped; not handling any queue entries.");
			return;
		}
		
		List<QueueEntry> queueEntries = queueEntryService.findUnhandledEntriesOldToNew();
		for(QueueEntry entry : queueEntries) {
			logger.info(String.format("handle '%s' send by '%s'", entry.getMessageText(), entry.getTelegramUser().getUserName()));
			
			// random time to fake handling a request
			// TODO: remove this
//			try {
//				Thread.sleep((long)(Math.random() * 5000));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
			botCommandHandler.setQueueEntry(entry);
			botCommandHandler.handleCommand();
			
//			SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
//	                .setChatId(entry.getChatId())
//	                .setText("Let's pretend I've handled " + entry.getMessageText());
//	        
//			System.out.println(message.toString());
//			
//			try {
//	            bot.execute(message); // Call method to send the message
//	        } catch (TelegramApiException e) {
//	            e.printStackTrace();
//	        }
			
			entry.setHandled(true);
			queueEntryService.save(entry);
			
			logger.info(String.format("handled '%s' send by '%s'", entry.getMessageText(), entry.getTelegramUser().getUserName()));
		}
	}
	
	@Scheduled(fixedRate=60000, initialDelay = 5000)
	public void archiveHandledQueueEntries() {
		List<QueueEntry> queueEntries = queueEntryService.findHandledEntries();
		for(QueueEntry entry : queueEntries) {
			logger.info(String.format("Archiving QueueEntry %d", entry.getId()));
			
			// create a archived entry
			ArchivedEntry archivedEntry = new ArchivedEntry(entry);
			
			// save this entry
			archivedEntryService.save(archivedEntry);
			
			// delete the QueueEntry
			queueEntryService.delete(entry);
		}
	}
}
