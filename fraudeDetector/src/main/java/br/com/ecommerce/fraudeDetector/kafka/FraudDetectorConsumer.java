package br.com.ecommerce.fraudeDetector.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FraudDetectorConsumer {

    @KafkaListener(topics = "ECOMMERCE_NEW_ORDER", groupId = "FRAUD_DETECTOR_SERVICE")
    public void listener(String data) {
        log.info(data);
    }

}
