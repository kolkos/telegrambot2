package nl.kolkos.telegrambot2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.kolkos.telegrambot2.configuration.RabbitMQConfiguration;
import nl.kolkos.telegrambot2.entities.TelegramMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMessageToRabbitMQService {

    @Autowired
    private RabbitMQConfiguration rabbitMQConfiguration;

    @Autowired
    private RabbitTemplate template;

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMessageToRabbitMQService.class);

    public void sendMessageToQueue(TelegramMessage telegramMessage) throws JsonProcessingException {
//        Queue queue = new Queue(rabbitMQConfiguration.getOutgoingQueue());

        this.template.convertAndSend(rabbitMQConfiguration.getExchange(), rabbitMQConfiguration.getOutgoingQueue(), this.convertTelegramMessageToJson(telegramMessage));
        LOGGER.info("Msg send to '{}'", rabbitMQConfiguration.getOutgoingQueue());
    }

    private String convertTelegramMessageToJson(TelegramMessage telegramMessage) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(telegramMessage);
    }

}
