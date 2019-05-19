package nl.kolkos.telegrambot2.bots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import nl.kolkos.telegrambot2.objects.IncomingCommand;

public class MyAmazingBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
    	// We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            
        	IncomingCommand incommingCommand = new IncomingCommand(update);
        	
        	Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(incommingCommand);
            String jsonUpdate = gson.toJson(update);
        	
            System.out.println(json);
            System.out.println("---");
            System.out.println(jsonUpdate);
            
        	SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "kolkos_ProbeerselBot";
    }

    @Override
    public String getBotToken() {
        return "348807800:AAGEcj83xpwlAhC69GC8mPj3byha3BwJ8-Y";
    }
}
