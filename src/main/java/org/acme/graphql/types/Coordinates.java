package org.acme.graphql.types;

import org.eclipse.microprofile.graphql.Type;

/**
 * Coordenadas geográficas.
 */
@Type("Coordinates")
public class Coordinates {

    private String latitude;
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
