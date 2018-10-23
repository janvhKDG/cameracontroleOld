package kdg.be.demo.Receivers;

import kdg.be.demo.Model.CameraMessage;
import kdg.be.demo.Observers.Observer;

public interface MessageReceiver {
void initialize();
void addListener(Observer observer);
}
