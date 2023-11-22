package polybiking;

import org.jxmapviewer.viewer.GeoPosition;
import polybiking.map.MapView;

import java.util.Map;
import java.util.Scanner;

/**
 * Main class of the PolyBiking application
 */
public class PolyBikingApplication {
    private final CitiesList citiesList;
    private final Scanner scanner;

    public PolyBikingApplication() {
        this.citiesList = CitiesList.getInstance();
        this.scanner = new Scanner(System.in);

        System.out.println("▷ PolyBiking Application ◁\n");
    }

    /**
     * Run the application and display the map
     */
    public void run() {
        System.out.println("► List of cities: ");
        for (Map.Entry<String, GeoPosition> entry : this.citiesList.entrySet()) {
            System.out.println("\t🏡 " + entry.getKey());
        }

        String origin = askForEnter("origin");
        String destination = askForEnter("destination");

        MapView mapView = new MapView(this.citiesList.get(origin), this.citiesList.get(destination));

        System.out.println("\n✅ Trip from " + origin + " to " + destination + " for " + mapView.calculateTripTime() + " !");
    }

    /**
     * Ask for a city name and check if it exists in the list
     *
     * @param useFor "origin" or "destination"
     * @return the city name existing in the list
     */
    private String askForEnter(String useFor) {
        String result = "";
        while (result.isEmpty()) {
            System.out.println("\n● Enter " + useFor + ": ");
            result = scanner.nextLine();
            if (!this.citiesList.containsKey(result)) {
                System.out.println("❌ City not found");
                result = "";
            }
        }
        return result;
    }
}
