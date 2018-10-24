package kdg.be.demo.Deserializers;

import kdg.be.demo.Deserializers.DTO.CameraMessageDTO;
import kdg.be.demo.Deserializers.Exceptions.DeserializeException;
import kdg.be.demo.Model.CameraMessage;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.Reader;
import java.io.StringReader;

@Component
public class XmlDeserializer {
    public CameraMessage ParseCameraMessage(String cameraMessageXML) {

        try {
            JAXBContext context = JAXBContext.newInstance(CameraMessageDTO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Reader reader = new StringReader(cameraMessageXML);
            XMLInputFactory factory = XMLInputFactory.newInstance(); // Or newFactory()
            XMLStreamReader xmlReader = factory.createXMLStreamReader(reader);

            CameraMessageDTO cameraMessageDTO = (CameraMessageDTO) unmarshaller.unmarshal(xmlReader);
            return new CameraMessage(cameraMessageDTO.getId(),cameraMessageDTO.getTimestamp(),cameraMessageDTO.getLicensePlate());
        } catch (JAXBException e) {
            throw new DeserializeException("Error parsing Camera Message (xml to object)",e);
        } catch (XMLStreamException e) {
            throw new DeserializeException("Error parsing Camera Message (xml to object)",e);
        }
    }
}
