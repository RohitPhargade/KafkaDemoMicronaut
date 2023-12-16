package com.example.kafka;


import com.example.constant.Constants;
import com.example.model.Product;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Property;
import org.apache.kafka.clients.producer.ProducerConfig;

@KafkaClient(
        id = "product-client",
        acks = KafkaClient.Acknowledge.ONE,
        properties = {
                @Property(name = ProducerConfig.RETRIES_CONFIG, value = "5"),
                @Property(name = ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, value = Constants.BOOSTRAP_SERVER)
        }
)
public interface KafkaProducerClient {


    @Topic(Constants.TOPIC1)
    void sendProduct(@KafkaKey String name, Product product);

}
