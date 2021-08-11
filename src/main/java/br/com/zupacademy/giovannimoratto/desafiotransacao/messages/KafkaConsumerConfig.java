package br.com.zupacademy.giovannimoratto.desafiotransacao.messages;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author giovanni.moratto
 */

@Configuration
public class KafkaConsumerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ConcurrentKafkaListenerContainerFactory <String, TransactionMessage> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory <String, TransactionMessage> factory =
                new ConcurrentKafkaListenerContainerFactory <>();
        factory.setConsumerFactory(transactionConsumerFactory());

        return factory;
    }

    @Bean
    public ConsumerFactory <String, TransactionMessage> transactionConsumerFactory() {
        StringDeserializer stringDeserializer = new StringDeserializer();
        JsonDeserializer <TransactionMessage> jsonDeserializer = new JsonDeserializer <>(
                TransactionMessage.class,
                false);

        return new DefaultKafkaConsumerFactory <>(consumerConfigurations(), stringDeserializer, jsonDeserializer);
    }

    public Map <String, Object> consumerConfigurations() {
        Map <String, Object> properties = new HashMap <>();
        properties.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(
                ConsumerConfig.CLIENT_ID_CONFIG, kafkaProperties.getConsumer().getClientId());
        properties.put(
                ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
        properties.put(
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset());

        return properties;
    }

}