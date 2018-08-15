package nl.kolkos.java.nl.kolkos.telegrambot2.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.telegram.telegrambots.meta.api.objects.User;

@Entity
public class TelegramUser {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String languageCode;
	
	public TelegramUser() {}
	
	// convert Object
	public TelegramUser(User user) {
		this.setUserId(user.getId());
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setUserName(user.getUserName());
		this.setLanguageCode(user.getLanguageCode());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	
	
}
