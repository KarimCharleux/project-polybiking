package polybiking;

import com.soap.ws.client.generated.*;
import polybiking.map.MapView;

import java.util.Scanner;

import static polybiking.map.Utils.convertMetersToKilometers;
import static polybiking.map.Utils.convertSecondsToHours;

/**
 * Main class of the PolyBiking application
 */
public class PolyBikingApplication {
    private final IPolyBikingService polyBikingService;
    private final Scanner scanner;

    public PolyBikingApplication() {
        this.scanner = new Scanner(System.in);
        PolyBikingService bikingService = new PolyBikingService();
        this.polyBikingService = bikingService.getBasicHttpBindingIPolyBikingService();

        System.out.println("▷ Welcome to PolyBiking Application !👋 ◁");
        System.out.println("\t◽ Good exemple of trip :");
        System.out.println("\t\t🚩 Paris → Toulouse ");
        System.out.println("\t\t🚩 85 Avenue Georges Clemenceau, 69230 Saint-Genis-Laval → 61 Avenue Roger Salengro, 69100 Villeurbanne");
        System.out.println("\t\t🚩 Lyon → Mulhouse");
    }

    /**
     * Run the application and display the map
     */
    public void run() {
        String origin = askForEnter("origin");
        String destination = askForEnter("destination");

        System.out.println("\n⏳ Computing trip ...\n");

        // Start the timer
        long startTime = System.currentTimeMillis();

        // Make the request to the server and get the response
        BikingResponse response;
        try {
            response = polyBikingService.computeTrip(origin, destination);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            return;
        }

        // Stop the timer
        long stopTime = System.currentTimeMillis();

        // Display the map with the paths
        MapView map = new MapView(response.getPaths().getValue());
        map.display();

        if (response.getPaths().getValue().getPath() == null || response.getPaths().getValue().getPath().isEmpty()) {
            System.out.println("\n❌ No path found between " + origin + " and " + destination + " !");
            return;
        }

        for (Path path : response.getPaths().getValue().getPath()) {
            if (path.getType() == PathType.BIKE_PATH)
                System.out.println("\n🚩🚴 Bike path details:");
            else
                System.out.println("\n🚩🚶 Foot path details:");
            for (Step step : path.getSteps().getValue().getStep()) {
                System.out.println("\t► At " + convertMetersToKilometers(step.getDistance()) + ": " + step.getInstruction().getValue());
            }
        }

        // Display the total time of the trip
        System.out.println("\n⏱️ Trip found in " + (stopTime - startTime) + "ms !");
        System.out.println("✅ Trip from " + origin + " to " + destination + " for " + convertMetersToKilometers(response.getTotalDistance()) + " in " + convertSecondsToHours(response.getTotalDuration()) + " !");

        // Display the details of the trip
        System.out.println("\n📃 Details of the trip:");
        for (Path path : response.getPaths().getValue().getPath()) {
            if (path.getType() == PathType.BIKE_PATH) {
                System.out.println("\t► 🅿️ Get a bike at " + path.getDepartingStation().getValue().getName().getValue() + ", " + path.getDepartingStation().getValue().getContractName().getValue() + " (" + path.getDepartingStation().getValue().getAvailableBikes() + " available bikes)");
                System.out.println("\t► 🚴 Bike path for " + convertMetersToKilometers(path.getDistance()) + " in " + convertSecondsToHours(path.getDuration()));
                System.out.println("\t► 🅿️ Leave the bike at " + path.getArrivalStation().getValue().getName().getValue() + ", " + path.getArrivalStation().getValue().getContractName().getValue() + " (" + path.getArrivalStation().getValue().getBikeStands() + " available bikes stands)");
            } else {
                System.out.println("\t► 🚶 Foot path for " + convertMetersToKilometers(path.getDistance()) + " in " + convertSecondsToHours(path.getDuration()));
            }
        }
    }

    /**
     * Ask for a city name and check if it exists in the list
     *
     * @param useFor "origin" or "destination"
     * @return the city name existing in the list
     */
    private String askForEnter(String useFor) {
        System.out.println("\n● Enter " + useFor + ": ");
        String result = "";
        while (result.isEmpty()) {
            result = this.scanner.nextLine();
            if (result.isEmpty()) {
                System.out.println("❌ Please enter a " + useFor + "!");
            }
        }
        return result;
    }

}
