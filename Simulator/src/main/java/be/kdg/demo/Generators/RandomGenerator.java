package be.kdg.demo.Generators;

import be.kdg.demo.Model.CameraMessage;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;
@Component
@ConditionalOnProperty(name = "generator.type", havingValue = "random")
public class RandomGenerator implements Generator {
    @Value("${generator.randomGenerator.maxCameraCount}")
    private int maxCameraCount;
    @Override
    public CameraMessage generate() {
        Random random = new Random();
        int id =random.nextInt(maxCameraCount);
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('A', 'Z').build();
        String plate = "1-";
        plate += randomStringGenerator.generate(3) + '-' + random.nextInt(9) + random.nextInt(9)+ random.nextInt(9);
        return new CameraMessage(id, LocalDateTime.now(),plate);
    }
}
