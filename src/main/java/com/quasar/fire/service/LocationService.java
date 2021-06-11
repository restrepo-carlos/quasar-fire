package com.quasar.fire.service;

import com.quasar.fire.domain.entities.Location;

/**
 * Created by Carlos Restrepo on 6/11/2021.
 */
public interface LocationService {

  /**
   * Método encargado de obtener las coordenadas 'x' e 'y' del emisor del mensaje de acuerdo a la
   * distancia entre cada satélite.
   *
   * @param distances
   * @return Location: Contiene coordenadas 'x' e 'y'.
   */
  Location getLocation(float... distances);
}
