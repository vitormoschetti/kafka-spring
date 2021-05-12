package br.com.ecommerce.newOrder.service;

import br.com.ecommerce.newOrder.kafka.NewOrderProducer;
import br.com.ecommerce.newOrder.kafka.Topics;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewOrderService {

    private NewOrderProducer newOrderProducer;

    public void create() {

        var order = "123,123,321";
        var email = "Thank you for your order! We are processing your order!";

        final var newOrder = new ProducerRecord<>(Topics.ECOMMERCE_NEW_ORDER.name(), order, order);
        final var sendEmailRecord = new ProducerRecord<>(Topics.ECOMMERCE_SEND_EMAIL.name(), email, email);

        newOrderProducer.sendMessage(newOrder);
        newOrderProducer.sendMessage(sendEmailRecord);

    }

}
