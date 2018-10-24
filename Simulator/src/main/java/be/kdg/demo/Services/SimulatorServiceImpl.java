package be.kdg.demo.Services;

import be.kdg.demo.Generators.Generator;
import be.kdg.demo.Messengers.Exceptions.MessengerException;
import be.kdg.demo.Messengers.Messenger;
import be.kdg.demo.Model.CameraMessage;
import be.kdg.demo.Observers.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimulatorServiceImpl extends Observer implements SimulatorService {
    private Logger logger;
    private Messenger messenger;
    private Generator generator;

    public SimulatorServiceImpl(Messenger messenger, Generator generator) {
        this.messenger = messenger;
        this.generator = generator;
        logger = LoggerFactory.getLogger(this.getClass());
    }


    @Override
    public void start() {
        generator.AddListener(this);
            generator.generate();
    }

    @Override
    public void update(CameraMessage cameraMessage) {
        try {
            messenger.SendMessage(cameraMessage);
        }
        catch (MessengerException ex){
            logger.error("ERROR: ",ex);
        }
    }
}
