package kdg.be.demo.Model.Fines;

import java.time.LocalDateTime;

public class EmissionFine extends Fine {
    public EmissionFine(String licensePlate, long fine, LocalDateTime timestamp) {
        super(licensePlate, fine, timestamp);
    }


}
