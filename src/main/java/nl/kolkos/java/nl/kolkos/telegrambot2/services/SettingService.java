package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import java.util.List;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Setting;

public interface SettingService {
	public void saveSetting(Setting setting);
	public void saveSettings(List<Setting> settings);
	public List<Setting> listSettings();
	Setting findBySettingKey(String settingKey);
}
