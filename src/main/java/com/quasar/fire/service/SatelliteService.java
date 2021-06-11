package com.quasar.fire.service;

import com.quasar.fire.domain.entities.Satellite;
import com.quasar.fire.domain.response.SatellitesResponse;
import com.quasar.fire.utilities.exception.TopSecretException;
import java.util.List;

/**
 * Created by Carlos Restrepo on 6/8/2021.
 */
public interface SatelliteService {

  /**
   * Método encargado de determinar la ubicación y el mensaje emitido por un satélite.
   *
   * @param satellites
   * @return SatellitesResponse: Contiene ubicación y mensaje emitido por el satélite.
   * @throws TopSecretException
   */
  SatellitesResponse topSecret(List<Satellite> satellites) throws TopSecretException;

  /**
   * Método encargado de guardar los detalles de cada satélite individualmente.
   *
   * @param satellite
   * @return Mensaje indicando resultado de la transacción.
   */
  String topSecretSplit(Satellite satellite);

  /**
   * Método encargado de determinar la ubicación y el mensaje emitido por un satélite.
   *
   * @return SatellitesResponse: Contiene ubicación y mensaje emitido por el satélite.
   * @throws TopSecretException
   */
  SatellitesResponse topSecretSplit() throws TopSecretException;
}
