package com.look.common.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class RabbitMQConsumerUtil {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        ConnectionFactory factory = new ConnectionFactory();
        //指定协议://用户名:密码@IP地址:端口号/虚拟主机
        //虚拟主机为/，这里要写它的转义字符：%2f
        factory.setUri("amqp://root:991112.l@42.192.11.203:5672/%2f");
        try(
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
        ) {
            // 确保MQ中有该队列，如果没有则创建
            channel.queueDeclare("queue.test1", false, false, true, null);
              // 拉消息模式
              // 指定从哪个消费者消费消息，指定是否自动确认消息
//            final GetResponse getResponse = channel.basicGet("queue.test1", true);
              // 获取消息体并打印
//            final byte[] body = getResponse.getBody();
//            System.out.println(new String(body));
            // 监听消息，一旦有消息推送过来，就调用处理的回调函数
//            channel.basicConsume("queue.test1", (consumerTag, message) -> {
//                System.out.println(new String(message.getBody()));
//            }, (consumerTag) -> {});
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
