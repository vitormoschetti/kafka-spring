package br.com.ecommerce.email.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailConsumer {

    @KafkaListener(topics = "ECOMMERCE_SEND_EMAIL", groupId = "EMAIL_SERVICE")
    public void listener(String data) {
        log.info(data);
    }

}
