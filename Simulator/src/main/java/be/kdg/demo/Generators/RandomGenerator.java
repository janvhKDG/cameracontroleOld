package be.kdg.demo.Generators;

import be.kdg.demo.Generators.Exceptions.RandomGeneratorException;
import be.kdg.demo.Model.CameraMessage;
import be.kdg.demo.Observers.Observer;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@ConditionalOnProperty(name = "generator.type", havingValue = "random")
public class RandomGenerator implements Generator {
    @Value(value = "${generator.randomGenerator.maxCameraCount}")
    private int maxCameraCount;
    @Value(value = "${generator.randomGenerator.freqString}")
    private String freqString;
    private List<Integer> freqs = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public RandomGenerator() {

    }
    public void AddListener(Observer o){
        observers.add(o);
    }

    @Override
    public void generate(){
        try {
            for (String s : freqString.split(",")) {
                freqs.add(Integer.parseInt(s));
            }
        } catch (Exception ex) {
            throw new RandomGeneratorException("Generating frequentionlist failed", ex);
        }

        for (Integer i : freqs
        ) {
            for (int x = 0; x < i; x++) {
                Random random = new Random();
                int id = random.nextInt(maxCameraCount);
                RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('A', 'Z').build();
                String plate = "1-";
                plate += randomStringGenerator.generate(3) + '-' + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
                for(Observer o : observers){o.update(new CameraMessage(id, LocalDateTime.now(), plate));}




            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
