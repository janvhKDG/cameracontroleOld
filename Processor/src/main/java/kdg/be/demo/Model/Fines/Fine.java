package kdg.be.demo.Model.Fines;

import java.time.LocalDateTime;

public class Fine {
    private String licensePlate;
    private long fine;
    private LocalDateTime timestamp;

    public Fine(String licensePlate, long fine, LocalDateTime timestamp) {
        this.licensePlate = licensePlate;
        this.fine = fine;
        this.timestamp = timestamp;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public long getFine() {
        return fine;
    }

    public void setFine(long fine) {
        this.fine = fine;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "licensePlate='" + licensePlate + '\'' +
                ", fine=" + fine +
                ", timestamp=" + timestamp +
                '}';
    }
}
