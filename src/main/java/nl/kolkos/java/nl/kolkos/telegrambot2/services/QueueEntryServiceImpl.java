package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.QueueEntry;
import nl.kolkos.java.nl.kolkos.telegrambot2.repositories.QueueEntryRepository;

@Service
public class QueueEntryServiceImpl implements QueueEntryService{
	
	@Autowired
	private QueueEntryRepository queueEntryRepository;

	@Override
	public void save(QueueEntry queueEntry) {
		queueEntryRepository.save(queueEntry);
		
	}
	
}
