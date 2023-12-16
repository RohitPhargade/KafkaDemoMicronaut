package com.example.kafka;


import com.example.constant.Constants;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Property;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.util.List;
import java.util.Map;

@KafkaListener(
//        clientId = "",
//        groupId = "",
//        autoStartup = false,
//        batch = true,
//        offsetReset = OffsetReset.EARLIEST,
//        producerClientId = "",
        properties = {
                @Property(name = ConsumerConfig.MAX_POLL_RECORDS_CONFIG ,value = "2000"),
                @Property(name = ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG ,value = "900000"),
                @Property(name = ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG ,value = "409715200"),
                @Property(name = ConsumerConfig.FETCH_MAX_BYTES_CONFIG ,value = "1209715200")
        }
)
public class KafkaConsumerClient {

    @Topic(Constants.TOPIC1)
    public void receive(List<Map<String, Object>> message, List<Long> offset){
        System.out.println("--------------------------------------------Listening");
        System.out.println("--------------------------------------------offset = "+ offset);
        System.out.println("--------------------------------------------message = "+ message);
        System.out.println("--------------------------------------------Listening completed");

    }


}
