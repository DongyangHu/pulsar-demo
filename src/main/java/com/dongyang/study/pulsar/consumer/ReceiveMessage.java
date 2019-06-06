package com.dongyang.study.pulsar.consumer;

import com.dongyang.study.pulsar.base.PulsarClientBuilder;
import org.apache.pulsar.client.api.*;

import java.util.concurrent.Executors;

/**
 * receive message
 *
 * @author dongyang.hu
 * @date 2019/6/5 17:09
 */
public class ReceiveMessage {

    public static void receive() {
        Executors.newFixedThreadPool(1).execute(() -> {
            try {
                PulsarClient client = PulsarClientBuilder.getInstance();
                Consumer consumer = client.newConsumer(Schema.STRING)
                        .topic(PulsarClientBuilder.Topic.DEMO.getName())
                        .subscriptionName(PulsarClientBuilder.Subscription.DEMO.getName()).subscribe();
                while (true) {
                    Message message = consumer.receive();
                    System.out.println("receive message: " + message.getValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
