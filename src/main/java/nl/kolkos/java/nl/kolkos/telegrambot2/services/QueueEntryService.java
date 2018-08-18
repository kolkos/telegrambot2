package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import java.util.List;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.QueueEntry;

public interface QueueEntryService {
	public void save(QueueEntry queueEntry);
	public List<QueueEntry> findUnhandledEntriesOldToNew();
	public List<QueueEntry> findUnhandledEntriesNewToOld();
	public List<QueueEntry> findHandledEntries();
	public void delete(QueueEntry queueEntry);
}
