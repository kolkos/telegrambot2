package nl.kolkos.telegrambot2.rabbitmq;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import nl.kolkos.telegrambot2.bots.CommandBot;
import nl.kolkos.telegrambot2.rabbitmq.receivers.TextReplyReceiver;
import nl.kolkos.telegrambot2.stub.Stub;

public class MessageReceivers {
	public static void createReceivers(CommandBot commandBot) {
		Logger logger = LogManager.getLogger();
		
		
		try {
        	//String[] parametersDemo = {"localhost", "hello"};
			//DemoReceiver.main(parametersDemo);
			
			Stub.run("localhost");
			TextReplyReceiver.run(commandBot);
			
		} catch (InvalidParameterException | IOException | TimeoutException e1) {
			// TODO Auto-generated catch block
			logger.fatal(e1.getMessage());
			e1.printStackTrace();
		}
		
		
	}
}
