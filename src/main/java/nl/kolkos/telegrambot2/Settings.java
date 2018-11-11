package nl.kolkos.telegrambot2;

public class Settings {
	/*
	 * RabbitMQ Settings
	 * General
	 */
	public static String RABBITMQ_GENERAL_HOSTNAME = "localhost";
	
	/*
	 * RabbitMQ Settings
	 * TextReplyReceiver settings
	 */
	public static String RABBITMQ_RECEIVER_STANDARD_TEXT_REPLY_NAME = "textReplyReceiver";
	public static String RABBITMQ_RECEIVER_STANDARD_TEXT_REPLY_QUEUE = "textReply";
	
	
	
	/*
	 * Telegram settings
	 */
	public static String TELEGRAM_BOT_TOKEN = "YourTokenHere";
	public static String TELEGRAM_BOT_USERNAME = "BotUserNameHere";
	
	
}
