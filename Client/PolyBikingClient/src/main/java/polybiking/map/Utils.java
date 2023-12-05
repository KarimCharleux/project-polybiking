package polybiking.map;

public class Utils {

    private Utils() {
        // Empty constructor, because this class only contains static methods
    }

    public static String convertMetersToKilometers(Double meters) {
        return String.format("%.2f", meters / 1000) + "km";
    }

    public static String convertSecondsToHours(Double seconds) {
        double hours = seconds / 3600;
        double minutes = (seconds % 3600) / 60;
        return String.format("%.0f", hours) + "h" + String.format("%.0f", minutes) + "min";
    }
}
