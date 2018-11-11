package nl.kolkos.telegrambot2.rabbitmq.receivers;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

import javax.activity.InvalidActivityException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitmq.client.*;

public class DemoReceiver {
	public static void main(String[] argv) throws IOException, TimeoutException, InvalidParameterException {
		Logger logger = LogManager.getLogger();
		
		logger.info("Starting DemoReceiver...");

		if (argv.length != 2) {
			logger.fatal("Invalid number of parameters: {}", argv.toString());
			throw new InvalidParameterException("This method needs exactly two parameters (hostname, queueName)");
		}

		String hostname = argv[0];
		String queueName = argv[1];
		
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
				
				logger.debug(" [x] Received message: '{}'", message);
				
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}
