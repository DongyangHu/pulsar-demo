package com.dongyang.study.pulsar.base;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

/**
 * pulsar base client
 *
 * @author dongyang.hu
 * @date 2019/6/5 16:31
 */
public class PulsarClientBuilder {

    private static PulsarClient client;

    private static final String PULSAR_SERVER_URL = "pulsar://localhost:6650";

    private PulsarClientBuilder() {
    }

    public static PulsarClient getInstance() {
        if (client == null) {
            try {
                client = PulsarClient.builder().serviceUrl(PULSAR_SERVER_URL).build();
            } catch (PulsarClientException e) {
                e.printStackTrace();
            }
        }
        return client;
    }

    public enum Topic {

        /**
         * 测试
         */
        DEMO("demo-topic"),
        ;

        private String name;

        Topic(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum Subscription {

        /**
         * 测试
         */
        DEMO("demo-subscription"),
        ;

        private String name;

        Subscription(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
