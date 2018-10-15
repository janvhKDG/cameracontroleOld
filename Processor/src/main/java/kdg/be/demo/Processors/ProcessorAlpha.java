package kdg.be.demo.Processors;

import be.kdg.sa.services.CameraServiceProxy;

public class ProcessorAlpha implements Processor {
    private CameraServiceProxy cameraServiceProxy;

    public ProcessorAlpha() {
        this.cameraServiceProxy = new CameraServiceProxy();
        //cameraServiceProxy.get()
    }
}
