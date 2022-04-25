package se.iths.jmsdemo220425.sender;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.iths.jmsdemo220425.config.JmsConfig;
import se.iths.jmsdemo220425.model.MessageObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Sender {

    private final JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {

        System.out.println("Sending message...");

        MessageObject messageObject =
                new MessageObject(UUID.randomUUID(), "Hello from JU20DEC_QUEUE!", LocalDateTime.now());
        jmsTemplate.convertAndSend(JmsConfig.JU20DEC_QUEUE, messageObject);

        System.out.println("Message sent!");

    }
}
