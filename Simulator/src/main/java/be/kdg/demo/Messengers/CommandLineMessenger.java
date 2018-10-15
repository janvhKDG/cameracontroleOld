package be.kdg.demo.Messengers;

import be.kdg.demo.Messengers.Exceptions.MessengerException;
import be.kdg.demo.Model.CameraMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "messenger.type", havingValue = "commandLine")
public class CommandLineMessenger implements Messenger {
    @Override
    public void SendMessage(CameraMessage cameraMessage) {
        if(cameraMessage == null){
            throw new MessengerException("Cannot print empty CameraMessage object.");
        }
        System.out.println(cameraMessage.toString());
    }
}
