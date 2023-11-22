package polybiking.map;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.*;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.util.List;
import java.util.*;

public class MapView {
    private static final Color CYCLE_PATH_COLOR = Color.BLUE;
    private static final Color FOOT_PATH_COLOR = Color.GRAY;
    private final JXMapViewer mapViewer;
    private final JFrame frame;
    private final GeoPosition origin;
    private final GeoPosition destination;

    public MapView(GeoPosition origin, GeoPosition destination) {
        this.origin = origin;
        this.destination = destination;
        this.frame = new JFrame("PolyBiking");
        this.mapViewer = new JXMapViewer();
        this.setupMap();
        this.computeRoute();
    }

    /**
     * Setup the map with the tile factory
     */
    private void setupMap() {
        this.frame.getContentPane().add(this.mapViewer);
        this.frame.setSize(800, 600);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        this.mapViewer.setTileFactory(tileFactory);

        // Add interactions
        MouseInputListener mia = new PanMouseInputListener(this.mapViewer);
        this.mapViewer.addMouseListener(mia);
        this.mapViewer.addMouseMotionListener(mia);
        this.mapViewer.addMouseListener(new CenterMapListener(this.mapViewer));
        this.mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(this.mapViewer));
        this.mapViewer.addKeyListener(new PanKeyListener(this.mapViewer));
    }

    /**
     * Compute the route between the origin and the destination
     * Make a call to the SOAP Server
     */
    private void computeRoute() {
        GeoPosition frankfurt = new GeoPosition(50, 7, 0, 8, 41, 0);
        GeoPosition wiesbaden = new GeoPosition(50, 5, 0, 8, 14, 0);
        GeoPosition mainz = new GeoPosition(50, 0, 0, 8, 16, 0);
        GeoPosition darmstadt = new GeoPosition(49, 52, 0, 8, 39, 0);
        GeoPosition offenbach = new GeoPosition(50, 6, 0, 8, 46, 0);

        // Create a track from the geo-positions
        List<GeoPosition> track = Arrays.asList(frankfurt, wiesbaden);
        RoutePainter routePainter = new RoutePainter(track, FOOT_PATH_COLOR);

        List<GeoPosition> track2 = Arrays.asList(wiesbaden, mainz);
        RoutePainter routePainter2 = new RoutePainter(track2, CYCLE_PATH_COLOR);

        List<GeoPosition> track3 = Arrays.asList(mainz, darmstadt);
        RoutePainter routePainter3 = new RoutePainter(track3, CYCLE_PATH_COLOR);

        List<GeoPosition> track4 = Arrays.asList(darmstadt, offenbach);
        RoutePainter routePainter4 = new RoutePainter(track4, FOOT_PATH_COLOR);

        // Set the focus
        this.mapViewer.zoomToBestFit(new HashSet<>(track), 0.7);

        // Create waypoints from the geo-positions
        Set<MyWaypoint> waypoints = new HashSet<>(Arrays.asList(
                new MyWaypoint("Origin", Color.BLACK, frankfurt, "origin.png"),
                new MyWaypoint("Station", Color.BLACK, wiesbaden, "station.png"),
                new MyWaypoint("Station", Color.BLACK, darmstadt, "station.png"),
                new MyWaypoint("Destination", Color.BLACK, offenbach, "destination.png")));

        // Create a waypoint painter that takes all the waypoints
        WaypointPainter<MyWaypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);
        waypointPainter.setRenderer(new FancyWaypointRenderer());

        // Create a compound painter that uses both the route-painter and the waypoint-painter
        List<Painter<JXMapViewer>> painters = new ArrayList<>();
        painters.add(routePainter);
        painters.add(routePainter2);
        painters.add(routePainter3);
        painters.add(routePainter4);
        painters.add(waypointPainter);

        CompoundPainter<JXMapViewer> painter = new CompoundPainter<>(painters);
        this.mapViewer.setOverlayPainter(painter);
    }

    /**
     * Calculate the trip time between the origin and the destination
     *
     * @return the trip time in a string format
     */
    public String calculateTripTime() {
        return "1h 30min";
    }
}
