package nl.kolkos.telegrambot2.telegram.objects;

import java.util.Date;

import org.json.JSONObject;
import org.telegram.abilitybots.api.objects.MessageContext;
import org.telegram.telegrambots.meta.api.objects.Update;

public class IncomingCommand {
	private TelegramChat telegramChat;
	private TelegramUser telegramUser;
	
	private long updateId;
	private long messageId;
	private int date;
	private String text;
	private String[] arguments;
	
	public IncomingCommand(MessageContext ctx) {
		this.setTelegramUser(new TelegramUser(ctx));
		this.setTelegramChat(new TelegramChat(ctx));
		
		this.setUpdateId(ctx.update().getUpdateId());
		this.setMessageId(ctx.update().getMessage().getMessageId());
		this.setDate(ctx.update().getMessage().getDate());
		this.setText(ctx.update().getMessage().getText());
		this.setArguments(ctx.arguments());
	}
	
	public IncomingCommand(Update upd) {
		
		
		
		this.setUpdateId(upd.getUpdateId());
		this.setMessageId(upd.getMessage().getMessageId());
		this.setDate(upd.getMessage().getDate());
		this.setText(upd.getMessage().getText());
		
	}
	
	public IncomingCommand(JSONObject json) {
				
		// TODO: JSON to objects
		
	}
	
	
	public TelegramChat getTelegramChat() {
		return telegramChat;
	}
	public void setTelegramChat(TelegramChat telegramChat) {
		this.telegramChat = telegramChat;
	}
	public TelegramUser getTelegramUser() {
		return telegramUser;
	}
	public void setTelegramUser(TelegramUser telegramUser) {
		this.telegramUser = telegramUser;
	}
	public long getUpdateId() {
		return updateId;
	}
	public void setUpdateId(long updateId) {
		this.updateId = updateId;
	}
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String[] getArguments() {
		return arguments;
	}
	public void setArguments(String[] arguments) {
		this.arguments = arguments;
	}
	
	
	
	
}
