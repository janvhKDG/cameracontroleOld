package kdg.be.demo.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class Location {

    private Long id;

    @JsonProperty("lat")
    private double latitude;
    @JsonProperty("long")
    private double longitude;

    public Location() {
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "lat: " + latitude +", long: " + longitude;
    }
}