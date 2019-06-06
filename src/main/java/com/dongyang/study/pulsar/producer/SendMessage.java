package com.dongyang.study.pulsar.producer;

import com.dongyang.study.pulsar.base.PulsarClientBuilder;
import org.apache.pulsar.client.api.*;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * send massage
 *
 * @author dongyang.hu
 * @date 2019/6/5 16:14
 */
public class SendMessage {

    private static final String MESSAGE_TEMPLATE = "pulsar-message-%s";

    public static void send() {
        Executors.newFixedThreadPool(1).execute(() -> {
            int sendTimes = 0;
            try {
                PulsarClient client = PulsarClientBuilder.getInstance();
                Producer<String> producer = client.newProducer(Schema.STRING)
                        .topic(PulsarClientBuilder.Topic.DEMO.getName())
                        .batchingMaxPublishDelay(10, TimeUnit.MILLISECONDS)
                        .sendTimeout(10, TimeUnit.SECONDS)
                        .blockIfQueueFull(true).create();
                while (true) {
                    String message = String.format(MESSAGE_TEMPLATE, ++sendTimes);
                    System.out.println("send message: " + message);
                    producer.send(message);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
