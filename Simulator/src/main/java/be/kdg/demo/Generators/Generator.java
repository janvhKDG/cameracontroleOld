package be.kdg.demo.Generators;

import be.kdg.demo.Model.CameraMessage;
import be.kdg.demo.Observers.Observer;

public interface Generator {
void generate();
void AddListener(Observer o);
}
