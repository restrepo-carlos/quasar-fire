package com.quasar.fire.domain.response;

import com.quasar.fire.domain.entities.Location;

/**
 * Created by Carlos Restrepo on 6/8/2021.
 */
public class SatellitesResponse {

  private Location location;
  private String message;

  public SatellitesResponse(Location location, String message) {
    this.location = location;
    this.message = message;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
