package nl.kolkos.telegrambot2.stub;

import nl.kolkos.telegrambot2.tools.PrettyPrinter;

public class StubReplyMessage {
	private long chatId;
	private String message;
	
	public long getChatId() {
		return chatId;
	}
	public void setChatId(long chatId) {
		this.chatId = chatId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return String.format("StubReplyMessage{ chatId: %d, message: %s }", chatId, message);
	}
	
	public String toJsonString() {
		return PrettyPrinter.createJsonString(this);
	}
	
}
