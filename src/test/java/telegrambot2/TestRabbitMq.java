package telegrambot2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;

import com.rabbitmq.client.ConnectionFactory;

import nl.kolkos.telegrambot2.rabbitmq.receivers.DemoReceiver;
import nl.kolkos.telegrambot2.rabbitmq.senders.Sender;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

class TestRabbitMq {

	@Test
	void send() throws IOException, TimeoutException {
		String queueName = "hello";
		String host = "localhost";
		
		
		
	}
	
	@Test
	void receive() throws IOException, TimeoutException {
		String queueName = "hello";
		String hostname = "localhost";
		
		String[] parameters = {hostname, queueName};
		
		DemoReceiver.main(parameters);
		
	}
	
	

}
