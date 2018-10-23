package kdg.be.demo.Observers;


import kdg.be.demo.Model.CameraMessage;

public abstract class Observer {
    public abstract void update(CameraMessage cameraMessage);
}
