package com.quasar.fire.utilities;

import com.quasar.fire.domain.entities.Satellite;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Carlos Restrepo on 6/11/2021.
 */
public final class SatellitesSingleton {

  private SatellitesSingleton() {
  }

  /**
   * LinkedHashMap is used to get the same result from the "Nivel 2" request.
   */
  private Map<String, Satellite> satellites = new LinkedHashMap();

  private static SatellitesSingleton sSatellitesSingleton;

  public static SatellitesSingleton getInstance() {
    if (sSatellitesSingleton == null) {
      sSatellitesSingleton = new SatellitesSingleton();
    }
    return sSatellitesSingleton;
  }

  public Map<String, Satellite> getSatellites() {
    return satellites;
  }

  public void setSatellites(
      Map<String, Satellite> satellites) {
    this.satellites = satellites;
  }
}
