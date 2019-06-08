package nl.kolkos.telegrambot2.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class RabbitMQConfiguration {

    @Value("${rabbitmq.queue.out}")
    private String outgoingQueue;

    @Value("${rabbitmq.exchange}")
    private String exchange;

}
