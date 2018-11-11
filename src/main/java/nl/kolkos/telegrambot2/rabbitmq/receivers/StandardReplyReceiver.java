package nl.kolkos.telegrambot2.rabbitmq.receivers;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

import javax.activity.InvalidActivityException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitmq.client.*;

import nl.kolkos.telegrambot2.bots.CommandBot;

public class StandardReplyReceiver {
	public static void run(String hostname, CommandBot commandBot) throws IOException, TimeoutException, InvalidParameterException {
		Logger logger = LogManager.getLogger();
		
		logger.info("Starting DemoReceiver...");

		String queueName = "textReply";
		
		logger.info("Creating a consumer for hostname '{}' and queueName '{}'", hostname, queueName);

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(hostname);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(queueName, false, false, false, null);

		logger.debug("Waiting for messages");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				
				logger.debug(" [{}] Received message: '{}'", String.format("%-20s", queueName), message);
				
				
				
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}
