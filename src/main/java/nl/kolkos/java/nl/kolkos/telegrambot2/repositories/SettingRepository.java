package nl.kolkos.java.nl.kolkos.telegrambot2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Setting;

@Repository
public interface SettingRepository extends JpaRepository<Setting, String>{
	List<Setting> findAllByOrderBySettingKeyAsc();
	Setting findBySettingKey(String settingKey);
}
