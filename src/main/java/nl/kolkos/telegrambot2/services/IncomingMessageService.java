package nl.kolkos.telegrambot2.services;

import nl.kolkos.telegrambot2.entities.TelegramChat;
import nl.kolkos.telegrambot2.entities.TelegramMessage;
import nl.kolkos.telegrambot2.entities.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class IncomingMessageService {

    private final TelegramChatService telegramChatService;
    private final TelegramUserService telegramUserService;
    private final TelegramMessageService telegramMessageService;

    @Autowired
    public IncomingMessageService(TelegramChatService telegramChatService, TelegramUserService telegramUserService, TelegramMessageService telegramMessageService) {
        this.telegramChatService = telegramChatService;
        this.telegramUserService = telegramUserService;
        this.telegramMessageService = telegramMessageService;
    }

    public TelegramMessage registerIncomingMessage(Update update) {
        // create a chat entry
        TelegramChat telegramChat = new TelegramChat(update);
        // save the chat
        telegramChat = telegramChatService.save(telegramChat);

        // create the user entry
        TelegramUser telegramUser = new TelegramUser(update);
        // save the user
        telegramUser = telegramUserService.save(telegramUser);

        // finally create the message entry
        TelegramMessage telegramMessage = new TelegramMessage(update);
        telegramMessage.setTelegramChat(telegramChat);
        telegramMessage.setTelegramUser(telegramUser);
        // save it
        return telegramMessageService.save(telegramMessage);

    }


}
