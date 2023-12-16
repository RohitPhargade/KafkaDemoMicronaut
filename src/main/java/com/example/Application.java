package com.example;

import com.example.kafka.KafkaProducerClient;
import com.example.model.Product;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import jakarta.inject.Inject;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = Micronaut.run(Application.class, args);
        KafkaProducerClient producer = context.getBean(KafkaProducerClient.class);
        System.out.println("******************************************************* bean is present?"+ producer != null );
        System.out.println("****************************Sending messages***************************");
        producer.sendProduct("name1",new Product(1,"phone"+ LocalDateTime.now()));
        producer.sendProduct("name1",new Product(5,"mobile"+ LocalDateTime.now()));
        producer.sendProduct("name1",new Product(7,"smartphone"+ LocalDateTime.now()));
        System.out.println("****************************message sent***************************");
    }
}