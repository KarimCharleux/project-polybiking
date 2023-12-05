package polybiking.activemq;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StationInfo {
    private int number;
    @JsonProperty("contract_name")
    private String contractName;
    private String name;
    private String address;
    private Coordinate position;
    private boolean banking;
    private boolean bonus;
    @JsonProperty("bike_stands")
    private int bikeStands;
    @JsonProperty("available_bike_stands")
    private int availableBikeStands;
    @JsonProperty("available_bikes")
    private int availableBikes;
    private String status;
    @JsonProperty("last_update")
    private long lastUpdate;

    public StationInfo() {
        // Empty constructor for Jackson
    }

    public int getNumber() {
        return number;
    }

    public String getContractName() {
        return contractName;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Coordinate getPosition() {
        return position;
    }

    public boolean isBanking() {
        return banking;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getBikeStands() {
        return bikeStands;
    }

    public int getAvailableBikeStands() {
        return availableBikeStands;
    }

    public int getAvailableBikes() {
        return availableBikes;
    }

    public String getStatus() {
        return status;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

}
