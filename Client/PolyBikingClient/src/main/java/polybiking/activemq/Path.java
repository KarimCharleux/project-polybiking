package polybiking.activemq;

import java.util.List;

public class Path {
    private int type;
    private List<Coordinate> coordinates;
    private double distance;
    private double duration;
    private List<Step> steps;
    private StationInfo departingStation;
    private StationInfo arrivalStation;

    public Path() {
        // Empty constructor for Jackson
    }

    public int getType() {
        return type;
    }

    public StationInfo getDepartingStation() {
        return departingStation;
    }

    public StationInfo getArrivalStation() {
        return arrivalStation;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public double getDistance() {
        return distance;
    }

    public double getDuration() {
        return duration;
    }

    public List<Step> getSteps() {
        return steps;
    }
}