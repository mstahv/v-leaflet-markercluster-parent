package org.vaadin.addon.leaflet.demoandtestapp;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vividsolutions.jts.geom.Point;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LMarker;
import org.vaadin.addon.leaflet.markercluster.LMarkerClusterGroup;

public class MarkerClusterSpiderifyTest extends AbstractMarkerClusterTest {

    private LMarker firstMarker;

    @Override
    public String getDescription() {
        return "MarkerCluster test case to spiderify a parent of a selected marker";
    }

    @Override
    protected void setup() {
        super.setup();
    }

    @Override
    public Component getTestComponent() {
        final LMap map = (LMap) super.getTestComponent();
        Button spiderify = new Button("Spiderify");
        spiderify.addClickListener( e-> {
            markerClusterGroup.spiderifyParent(firstMarker);
            map.setCenter(firstMarker.getPoint());
        });
        final VerticalLayout verticalLayout = new VerticalLayout();
        
        verticalLayout.addComponent(spiderify);
        verticalLayout.addComponentsAndExpand(map);

        return verticalLayout;
    }

    @Override
    public LMarkerClusterGroup getMarkerClusterGroup(Point p) {
        markerClusterGroup = super.getMarkerClusterGroup(p);
        firstMarker = (LMarker) markerClusterGroup.iterator().next();
        
        return markerClusterGroup;
    }
    private LMarkerClusterGroup markerClusterGroup;

}
