package polybiking.activemq;

public class Coordinate {
    private double lat;
    private double lng;

    public Coordinate() {
        // Empty constructor for Jackson
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}