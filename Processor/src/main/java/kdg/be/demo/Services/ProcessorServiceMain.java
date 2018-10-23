package kdg.be.demo.Services;

import kdg.be.demo.Model.CameraMessage;
import kdg.be.demo.Observers.Observer;
import kdg.be.demo.Receivers.MessageReceiver;
import org.springframework.stereotype.Service;

@Service
public class ProcessorServiceMain extends Observer implements ProcessorService {
    private MessageReceiver receiver;
    private FineService fineService;


    public ProcessorServiceMain(MessageReceiver receiver, FineService fineService) {
        this.receiver = receiver;
        this.fineService = fineService;
    }

    @Override
    public void start() {
        receiver.addListener(this);
        receiver.initialize();
    }

    @Override
    public void update(CameraMessage cameraMessage) {
        fineService.CalcFines(cameraMessage);
    }
}
