package kdg.be.demo.Model;

import java.time.LocalDateTime;

public class CameraMessage {
    private int id;
    private LocalDateTime timestamp;
    private String licensePlate;

    public CameraMessage() {
    }
    public CameraMessage(int id, LocalDateTime timestamp, String licensePlate) {
        this.id = id;
        this.timestamp = timestamp;
        this.licensePlate = licensePlate;
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

    @Override
    public String toString() {
        return "CameraMessage{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
