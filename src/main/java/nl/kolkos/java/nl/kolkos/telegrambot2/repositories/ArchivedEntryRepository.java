package nl.kolkos.java.nl.kolkos.telegrambot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.ArchivedEntry;

@Repository
public interface ArchivedEntryRepository extends JpaRepository<ArchivedEntry, Long>{
	
}
