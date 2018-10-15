package kdg.be.demo.Services;

import kdg.be.demo.Receivers.MessageReceiver;
import org.springframework.stereotype.Service;

@Service
public class ProcessorServiceDemo implements ProcessorService {
    MessageReceiver receiver;

    public ProcessorServiceDemo(MessageReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void start() {
        receiver.initialize();
    }
}
