package nl.kolkos.telegrambot2.rabbitmq.senders;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {
	
	public static void sendMessage(String hostname, String queueName, String message) throws IOException, TimeoutException {
		Logger logger = LogManager.getLogger();
		
		
		logger.debug("Sending message");
		logger.debug("  [x] Connecting to '{}' on '{}'", queueName, hostname);
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(hostname);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(queueName, false, false, false, null);
		logger.debug("  [x] [{}] Sending message '{}'", queueName, message.replaceAll("\r\n", "").replaceAll("\n", ""));
				
		channel.basicPublish("", queueName, null, message.getBytes());
		logger.debug("  [x] Message send");
		
		logger.debug("  [x] Closing connection with '{}' on '{}'", queueName, hostname);
		channel.close();
		connection.close();
		
		logger.debug("  [x] Connection closed");
		
	}
}
