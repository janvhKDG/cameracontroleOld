package kdg.be.demo.Adapters;

import kdg.be.demo.Model.Camera;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CameraServiceTest {
    @Autowired
    private CameraServiceAdapter cameraServiceAdapter;
    @Test
    public void init()
    {
        Optional<Camera> optionalCamera = cameraServiceAdapter.toCamera(3);
        if (optionalCamera.isPresent()){
            Camera camera = optionalCamera.get();
            System.out.println("Camera ID:" + camera.getCameraId());
            System.out.println("Camera Location:" + camera.getLocation().toString());
            System.out.println("Camera Segment:" + camera.getSegment());
            System.out.println("Camera Euronorm:" + camera.getEuroNorm());
        }
        else{
            System.out.println("Camera not found.");
        }
    }
}
