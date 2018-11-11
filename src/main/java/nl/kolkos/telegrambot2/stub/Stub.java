package nl.kolkos.telegrambot2.stub;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

import javax.activity.InvalidActivityException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import com.rabbitmq.client.*;

import nl.kolkos.telegrambot2.rabbitmq.senders.Sender;
import nl.kolkos.telegrambot2.telegram.objects.IncomingCommand;

public class Stub {
	public static void run(String hostname) throws IOException, TimeoutException, InvalidParameterException {
		Logger logger = LogManager.getLogger();
		
		logger.info("Starting DemoReceiver...");

		String queueName = "stub";
		
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
				
				logger.debug("Stub received message");
				
				logger.debug("  [{}] Received message: '{}'", String.format("%-20s", queueName), message.replaceAll("\r\n", "").replaceAll("\n", ""));
				
				
				JSONObject json = new JSONObject(message);
				String text = json.getString("text");
				String username = json.getJSONObject("telegramUser").getString("userName");
				long chatId = json.getJSONObject("telegramChat").getLong("chatId");
				
				
				String msg = String.format("Hi %s, I received '%s'", username, text);
				
				StubReplyMessage srm = new StubReplyMessage();
				srm.setChatId(chatId);
				srm.setMessage(msg);
				
				try {
					Thread.sleep((long)((Math.random() * 1000) + 500));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// send the reply
				try {
					Sender.sendMessage("localhost", "textReply", srm.toJsonString());
				} catch (TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}
