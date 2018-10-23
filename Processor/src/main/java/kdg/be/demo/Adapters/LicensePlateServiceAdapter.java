package kdg.be.demo.Adapters;

import be.kdg.sa.services.InvalidLicensePlateException;
import be.kdg.sa.services.LicensePlateNotFoundException;
import be.kdg.sa.services.LicensePlateServiceProxy;
import kdg.be.demo.Deserializers.JsonDeserializer;
import kdg.be.demo.Model.LicensePlate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class LicensePlateServiceAdapter {
    private Logger logger;

    private LicensePlateServiceProxy licensePlateServiceProxy;
    private JsonDeserializer jsonDeserializer;

    public LicensePlateServiceAdapter(LicensePlateServiceProxy licensePlateServiceProxy, JsonDeserializer jsonDeserializer) {
        this.licensePlateServiceProxy = licensePlateServiceProxy;
        this.jsonDeserializer = jsonDeserializer;
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public Optional<LicensePlate> toLicensePlate(String plateId) {
        try {
            String licensePlateInfo = licensePlateServiceProxy.get(plateId);
            return Optional.of(jsonDeserializer.toLicensePlate(licensePlateInfo));
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (LicensePlateNotFoundException e) {
            logger.error("License plate not found: " + plateId);
        } catch (InvalidLicensePlateException e) {
            logger.error("Invalid license plate: " + plateId);
        }
        return Optional.empty();
    }
}