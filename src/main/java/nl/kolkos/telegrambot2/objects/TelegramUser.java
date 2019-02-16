package nl.kolkos.telegrambot2.objects;

public class TelegramUser {
	private long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String languageCode;
	private boolean bot;
	
	public TelegramUser() {}
	
	public TelegramUser(long userId,
			String userName,
			String firstName,
			String lastName,
			String languageCode,
			boolean bot) {
		
		this.setUserId(userId);
		this.setUserName(userName);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setLanguageCode(languageCode);
		this.setBot(bot);
		
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public boolean isBot() {
		return bot;
	}
	public void setBot(boolean bot) {
		this.bot = bot;
	}
	
	
	
}
