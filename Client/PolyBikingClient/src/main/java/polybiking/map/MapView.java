package polybiking.map;

import com.soap.ws.client.generated.ArrayOfPath;
import com.soap.ws.client.generated.Path;
import com.soap.ws.client.generated.PathType;
import com.soap.ws.client.generated.Position;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void display() {
        this.frame.setVisible(true);
    }

    /**
     * Compute the route between the origin and the destination
     * Make a call to the SOAP Server
     */
    private void computeRoute() {

        // Create Waypoints set
        Set<MyWaypoint> waypointSet = new HashSet<>();

        // Create a compound painter that uses both the route-painter and the waypoint-painter
        List<Painter<JXMapViewer>> painters = new ArrayList<>();

        // Create a track from the geo-positions and add it to the route-painter
        List<Path> pathList = this.paths.getPath();
        for (int pathIndex = 0; pathIndex < pathList.size(); pathIndex++) {
            Path path = pathList.get(pathIndex);
            List<GeoPosition> track = new ArrayList<>();
            for (Position coordinates : path.getCoordinates().getValue().getPosition()) {
                track.add(new GeoPosition(coordinates.getLat(), coordinates.getLng()));
            }

            // Create the route painter that takes the track and the right color
            if (path.getType().equals(PathType.BIKE_PATH)) {
                painters.add(new RoutePainter(track, CYCLE_PATH_COLOR));
            } else if (path.getType().equals(PathType.FOOT_PATH)) {
                painters.add(new RoutePainter(track, FOOT_PATH_COLOR));
            } else {
                painters.add(new RoutePainter(track, Color.BLACK));
            }

            // Add waypoints with the correct icon and logo
            if (pathIndex == 0) { // First footpath
                waypointSet.add(new MyWaypoint("Origin", Color.BLACK, track.get(0), "origin.png"));
                // Set the focus
                this.mapViewer.zoomToBestFit(new HashSet<>(track), 0.7);
                if (pathList.size() == 1) {
                    waypointSet.add(new MyWaypoint("Destination", Color.BLACK, track.get(track.size() - 1), "destination.png"));
                }
            } else if (pathIndex == pathList.size() - 1) { // Last footpath
                waypointSet.add(new MyWaypoint("Destination", Color.BLACK, track.get(track.size() - 1), "destination.png"));
            } else if (path.getType().equals(PathType.BIKE_PATH)) { // Cycle path
                waypointSet.add(new MyWaypoint("Station", Color.BLACK, track.get(0), "station.png"));
                waypointSet.add(new MyWaypoint("Station", Color.BLACK, track.get(track.size() - 1), "station.png"));
            }
        }

        // Create a waypoint painter that takes all the waypoints
        WaypointPainter<MyWaypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypointSet);
        waypointPainter.setRenderer(new FancyWaypointRenderer());
        painters.add(waypointPainter);

        this.mapViewer.setOverlayPainter(new CompoundPainter<>(painters));
    }
}
