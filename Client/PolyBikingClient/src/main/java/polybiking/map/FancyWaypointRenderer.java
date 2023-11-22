package polybiking.map;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.WaypointRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A fancy waypoint painter
 *
 * @author Martin Steiger
 */
public class FancyWaypointRenderer implements WaypointRenderer<MyWaypoint> {

    private final Map<Color, BufferedImage> map = new HashMap<>();

    /**
     * Uses a default waypoint image
     */
    public FancyWaypointRenderer() {

    }

    private BufferedImage convert(BufferedImage loadImg, Color newColor) {
        int w = loadImg.getWidth();
        int h = loadImg.getHeight();
        BufferedImage imgOut = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        BufferedImage imgColor = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = imgColor.createGraphics();
        g.setColor(newColor);
        g.fillRect(0, 0, w + 1, h + 1);
        g.dispose();

        Graphics2D graphics = imgOut.createGraphics();
        graphics.drawImage(loadImg, 0, 0, null);
        graphics.setComposite(MultiplyComposite.Default);
        graphics.drawImage(imgColor, 0, 0, null);
        graphics.dispose();

        return imgOut;
    }

    @Override
    public void paintWaypoint(Graphics2D graphics2D, JXMapViewer viewer, MyWaypoint myWaypoint) {
        graphics2D = (Graphics2D) graphics2D.create();

        BufferedImage logo = null;
        URL url = getClass().getClassLoader().getResource(myWaypoint.getLogo());
        try {
            logo = ImageIO.read(Objects.requireNonNull(url));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        Point2D point = viewer.getTileFactory().geoToPixel(myWaypoint.getPosition(), viewer.getZoom());

        int x = (int) point.getX();
        int y = (int) point.getY();

        graphics2D.drawImage(logo, x - logo.getWidth() / 2, y - logo.getHeight(), null);

        String label = myWaypoint.getLabel();


        //Change color for the label
        graphics2D.setColor(myWaypoint.getColor());

        // Change font for the label
        graphics2D.setFont(new Font("Arial", Font.BOLD, 12));

        FontMetrics metrics = graphics2D.getFontMetrics();
        int tw = metrics.stringWidth(label);
        int th = 1 + metrics.getAscent();

        graphics2D.drawString(label, x - tw / 2, y + th - logo.getHeight() + 20);

        graphics2D.dispose();
    }
}
