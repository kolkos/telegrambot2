package nl.kolkos.telegrambot2.bots;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import nl.kolkos.telegrambot2.rabbitmq.senders.Sender;
import nl.kolkos.telegrambot2.telegram.objects.IncomingCommand;
import nl.kolkos.telegrambot2.tools.PrettyPrinter;

import static org.telegram.abilitybots.api.objects.Flag.REPLY;
import static org.telegram.abilitybots.api.objects.Flag.MESSAGE;
import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CommandBot extends AbilityBot {
	
	Logger logger = LogManager.getLogger();
	
	public CommandBot(String token, String username) {
		super(token, username);
	}

	@Override
	public int creatorId() {
		return 123456789;
	}
	
	public void sendMsg(SendMessage sendMessage) {
		logger.debug("====== sendMsg");
		
		this.silent.execute(sendMessage);
	}
	
	public Ability sayHelloWorld() {
	    return Ability
	              .builder()
	              .name("hello")
	              .info("says hello world!")
	              .locality(ALL)
	              .privacy(PUBLIC)
	              .action(ctx -> 
	              	{
	              		silent.send("Hello world!", ctx.chatId());
	              		logger.info("Testje");
	              		
	              		
	              		
	              		PrettyPrinter.prettyPrintObject(ctx);
	              		
	              		IncomingCommand dtm = new IncomingCommand(ctx);
	              		PrettyPrinter.prettyPrintObject(dtm);
	              	}
	              )
	              .build();
	}
	
	public Ability startCommand() {
		String message = "Please tell me your name";
		
		return Ability
				.builder()
				.name("start")
				.info("Use this command to start using the bot")
				.locality(ALL)
				.privacy(PUBLIC)
				.input(0)
				.action(ctx -> silent.forceReply(message, ctx.chatId()))
				.reply(upd -> 
					{
						logger.info(getBotUsername());
						
						logger.info(PrettyPrinter.createJsonString(upd));
						
		            	// Prints to console
						logger.info("In the reply");
						// Sends message
						silent.send("Hi " + upd.getMessage().getText(), upd.getMessage().getChatId());
		            },
		            // Now we start declaring conditions, MESSAGE is a member of the enum Flag class
		            // That class contains out-of-the-box predicates for your replies!
		            // MESSAGE means that the update must have a message
		            // This is imported statically, Flag.MESSAGE
		            MESSAGE,
		            // REPLY means that the update must be a reply, Flag.REPLY
		            REPLY,
		            // A new predicate user-defined
		            // The reply must be to the bot
		            isReplyToBot(),
		            // If we process similar logic in other abilities, then we have to make this reply specific to this message
		            // The reply is to the playMessage
		            isReplyToMessage(message)
		        )
				.build();

	}
	
	private Predicate<Update> isReplyToMessage(String message) {
		return upd -> {
			logger.debug("isReplyToMessage");
			
			Message reply = upd.getMessage().getReplyToMessage();
			return reply.hasText() && reply.getText().equalsIgnoreCase(message);
		};
	}

	private Predicate<Update> isReplyToBot() {
		
		return upd -> {
			String correctedUsername = getBotUsername().replaceAll("^@", "");
			return upd.getMessage().getReplyToMessage().getFrom().getUserName().equalsIgnoreCase(correctedUsername);
		};
		
	}
	
	public Ability expectOneArgument() {
		return Ability
				.builder()
				.name("deposit")
				.info("register a deposit")
				.locality(ALL)
				.privacy(PUBLIC)
				.input(0)
				.action(ctx ->
					{
						IncomingCommand dtm = new IncomingCommand(ctx);
						try {
							Sender.sendMessage("localhost", "stub", PrettyPrinter.createJsonString(dtm));
						} catch (IOException | TimeoutException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						silent.send("Working on it", ctx.chatId());
						
						
					}
				)
				.build();
	}
	
//	public Ability sayNiceToPhoto() {
//		
//	    return Ability.builder()
//	        .name(DEFAULT) // DEFAULT ability is executed if user did not specify a command -> Bot needs to have access to messages (check FatherBot)
////	        .flag(PHOTO)
////	        .flag(TEXT)
//	        .privacy(PUBLIC)
//	        .locality(ALL)
//	        .input(0)
//	        .action(ctx -> silent.send("Daaaaang, what a nice photo!", ctx.chatId()))
//	        .build();
//	  }
}
