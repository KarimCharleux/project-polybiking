package polybiking.map;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.GeoPosition;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Paints a route on the map.
 */
public class RoutePainter implements Painter<JXMapViewer> {
    private final Color color;

    private final List<GeoPosition> track;

    /**
     * @param track the track
     */
    public RoutePainter(List<GeoPosition> track, Color color) {
        this.track = new ArrayList<>(track);
        this.color = color;
    }

    @Override
    public void paint(Graphics2D graphics2D, JXMapViewer map, int w, int h) {
        graphics2D = (Graphics2D) graphics2D.create();

        Rectangle rectangle = map.getViewportBounds();
        graphics2D.translate(-rectangle.x, -rectangle.y);

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(4));

        drawRoute(graphics2D, map);

        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(2));

        drawRoute(graphics2D, map);

        graphics2D.dispose();
    }

    /**
     * Draw the route as a line between the points on the map
     *
     * @param graphics2D the graphics object for drawing lines
     * @param map the map to draw on
     */
    private void drawRoute(Graphics2D graphics2D, JXMapViewer map) {
        int lastX = 0;
        int lastY = 0;

        boolean first = true;

        for (GeoPosition position : track) {
            // Convert geo-coordinate to world bitmap pixel
            Point2D point2D = map.getTileFactory().geoToPixel(position, map.getZoom());

            if (first) {
                first = false;
            } else {
                graphics2D.drawLine(lastX, lastY, (int) point2D.getX(), (int) point2D.getY());
            }

            lastX = (int) point2D.getX();
            lastY = (int) point2D.getY();
        }
    }
}