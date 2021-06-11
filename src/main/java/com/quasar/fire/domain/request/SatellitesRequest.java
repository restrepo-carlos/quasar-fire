package com.quasar.fire.domain.request;

import com.quasar.fire.domain.entities.Satellite;
import java.util.List;

/**
 * Created by Carlos Restrepo on 6/8/2021.
 */
public class SatellitesRequest {

  private List<Satellite> satellites;

  public List<Satellite> getSatellites() {
    return satellites;
  }

  public void setSatellites(List<Satellite> satellites) {
    this.satellites = satellites;
  }
}
