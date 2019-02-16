package nl.kolkos.telegrambot2.objects;

public class TelegramChat {
	private long chatId;
	private String chatType;
	private String chatTitle;
	
	public TelegramChat() {}
	public TelegramChat(long chatId, String chatType, String chatTitle) {
		this.setChatId(chatId);
		this.setChatType(chatType);
		this.setChatTitle(chatTitle);
	}
	
	public long getChatId() {
		return chatId;
	}
	public void setChatId(long chatId) {
		this.chatId = chatId;
	}
	public String getChatType() {
		return chatType;
	}
	public void setChatType(String chatType) {
		this.chatType = chatType;
	}
	public String getChatTitle() {
		return chatTitle;
	}
	public void setChatTitle(String chatTitle) {
		this.chatTitle = chatTitle;
	}
	
	
}
