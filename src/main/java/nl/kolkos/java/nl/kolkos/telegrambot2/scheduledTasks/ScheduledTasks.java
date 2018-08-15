package nl.kolkos.java.nl.kolkos.telegrambot2.scheduledTasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	@Scheduled(fixedRate=1000, initialDelay = 5000)
	public void handleQueueEntries() {
		System.out.println("Get messages from 'queue'");
	}
}
