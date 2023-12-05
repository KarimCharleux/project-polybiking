package polybiking.activemq;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Step {
    private String instruction;
    private double distance;
    private double duration;
    private int type;
    private String name;

    @JsonProperty("way_points")
    private List<Integer> wayPoints;

    public Step() {
        // Empty constructor for Jackson
    }

    public String getInstruction() {
        return instruction;
    }

    public double getDistance() {
        return distance;
    }

    public double getDuration() {
        return duration;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getWayPoints() {
        return this.wayPoints;
    }
}
