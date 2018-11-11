package nl.kolkos.telegrambot2.rabbitmq.receivers;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.generics.BotSession;

import com.rabbitmq.client.*;

import nl.kolkos.telegrambot2.Settings;
import nl.kolkos.telegrambot2.bots.CommandBot;
import nl.kolkos.telegrambot2.rabbitmq.senders.Sender;

public class TextReplyReceiver {
	public static void run(CommandBot commandBot) throws IOException, TimeoutException, InvalidParameterException {
		Logger logger = LogManager.getLogger();
		
		logger.info("Starting {}...", Settings.RABBITMQ_RECEIVER_STANDARD_TEXT_REPLY_NAME);

		
		logger.info("Creating a consumer for hostname '{}' and queueName '{}'", Settings.RABBITMQ_GENERAL_HOSTNAME, Settings.RABBITMQ_RECEIVER_STANDARD_TEXT_REPLY_QUEUE);

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(Settings.RABBITMQ_GENERAL_HOSTNAME);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(Settings.RABBITMQ_RECEIVER_STANDARD_TEXT_REPLY_QUEUE, false, false, false, null);

		logger.debug("Waiting for messages");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				
				logger.debug("Received message to send");
				logger.debug("  [x] queue '{}', message '{}'", Settings.RABBITMQ_RECEIVER_STANDARD_TEXT_REPLY_QUEUE, message);
				
				
				JSONObject json = new JSONObject(message);
				String text = json.getString("message");
				long chatId = json.getLong("chatId");
				
				SendMessage sendMessage = new SendMessage();
				sendMessage.setChatId(chatId);
				sendMessage.setText(text);
				
				commandBot.sendMsg(sendMessage);
				
				logger.debug("  [x] Reply send");
			}
		};
		channel.basicConsume(Settings.RABBITMQ_RECEIVER_STANDARD_TEXT_REPLY_QUEUE, true, consumer);
	}
}
