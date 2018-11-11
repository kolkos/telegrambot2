package nl.kolkos.telegrambot2.telegram.objects;

import org.telegram.abilitybots.api.objects.MessageContext;

public class TelegramChat {
	private long chatId;
	private String chatType;
	private String chatTitle;
	
	
	public TelegramChat(MessageContext ctx) {
		this.setChatId(ctx.update().getMessage().getChat().getId());
		this.setChatType(ctx.update().getMessage().getChat().isGroupChat() ? "GROUP" : "PRIVATE");
		this.setChatTitle(ctx.update().getMessage().getChat().isGroupChat() ? ctx.update().getMessage().getChat().getTitle() : ctx.update().getMessage().getChat().getUserName());
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
