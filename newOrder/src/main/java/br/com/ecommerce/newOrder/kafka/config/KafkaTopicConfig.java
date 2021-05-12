package br.com.ecommerce.newOrder.kafka.config;

import br.com.ecommerce.newOrder.kafka.Topics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic newOrderTopic() {
        return TopicBuilder
                .name(Topics.ECOMMERCE_NEW_ORDER.name())
                .build();
    }

    @Bean
    public NewTopic sendEmailTopic() {
        return TopicBuilder
                .name(Topics.ECOMMERCE_SEND_EMAIL.name())
                .build();
    }

}