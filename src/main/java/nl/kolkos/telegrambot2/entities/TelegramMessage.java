package nl.kolkos.telegrambot2.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.telegram.telegrambots.meta.api.objects.Update;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TelegramMessage {
	@Id
	@GeneratedValue
	private long id;
	
	
	private boolean command;
	private boolean reply;
	private long messageId;
	private Date date;
	private String text;

	private int status = 0;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="telegram_user_id")
	private TelegramUser telegramUser;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="telegram_chat_id")
	private TelegramChat telegramChat;
	
	public TelegramMessage(Update update) {
		this.command = update.getMessage().isCommand();
		this.reply = update.getMessage().isReply();
		
		this.messageId = update.getMessage().getMessageId();
		this.date = new Date();
		this.text = update.getMessage().getText();
		
	}
	
}
