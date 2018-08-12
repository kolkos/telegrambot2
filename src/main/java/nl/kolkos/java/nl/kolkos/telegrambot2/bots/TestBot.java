package nl.kolkos.java.nl.kolkos.telegrambot2.bots;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class TestBot extends AbilityBot {

	@Override
	public int creatorId() {
		return 204878733;
	}
	
	public TestBot(String BOT_TOKEN, String BOT_USERNAME)  {
		super(BOT_TOKEN, BOT_USERNAME);
	}
	
	
	public Ability sayHelloWorld() {
	    return Ability
	              .builder()
	              .name("hello")
	              .info("says hello world!")
	              .locality(ALL)
	              .privacy(PUBLIC)
	              .action(ctx -> silent.send("Hello world!", ctx.chatId()))
	              .build();
	}
}
