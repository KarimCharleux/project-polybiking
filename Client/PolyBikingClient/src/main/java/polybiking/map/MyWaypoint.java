package polybiking.map;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

import java.awt.*;

/**
 * A waypoint that also has a color and a label
 * @author Martin Steiger
 */
public class MyWaypoint extends DefaultWaypoint
{
    private final String label;
    private final Color color;
    private final String logo;

    /**
     * @param label the text
     * @param color the color
     * @param coord the coordinate
     * @param logo the logo
     */
    public MyWaypoint(String label, Color color, GeoPosition coord, String logo)
    {
        super(coord);
        this.label = label;
        this.color = color;
        this.logo = logo;
    }

    /**
     * @return the label text
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * @return the color
     */
    public Color getColor()
    {
        return color;
    }

    public String getLogo() {
        return logo;
    }
}
