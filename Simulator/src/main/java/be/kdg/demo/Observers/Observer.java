package be.kdg.demo.Observers;

import be.kdg.demo.Model.CameraMessage;

public abstract class Observer {
    public abstract void update(CameraMessage cameraMessage);
}

