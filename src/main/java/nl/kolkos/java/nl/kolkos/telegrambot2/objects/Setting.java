package nl.kolkos.java.nl.kolkos.telegrambot2.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Setting {
	@Id
	private String settingKey;
	private String settingValue;
	
	public Setting() {}
	public Setting(String settingKey) {
		this.setSettingKey(settingKey);
	}
	public Setting(String settingKey, String settingValue) {
		this.setSettingKey(settingKey);
		this.setSettingValue(settingValue);
	}
	
	public String getSettingKey() {
		return settingKey;
	}
	public void setSettingKey(String settingKey) {
		this.settingKey = settingKey;
	}
	public String getSettingValue() {
		return settingValue;
	}
	public void setSettingValue(String settingValue) {
		this.settingValue = settingValue;
	}
	
	
	
}
