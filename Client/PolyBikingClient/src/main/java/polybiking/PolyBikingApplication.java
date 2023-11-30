package polybiking;

import com.soap.ws.client.generated.*;
import polybiking.map.MapView;

import java.util.Scanner;

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

        System.out.println("▷ PolyBiking Application ◁");
    }

    /**
     * Run the application and display the map
     */
    public void run() {
        String origin = askForEnter("origin");
        String destination = askForEnter("destination");

        System.out.println("\n⏳ Computing trip ...\n");

        // Make the request to the server and get the response
        BikingResponse response;
        try {
            response = polyBikingService.computeTrip(origin, destination);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            return;
        }

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

        System.out.println("\n✅ Trip from " + origin + " to " + destination + " for " + convertMetersToKilometers(response.getTotalDistance()) + " in " + convertSecondsToHours(response.getTotalDuration()) + " !");

        // Display the details of the trip
        System.out.println("\n📃 Details of the trip:");
        for (Path path : response.getPaths().getValue().getPath()) {
            if (path.getType() == PathType.BIKE_PATH)
                System.out.println("\t► 🚴 Bike path for " + convertMetersToKilometers(path.getDistance()) + " in " + convertSecondsToHours(path.getDuration()));
            else
                System.out.println("\t► 🚶 Foot path for " + convertMetersToKilometers(path.getDistance()) + " in " + convertSecondsToHours(path.getDuration()));
        }
    }

    private String convertSecondsToHours(Double seconds) {
        double hours = seconds / 3600;
        double minutes = (seconds % 3600) / 60;
        return String.format("%.0f", hours) + "h" + String.format("%.0f", minutes) + "min";
    }

    private String convertMetersToKilometers(Double meters) {
        return String.format("%.2f", meters / 1000) + "km";
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
