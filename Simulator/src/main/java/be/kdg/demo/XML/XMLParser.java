package be.kdg.demo.XML;

import be.kdg.demo.Model.CameraMessage;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Component
public class XMLParser {

    public String ParseCameraMessage(CameraMessageDTO cameraMessageDTO) {

        try {
            JAXBContext context = JAXBContext.newInstance(CameraMessageDTO.class);
            Marshaller  marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            StringWriter sw = new StringWriter();
            marshaller.marshal(cameraMessageDTO,sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
