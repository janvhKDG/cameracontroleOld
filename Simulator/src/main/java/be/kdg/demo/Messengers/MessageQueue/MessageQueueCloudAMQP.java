package be.kdg.demo.Messengers.MessageQueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import org.springframework.stereotype.Component;

@Component
public class MessageQueueCloudAMQP implements MessageQueue {

    private String uri = "amqp://gpogwykr:0pO_XbFqLBVbiJWJ4dlZAmEFNseereBP@flamingo.rmq.cloudamqp.com/gpogwykr";
    private String QName = "JuanQueue";
    private Connection connection;
    private Channel channel;
    private Consumer consumer;

    @Override
    public void initialize() {
        try{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUri(uri);
        connectionFactory.setRequestedHeartbeat(50);
        connectionFactory.setConnectionTimeout(3000);
        connection = connectionFactory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(QName,false,false,false,null);
        }

       catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }

    @Override
    public void shutdown() {

    }

    @Override
    public void sendMessage(String message) {
        try{
        channel.basicPublish("",QName,null,message.getBytes());
        }
        catch(Exception ex){}
    }
}
