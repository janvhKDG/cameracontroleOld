package kdg.be.demo.Receivers;

import com.rabbitmq.client.*;
import kdg.be.demo.Deserializers.XmlDeserializer;
import kdg.be.demo.Deserializers.DTO.CameraMessageDTO;
import kdg.be.demo.Model.CameraMessage;
import kdg.be.demo.Observers.Observer;
import kdg.be.demo.Services.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageReceiverCloudAMQP implements MessageReceiver  {
    private List<Observer> observers = new ArrayList<Observer>();
    private String uri = "amqp://gpogwykr:0pO_XbFqLBVbiJWJ4dlZAmEFNseereBP@flamingo.rmq.cloudamqp.com/gpogwykr";
    private String QName = "JuanQueue";
    private Connection connection;
    private Channel channel;
    private Consumer consumer;
    @Autowired
    private XmlDeserializer xmlDeserializer;





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
                    CameraMessage cameraMessage = xmlDeserializer.ParseCameraMessage(message);
                    for(Observer o : observers)
                    {
                        o.update(cameraMessage);
                    }
                    System.out.println(" [x] Received '" + cameraMessage.toString() + "'");
                }
            };
            channel.basicConsume(QName, true, consumer);
        }

        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void addListener(Observer observer)
    {
        observers.add(observer);
    }


}
