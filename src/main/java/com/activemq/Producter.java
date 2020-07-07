package com.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * @author gzd
 * @create 2018-05-15 22:20
 * @desc 消费者
 **/
public class Producter {

    public static void main(String[] args) throws Exception{
        // 第一步：建立ConnectionFactory 工厂对象，需要填入用户名 密码，以及连接地址 默认地址为：tcp://localhost:61616
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://localhost:61616");

        // 第二步 通过ConnectionFactory工厂对象 创建一个Connection 连接，并且调用Connection的start方法，开启连接， 默认是关闭的
        Connection connection  =connectionFactory.createConnection();
        connection.start();

        //第三步：通过connection连接创建session会话，用户接收消息，参数配置1 为是否开启事务，参数配置2 为 签收模式，一般我们自动签收
        Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);

        // 第四步：通过session会话 创建destination 对象，指的是一个客户端用来生产消息目标和消费消息来源的对象，
        // 在destination被称作为queue
        Destination destination = session.createQueue("first");

        // 第五步：需要Session对象创建消息的发送和接收对象（生产者和消费者）
        MessageProducer messageProducer = session.createProducer(null);
        // 第六步：可以使用设置持久化特性
        // 第七步：最后使用TextMessage形式创建数据，并用send方法发送，同理客户端使用receive进行接收
        for (int i = 0;i<20;i++){
            TextMessage textMessage = session.createTextMessage("我是生产者==="+i);
            messageProducer.send(destination,textMessage);
            TimeUnit.SECONDS.sleep(1);
        }

        if(connection != null){
            connection.close();
        }
    }



}
