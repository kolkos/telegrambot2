package nl.kolkos.java.nl.kolkos.telegrambot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.QueueEntry;

@Repository
public interface QueueEntryRepository extends JpaRepository<QueueEntry, Long>{

}
