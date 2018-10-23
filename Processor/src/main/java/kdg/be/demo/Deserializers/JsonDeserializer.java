package kdg.be.demo.Deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kdg.be.demo.Model.Camera;
import kdg.be.demo.Model.LicensePlate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonDeserializer {
    private ObjectMapper mapper = new ObjectMapper();

    public Camera toCamera(String json) throws IOException {
        return mapper.readValue(json, Camera.class);
    }

    public LicensePlate toLicensePlate(String json) throws IOException {
        return mapper.readValue(json, LicensePlate.class);
    }
}
