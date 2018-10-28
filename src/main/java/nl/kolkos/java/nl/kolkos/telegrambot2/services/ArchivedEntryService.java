package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.ArchivedEntry;

public interface ArchivedEntryService {
	public void save(ArchivedEntry archivedEntry);
	public Page<ArchivedEntry> getArchivedEntries(Pageable pageable);
}
