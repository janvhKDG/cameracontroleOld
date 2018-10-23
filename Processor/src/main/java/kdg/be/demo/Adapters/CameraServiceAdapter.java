package kdg.be.demo.Adapters;


import be.kdg.sa.services.CameraNotFoundException;
import be.kdg.sa.services.CameraServiceProxy;
import kdg.be.demo.Deserializers.JsonDeserializer;
import kdg.be.demo.Model.Camera;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class CameraServiceAdapter {
    private JsonDeserializer jsonDeserializer;
    private CameraServiceProxy cameraServiceProxy;
    private Logger logger;
    public CameraServiceAdapter(JsonDeserializer jsonDeserializer, CameraServiceProxy cameraServiceProxy) {
        this.jsonDeserializer = jsonDeserializer;
        this.cameraServiceProxy = cameraServiceProxy;
        logger = LoggerFactory.getLogger(this.getClass());
    }
    public Optional<Camera> toCamera(int cameraId) {
        try {
            String cameraInfo = cameraServiceProxy.get(cameraId);
            return Optional.of(jsonDeserializer.toCamera(cameraInfo));
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (CameraNotFoundException e) {
            logger.error("Camera not found: " + cameraId);
        }
        return Optional.empty();
    }
}
