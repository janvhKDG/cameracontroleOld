package be.kdg.demo.Generators;

import be.kdg.demo.Generators.Exceptions.FileGeneratorException;
import be.kdg.demo.Model.CameraMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

@Component
@ConditionalOnProperty(name = "generator.type", havingValue = "file")
public class FileGenerator implements Generator {
    private ArrayList<CameraMessage> cameraMessages = new ArrayList<>();
    int iterator = 0;
    public FileGenerator()
    {
        try {
            cameraMessages = ReadFile("C:\\Users\\jvanh\\Desktop\\example.csv");
        } catch (IOException e) {
            throw new FileGeneratorException("Could not load CSV",e);
        }

    }
    @Override
    public CameraMessage generate() {
        if (cameraMessages.size()>iterator)
        return cameraMessages.get(iterator++);
        else return null;

    }

    public ArrayList<CameraMessage> ReadFile(String filePath) throws IOException {
        LocalDateTime ldt = LocalDateTime.now();
        ArrayList <CameraMessage> result = new ArrayList <CameraMessage> ();
        Scanner scan = new Scanner(new File(filePath));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if(!line.equals("")) {
                String[] lineArray = line.split(",");
                CameraMessage cm = new CameraMessage();
                cm.setId(Integer.parseInt(lineArray[0]));
                cm.setLicensePlate(lineArray[1]);
                ldt.plusNanos(Integer.parseInt(lineArray[2]) * 1000000);
                cm.setTimestamp(ldt);
                result.add(cm);
            }
        }
        return result;
    }
}
