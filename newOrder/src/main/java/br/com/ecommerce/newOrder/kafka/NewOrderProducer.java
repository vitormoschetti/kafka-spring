package br.com.ecommerce.newOrder.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
@AllArgsConstructor
public class NewOrderProducer {

    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(ProducerRecord<String, String> record) {

        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(record);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("New order [{}] delivered with offset {}",
                        record.value(),
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.warn("Unable to deliver new order [{}]. {}",
                        record.value(),
                        ex.getMessage());
            }
        });
    }
}