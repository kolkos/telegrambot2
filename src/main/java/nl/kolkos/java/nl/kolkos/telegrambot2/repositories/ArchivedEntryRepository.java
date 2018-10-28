package nl.kolkos.java.nl.kolkos.telegrambot2.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.ArchivedEntry;

@Repository
public interface ArchivedEntryRepository extends PagingAndSortingRepository<ArchivedEntry, Long>{
	public Page<ArchivedEntry> findAll(Pageable pageable);
	
}
