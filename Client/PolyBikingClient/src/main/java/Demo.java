import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.JMapViewerTree;
import org.openstreetmap.gui.jmapviewer.OsmTileLoader;
import org.openstreetmap.gui.jmapviewer.events.JMVCommandEvent;
import org.openstreetmap.gui.jmapviewer.interfaces.JMapViewerEventListener;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

import javax.swing.*;
import java.awt.*;

/**
 * Based on http://svn.openstreetmap.org/applications/viewer/jmapviewer/src/org/openstreetmap/gui/jmapviewer/Demo.java by Jan Peter Stotz
 */
public class Demo extends JFrame implements JMapViewerEventListener {

    private static final long serialVersionUID = 1L;

    private JMapViewerTree treeMap;
    private JLabel zoomLabel;
    private JLabel zoomValue;
    private JLabel mperpLabelName;
    private JLabel mperpLabelValue;


    /**
     * Setups the JFrame layout, sets some default options for the JMapViewerTree and displays a map in the window.
     */
    public Demo() {
        super("JMapViewer Demo");
        treeMap = new JMapViewerTree("Zones");

        // Listen to the map viewer for user operations so components will
        // receive events and updates
        map().addJMVListener(this);

        // Set some options, e.g. tile source and that markers are visible
        map().setTileSource(new OsmTileSource.Mapnik());
        map().setTileLoader(new OsmTileLoader(map()));
        map().setMapMarkerVisible(true);
        map().setZoomContolsVisible(true);

        // activate map in window
        treeMap.setTreeVisible(true);
        add(treeMap, BorderLayout.CENTER);
    }

    // ... further methods like setupJFrame() or setupPanels()

    private JMapViewer map() {
        return treeMap.getViewer();
    }


    /**
     * @param args Main program arguments
     */
    public static void main(String[] args) {
        new Demo().setVisible(true);
    }


    @Override
    public void processCommand(JMVCommandEvent command) {
        // ...
    }
}