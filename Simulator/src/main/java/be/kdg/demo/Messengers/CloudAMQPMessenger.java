package be.kdg.demo.Messengers;

import be.kdg.demo.Messengers.Exceptions.MessengerException;
import be.kdg.demo.Messengers.MessageQueue.MessageQueue;
import be.kdg.demo.Model.CameraMessage;
import be.kdg.demo.XML.CameraMessageDTO;
import be.kdg.demo.XML.XMLParser;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "messenger.type", havingValue = "cloudAMQP")
public class CloudAMQPMessenger implements Messenger {

    private MessageQueue messageQueue;
    private XMLParser xmlParser;

    public CloudAMQPMessenger(MessageQueue messageQueue, XMLParser xmlParser) {
        this.messageQueue = messageQueue;
        this.xmlParser = xmlParser;

        messageQueue.initialize();
    }

    @Override
    public void SendMessage(CameraMessage cameraMessage) {
        if(cameraMessage != null)
        messageQueue.sendMessage(xmlParser.ParseCameraMessage(new CameraMessageDTO(cameraMessage.getId(),cameraMessage.getTimestamp(),cameraMessage.getLicensePlate())));
        if(cameraMessage == null)
            throw new MessengerException("Could not send empty CameraMessage object");
    }
}
