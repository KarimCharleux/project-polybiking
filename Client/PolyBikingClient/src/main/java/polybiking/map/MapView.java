package polybiking.map;

import com.soap.ws.client.generated.ArrayOfPath;
import com.soap.ws.client.generated.Path;
import com.soap.ws.client.generated.PathType;
import com.soap.ws.client.generated.Position;
import jakarta.jms.JMSException;
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
import polybiking.activemq.ActiveMQManager;
import polybiking.activemq.Coordinate;
import polybiking.activemq.Step;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.exit;
import static polybiking.map.Utils.convertMetersToKilometers;

public class MapView {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final Color CYCLE_PATH_COLOR = Color.GREEN;
    private static final Color FOOT_PATH_COLOR = Color.GRAY;
    private final JXMapViewer mapViewer;
    private final JFrame frame;
    private final ArrayOfPath paths;
    private ActiveMQManager activeMQManager;
    private final List<Painter<JXMapViewer>> painters;

    public MapView(ArrayOfPath paths) {
        this.paths = paths;
        this.frame = new JFrame("PolyBiking");
        this.mapViewer = new JXMapViewer();
        this.painters = new ArrayList<>();
        try {
            this.activeMQManager = new ActiveMQManager();
            this.activeMQManager.connect();
            // Init the button to navigate if activeMq is connected
            if (activeMQManager.isConnected()) {
                JButton navigateButton = new JButton("✅ Go navigate !");
                // Position to bottom center of the map
                navigateButton.setBounds(WIDTH / 2 - 50, HEIGHT - 80, 140, 30);
                navigateButton.addActionListener(e -> onNavigateButtonClick());
                this.mapViewer.setLayout(null); // Allow to set the position of the button
                this.mapViewer.add(navigateButton);
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        this.setupMap();
        this.computeRoute();
    }

    /**
     * Setup the map with the tile factory
     */
    private void setupMap() {
        this.frame.getContentPane().add(this.mapViewer);
        this.frame.setSize(WIDTH, HEIGHT);
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

        // Create a track from the geo-positions and add it to the route-painter
        List<Path> pathList = this.paths.getPath();

        // Track list for the focus
        List<GeoPosition> trackList = new ArrayList<>();

        for (int pathIndex = 0; pathIndex < pathList.size(); pathIndex++) {
            Path path = pathList.get(pathIndex);
            List<GeoPosition> track = new ArrayList<>();
            for (Position coordinates : path.getCoordinates().getValue().getPosition()) {
                track.add(new GeoPosition(coordinates.getLat(), coordinates.getLng()));
            }

            // Create the route painter that takes the track and the right color
            if (path.getType().equals(PathType.BIKE_PATH)) {
                this.painters.add(new RoutePainter(track, CYCLE_PATH_COLOR));
            } else if (path.getType().equals(PathType.FOOT_PATH)) {
                this.painters.add(new RoutePainter(track, FOOT_PATH_COLOR));
            } else {
                this.painters.add(new RoutePainter(track, Color.BLACK));
            }

            // Add waypoints with the correct icon and logo
            if (pathIndex == 0) { // First footpath
                waypointSet.add(new MyWaypoint("Origin", Color.BLACK, track.get(0), "origin.png"));
                if (pathList.size() == 1) {
                    waypointSet.add(new MyWaypoint("Destination", Color.BLACK, track.get(track.size() - 1), "destination.png"));
                }
            } else if (pathIndex == pathList.size() - 1) { // Last footpath
                waypointSet.add(new MyWaypoint("Destination", Color.BLACK, track.get(track.size() - 1), "destination.png"));
            } else if (path.getType().equals(PathType.BIKE_PATH)) { // Cycle path
                waypointSet.add(new MyWaypoint("Station", Color.BLACK, track.get(0), "station.png"));
                waypointSet.add(new MyWaypoint("Station", Color.BLACK, track.get(track.size() - 1), "station.png"));
            }
            trackList.addAll(track);
        }

        // Create a waypoint painter that takes all the waypoints
        WaypointPainter<MyWaypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypointSet);
        waypointPainter.setRenderer(new FancyWaypointRenderer());
        this.painters.add(waypointPainter);

        this.mapViewer.setOverlayPainter(new CompoundPainter<>(this.painters));

        // Focus on the track
        this.mapViewer.zoomToBestFit(new HashSet<>(trackList), 0.7);
        this.mapViewer.setZoom(5);
    }

    /**
     * Clear the map and remove all the painters and waypoints
     */
    public void clearMap() {
        this.mapViewer.removeAll();
        this.painters.clear();
        CompoundPainter<JXMapViewer> emptyPainter = new CompoundPainter<>(this.painters);
        this.mapViewer.setOverlayPainter(emptyPainter);
    }

    private void onNavigateButtonClick() {
        System.out.println("\n▶️ Starting navigation ...");
        clearMap();
        // Button stop navigation
        JButton stopButton = new JButton("❌ Stop navigation");
        stopButton.setBounds(WIDTH - 150, 10, 140, 30);
        stopButton.addActionListener(e -> onStopButtonClick());
        this.mapViewer.setLayout(null); // Allow to set the position of the button
        this.mapViewer.add(stopButton);

        // Button next step
        JButton nextStepButton = new JButton("⏭ Next step");
        nextStepButton.setBounds(WIDTH - 150, 50, 140, 30);
        nextStepButton.addActionListener(e -> onNextStepButtonClick());
        this.mapViewer.setLayout(null); // Allow to set the position of the button
        this.mapViewer.add(nextStepButton);
    }

    private void onNextStepButtonClick() {
        try {
            polybiking.activemq.Path path = activeMQManager.receiveMessage();
            if (path == null) {
                System.out.println("❌ Error: No path received");
                return;
            }
            System.out.println("\n⏳ Computing next step ...\n");
            List<GeoPosition> track = new ArrayList<>();
            for (Coordinate coordinates : path.getCoordinates()) {
                track.add(new GeoPosition(coordinates.getLat(), coordinates.getLng()));
            }
            // Create the route painter that takes the track and the right color
            if (path.getType() == PathType.BIKE_PATH.ordinal()) {
                this.painters.add(new RoutePainter(track, CYCLE_PATH_COLOR));
            } else if (path.getType() == PathType.FOOT_PATH.ordinal()) {
                this.painters.add(new RoutePainter(track, FOOT_PATH_COLOR));
            } else {
                this.painters.add(new RoutePainter(track, Color.BLACK));
            }
            this.mapViewer.setOverlayPainter(new CompoundPainter<>(this.painters));
            this.mapViewer.zoomToBestFit(new HashSet<>(track), 0.7);

            for (Step step : path.getSteps()) {
                System.out.println("► At " + convertMetersToKilometers(step.getDistance()) + ": " + step.getInstruction());
            }

            System.out.println("\n✅ Next step computed !");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void onStopButtonClick() {
        System.out.println("\n⏹ Stopping navigation ...");
        clearMap();
        try {
            this.activeMQManager.close();
        } catch (JMSException e) {
            System.out.println("❌ Error while closing ActiveMQ connection: " + e.getMessage());
        }
        exit(0);
    }
}
