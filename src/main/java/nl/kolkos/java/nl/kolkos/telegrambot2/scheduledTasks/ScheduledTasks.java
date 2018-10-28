package nl.kolkos.java.nl.kolkos.telegrambot2.scheduledTasks;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
		
	Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	
}
