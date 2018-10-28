package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


	@Override
	public Page<ArchivedEntry> getArchivedEntries(Pageable pageable) {
		return archivedEntryRepository.findAll(pageable);
	}




}
