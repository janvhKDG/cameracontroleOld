package kdg.be.demo.FineCalculators;

import kdg.be.demo.Adapters.CameraServiceAdapter;
import kdg.be.demo.Deserializers.DTO.CameraMessageDTO;
import kdg.be.demo.Model.Camera;
import kdg.be.demo.Model.CameraMessage;
import kdg.be.demo.Model.Fines.Fine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpeedFineCalculator implements FineCalculator {



    @Autowired
    CameraServiceAdapter cameraServiceAdapter;
    @Override
    public Optional<Fine> Calculate(CameraMessage cameraMessage) {
        Optional<Camera> cameraOptional = cameraServiceAdapter.toCamera(cameraMessage.getId());
        if (cameraOptional.isPresent()){
            Camera camera = cameraOptional.get();

        }
            //TODO: Log / Error
            return Optional.empty();

    }
}
