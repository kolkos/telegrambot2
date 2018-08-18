package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Setting;
import nl.kolkos.java.nl.kolkos.telegrambot2.repositories.SettingRepository;

@Service
public class SettingServiceImpl implements SettingService{
	@Autowired
	private SettingRepository settingRepository;
	
	@Override
	public void saveSetting(Setting setting) {
		settingRepository.save(setting);

	}
	
	@Override
	public void saveSettings(List<Setting> settings) {
		for(Setting setting : settings) {
			this.saveSetting(setting);
		}
	}

	@Override
	public List<Setting> listSettings() {
		return settingRepository.findAllByOrderBySettingKeyAsc();
	}

	@Override
	public Setting findBySettingKey(String settingKey) {
		return settingRepository.findBySettingKey(settingKey);
	}
	
	
	
	
}
