package kdg.be.demo.FineCalculators;

import kdg.be.demo.Adapters.CameraServiceAdapter;
import kdg.be.demo.Adapters.LicensePlateServiceAdapter;
import kdg.be.demo.Model.Camera;
import kdg.be.demo.Model.CameraMessage;
import kdg.be.demo.Model.Fines.EmissionFine;
import kdg.be.demo.Model.Fines.Fine;
import kdg.be.demo.Model.LicensePlate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmissionFineCalculator implements FineCalculator {
    private Logger logger;
    private List<EmissionFine> emissionFines;

    @Autowired
    CameraServiceAdapter cameraServiceAdapter;
    @Autowired
    LicensePlateServiceAdapter licensePlateServiceAdapter;

    public EmissionFineCalculator() {
        this.emissionFines = new ArrayList<>();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public Optional<Fine> Calculate(CameraMessage cameraMessage) {
        Optional<Camera> cameraOptional = cameraServiceAdapter.toCamera(cameraMessage.getId());
        Optional<LicensePlate> licensePlateOptional = licensePlateServiceAdapter.toLicensePlate(cameraMessage.getLicensePlate());
        if (cameraOptional.isPresent() && licensePlateOptional.isPresent()){
            Camera camera = cameraOptional.get();
            LicensePlate licensePlate = licensePlateOptional.get();

            if(camera.getEuroNorm() > licensePlate.getEuroNumber()){
                EmissionFine emissionFine = new EmissionFine(cameraMessage.getLicensePlate(),150, LocalDateTime.now());
                Boolean alreadyFined = false;
                for(EmissionFine ef : emissionFines){
                    if (ef.getTimestamp().getDayOfYear() == LocalDateTime.now().getDayOfYear()) {
                        alreadyFined = true;
                    }
                }
                if (!alreadyFined)
                {
                    emissionFines.add(emissionFine);
                    logger.warn(emissionFine.toString());
                    System.out.println(emissionFine.toString());
                    return Optional.of(emissionFine);
                }
                return Optional.empty();
            }
        }
        logger.error("Licenseplate or Camera not found.");
        return Optional.empty();
    }
}
