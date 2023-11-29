package polybiking.map;

import com.soap.ws.client.generated.ArrayOfPath;
import com.soap.ws.client.generated.ArrayOfPosition;
import com.soap.ws.client.generated.Path;
import com.soap.ws.client.generated.Position;
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
    private final ArrayOfPath paths;

    public MapView(ArrayOfPath paths) {
        this.paths = paths;
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

        // Create a track from the geo-positions
        List<GeoPosition> trackFirstFoot = new ArrayList<>();
        List<GeoPosition> trackCycle = new ArrayList<>();
        List<GeoPosition> trackSecondFoot = new ArrayList<>();

        Path pathFirstFoot = this.paths.getPath().get(0);
        for(Position coordinates : pathFirstFoot.getCoordinates().getValue().getPosition()) {
            trackFirstFoot.add(new GeoPosition(coordinates.getLat(), coordinates.getLng()));
        }
        RoutePainter routePainter = new RoutePainter(trackFirstFoot, FOOT_PATH_COLOR);

        Path pathCycle = this.paths.getPath().get(1);
        for(Position coordinates : pathCycle.getCoordinates().getValue().getPosition()) {
            trackCycle.add(new GeoPosition(coordinates.getLat(), coordinates.getLng()));
        }
        RoutePainter routePainter2 = new RoutePainter(trackCycle, CYCLE_PATH_COLOR);

        Path pathSecondFoot = this.paths.getPath().get(2);
        for(Position coordinates : pathSecondFoot.getCoordinates().getValue().getPosition()) {
            trackSecondFoot.add(new GeoPosition(coordinates.getLat(), coordinates.getLng()));
        }
        RoutePainter routePainter3 = new RoutePainter(trackSecondFoot, FOOT_PATH_COLOR);

        // Set the focus
        this.mapViewer.zoomToBestFit(new HashSet<>(trackFirstFoot), 0.7);

        // Create waypoints from the geo-positions
        Set<MyWaypoint> waypoints = new HashSet<>(Arrays.asList(
                new MyWaypoint("Origin", Color.BLACK, trackFirstFoot.get(0), "origin.png"),
                new MyWaypoint("Station", Color.BLACK, trackCycle.get(0), "station.png"),
                new MyWaypoint("Station", Color.BLACK, trackCycle.get(trackCycle.size()-1), "station.png"),
                new MyWaypoint("Destination", Color.BLACK, trackSecondFoot.get(trackSecondFoot.size()-1), "destination.png")));

        // Create a waypoint painter that takes all the waypoints
        WaypointPainter<MyWaypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);
        waypointPainter.setRenderer(new FancyWaypointRenderer());

        // Create a compound painter that uses both the route-painter and the waypoint-painter
        List<Painter<JXMapViewer>> painters = new ArrayList<>();
        painters.add(routePainter);
        painters.add(routePainter2);
        painters.add(routePainter3);
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
