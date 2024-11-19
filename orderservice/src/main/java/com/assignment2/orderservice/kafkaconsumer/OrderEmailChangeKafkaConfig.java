package com.assignment2.orderservice.kafkaconsumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.assignment2.orderservice.entities.EmailsChangeMsg;


@EnableKafka
@Configuration
public class OrderEmailChangeKafkaConfig {
    @Bean
    public ConsumerFactory<String, EmailsChangeMsg> emailsChangeMsgConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
            "kafka:9092");
        props.put(
            ConsumerConfig.GROUP_ID_CONFIG, 
            "email-change-consumer");
        props.put(
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
            StringDeserializer.class);
        props.put(
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
            JsonDeserializer.class);
        props.put(JsonDeserializer.TYPE_MAPPINGS, 
            "EmailsChangeMsg:com.assignment2.orderservice.entities.EmailsChangeMsg");

        JsonDeserializer<EmailsChangeMsg> deserializer = new JsonDeserializer<>();
        deserializer.configure(props, false); 
        
        // Wrap it in an ErrorHandlingDeserializer
        ErrorHandlingDeserializer<EmailsChangeMsg> errorHandlingDeserializer = 
            new ErrorHandlingDeserializer<>(deserializer);
        
        return new DefaultKafkaConsumerFactory<>(props, 
            new StringDeserializer(), 
            errorHandlingDeserializer);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EmailsChangeMsg> 
      kafkaListenerContainerFactoryEmailsChange() {
   
        ConcurrentKafkaListenerContainerFactory<String, EmailsChangeMsg> factory =
          new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(emailsChangeMsgConsumerFactory());
        return factory;
    }
}
