package nl.kolkos.java.nl.kolkos.telegrambot2.objects;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

@Entity
public class QueueEntry {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Date created;
	private Date updated;
	private long chatId;
	private int messageId;
	private String messageText;
	private boolean handled = false;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "telegram_user_id")
	private TelegramUser telegramUser;
	
	public QueueEntry() {}
	
	// convert a update to a queue entry
	public QueueEntry(Update update) {
		this.setChatId(update.getMessage().getChatId());
		this.setMessageId(update.getMessage().getMessageId());
		this.setMessageText(update.getMessage().getText());
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public long getChatId() {
		return chatId;
	}

	public void setChatId(long chatId) {
		this.chatId = chatId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public TelegramUser getTelegramUser() {
		return telegramUser;
	}

	public void setTelegramUser(TelegramUser telegramUser) {
		this.telegramUser = telegramUser;
	}
	
	public boolean isHandled() {
		return handled;
	}

	public void setHandled(boolean handled) {
		this.handled = handled;
	}

	@PrePersist
    protected void onCreate() {
		Date date = new Date();
		this.updated = date;
		this.created = date;
    }
	
	@PreUpdate
    protected void onUpdate() {
		this.updated = new Date();
    }
	
//	private long id;
//	private Date created;
//	private Date updated;
//	private long chatId;
//	private int messageId;
//	private String messageText;
//	private boolean handled = false;
	
	public String toString() {
		return String.format("id: %d, created: %s, updated: %s, chatId: %d, messageId: %d, messageText: %s, handled: %s", this.id, this.created, this.updated, this.chatId, this.messageId, this.messageText, this.handled);
	}
}
