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

@Entity
public class ArchivedEntry {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Date archived;
	private long chatId;
	private int messageId;
	private String messageText;
	private Date handled;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "telegram_user_id")
	private TelegramUser telegramUser;
	
	public ArchivedEntry() {}
	public ArchivedEntry(QueueEntry queueEntry) {
		this.setChatId(queueEntry.getChatId());
		this.setMessageId(queueEntry.getMessageId());
		this.setMessageText(queueEntry.getMessageText());
		this.setTelegramUser(queueEntry.getTelegramUser());
		this.setHandled(queueEntry.getUpdated());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getArchived() {
		return archived;
	}

	public void setArchived(Date archived) {
		this.archived = archived;
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
	
	public Date getHandled() {
		return handled;
	}
	public void setHandled(Date handled) {
		this.handled = handled;
	}
	@PrePersist
    protected void onCreate() {
		this.archived = new Date();
    }
	
}
