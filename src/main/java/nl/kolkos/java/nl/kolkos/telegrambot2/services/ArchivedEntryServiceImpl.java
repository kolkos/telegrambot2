package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.ArchivedEntry;
import nl.kolkos.java.nl.kolkos.telegrambot2.repositories.ArchivedEntryRepository;

@Service
public class ArchivedEntryServiceImpl implements ArchivedEntryService{
	@Autowired
	private ArchivedEntryRepository archivedEntryRepository;
	
	
	@Override
	public void save(ArchivedEntry archivedEntry) {
		archivedEntryRepository.save(archivedEntry);
	}

}
