package com.look.common.util;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQProducerUtil {
    /**
     * rabbitmq相关端口
     * 5672: 	RabbitMQ的通讯端口
     * 25672:	RabbitMQ的节点间的CLI通讯端口是
     * 15672:	RabbitMQ HTTP_API的端口，管理员用户才能访问，用于管理RabbitMQ,需要启动Management插件。
     * 1883，8883：	MQTT插件启动时的端口。
     * 61613、61614：	STOMP客户端插件启用的时候的端口。
     * 15674、15675：	基于webscoket的STOMP端口和MOTT端口
     */
    public static void main(String[] args) {
        // 获取连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置主机名 hostname
        factory.setHost("42.192.11.203");
        factory.setVirtualHost("/");
        // 用户名
        factory.setUsername("root");
        // 密码
        factory.setPassword("991112.l");
        // amqp的端口号
        factory.setPort(5672);
        try(
            // 建立TCP连接
            Connection connection = factory.newConnection();
            // 获取通道
            Channel channel = connection.createChannel();
        ) {
            // 声明交换器
            // 交换器的名称,交换器的类型,是否是持久化,是否是自动删除,属性map集合
            channel.exchangeDeclare("ex.demo", BuiltinExchangeType.DIRECT, false, false, null);
            // 声明消息队列
            // 消息队列名称,是否是持久化,是否是排他的,是否是自动删除,属性map集合
            channel.queueDeclare("queue.test1", false, false, true, null);
            // 将交换器和消息队列绑定
            channel.queueBind("queue.test1", "ex.demo", "hello.demo");
            for (int i = 0; i < 10; i++) {
                // 发送消息
                // 交换器的名字,消息的路由键,消息的属性,消息的字节数组
                channel.basicPublish("ex.demo", "hello.demo", null, ("3213 " + i).getBytes());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
