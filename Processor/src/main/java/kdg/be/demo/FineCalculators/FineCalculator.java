package kdg.be.demo.FineCalculators;

import kdg.be.demo.Model.CameraMessage;
import kdg.be.demo.Model.Fines.Fine;

import java.util.Optional;

public interface FineCalculator {
    Optional<Fine> Calculate(CameraMessage cameraMessage);
}
