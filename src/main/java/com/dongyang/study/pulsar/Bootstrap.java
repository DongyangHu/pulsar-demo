package com.dongyang.study.pulsar;

import com.dongyang.study.pulsar.consumer.ReceiveMessage;
import com.dongyang.study.pulsar.producer.SendMessage;

/**
 * 启动类
 *
 * @author dongyang.hu
 * @date 2019/6/5 14:39
 */
public class Bootstrap {

    public static void main(String[] args) {
        try {
            SendMessage.send();
            Thread.sleep(1000);
            ReceiveMessage.receive();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
