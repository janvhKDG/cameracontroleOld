package be.kdg.demo.XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CameraMessageDTO {

    private int id;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDateTime timestamp;
    private String licensePlate;

    public CameraMessageDTO(int id, LocalDateTime timestamp, String licensePlate) {
        this.id = id;
        this.timestamp = timestamp;
        this.licensePlate = licensePlate;
    }

    public CameraMessageDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

}
