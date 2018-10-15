package kdg.be.demo.Receivers;

import com.rabbitmq.client.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class MessageReceiverCloudAMQP implements MessageReceiver {
    private String uri = "amqp://gpogwykr:0pO_XbFqLBVbiJWJ4dlZAmEFNseereBP@flamingo.rmq.cloudamqp.com/gpogwykr";
    private String QName = "JuanQueue";
    private Connection connection;
    private Channel channel;
    private Consumer consumer;



    public void initialize() {

        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUri(uri);
            factory.setRequestedHeartbeat(50);
            factory.setConnectionTimeout(3000);
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QName,false,false,false,null);

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                }
            };
            channel.basicConsume(QName, true, consumer);
        }

        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
