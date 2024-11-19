package com.assignment2.userservice2.kafkaproducer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.assignment2.userservice2.entities.AddressChangeMsg;

@Configuration
public class UserAddressChangeKafkaConfig {
    
    @Bean
    public ProducerFactory<String, AddressChangeMsg> producerFactoryAddressChange() {
        Map<String, Object> configProps = new HashMap<>();
        
        configProps.put(
          ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
          "kafka:9092");
        
        configProps.put(
          ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
          StringSerializer.class);
        
        configProps.put(
          ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, 
          JsonSerializer.class);

        configProps.put(JsonSerializer.TYPE_MAPPINGS, 
          "AddressChangeMsg:com.assignment2.userservice2.entities.AddressChangeMsg");
        
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, AddressChangeMsg> kafkaTemplateAddressChange() {
        return new KafkaTemplate<>(producerFactoryAddressChange());
    }
}

