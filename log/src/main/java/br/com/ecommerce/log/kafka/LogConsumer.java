package br.com.ecommerce.log.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogConsumer {

    @KafkaListener(topicPattern = "ECOMMERCE.*", groupId = "LOG_SERVICE")
    public void listener(String data) {
        log.info(data);
    }

}
