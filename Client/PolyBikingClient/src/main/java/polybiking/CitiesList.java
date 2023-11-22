package polybiking;

import org.jxmapviewer.viewer.GeoPosition;

import java.util.HashMap;

/**
 * List of cities with their coordinates
 */
public class CitiesList extends HashMap<String, GeoPosition> {
    private static CitiesList instance;

    public static CitiesList getInstance() {
        if (instance == null) {
            instance = new CitiesList();
        }
        return instance;
    }

    public CitiesList() {
        super();
        this.put("Frankfurt", new GeoPosition(50, 7, 0, 8, 41, 0));
        this.put("Wiesbaden", new GeoPosition(50, 5, 0, 8, 14, 0));
        this.put("Mainz", new GeoPosition(50, 0, 0, 8, 16, 0));
        this.put("Darmstadt", new GeoPosition(49, 52, 0, 8, 39, 0));
        this.put("Offenbach", new GeoPosition(50, 6, 0, 8, 46, 0));
    }
}
