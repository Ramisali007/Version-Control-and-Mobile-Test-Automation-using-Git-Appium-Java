package org.openqa.selenium.html5;

/**
 * Compatibility stub – removed from Selenium 4.x but referenced in
 * Appium Java Client 9.1.0 compiled bytecode (LocationContext).
 */
public class Location {
    private final double latitude;
    private final double longitude;
    private final double altitude;

    public Location(double latitude, double longitude, double altitude) {
        this.latitude  = latitude;
        this.longitude = longitude;
        this.altitude  = altitude;
    }

    public double getLatitude()  { return latitude;  }
    public double getLongitude() { return longitude; }
    public double getAltitude()  { return altitude;  }
}
