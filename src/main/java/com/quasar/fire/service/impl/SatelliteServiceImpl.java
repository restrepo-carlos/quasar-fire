package com.quasar.fire.service.impl;

import com.quasar.fire.domain.entities.Location;
import com.quasar.fire.domain.entities.Satellite;
import com.quasar.fire.domain.response.SatellitesResponse;
import com.quasar.fire.service.LocationService;
import com.quasar.fire.service.MessageService;
import com.quasar.fire.service.SatelliteService;
import com.quasar.fire.utilities.SatellitesSingleton;
import com.quasar.fire.utilities.exception.TopSecretException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Created by Carlos Restrepo on 6/8/2021.
 */
@Service
public class SatelliteServiceImpl implements SatelliteService {

  @Autowired
  private LocationService locationService;

  @Autowired
  private MessageService messageService;

  @Override
  public SatellitesResponse topSecret(List<Satellite> satellites)
      throws TopSecretException {
    if (CollectionUtils.isEmpty(satellites)) {
      throw new TopSecretException(HttpStatus.NOT_FOUND, "Satellites are required");
    }

    // Get distances and messages
    float[] distances = new float[satellites.size()];
    String[][] messages = new String[satellites.size()][];

    for (int i = 0; i < satellites.size(); i++) {
      Satellite satellite = satellites.get(i);
      distances[i] = satellite.getDistance();
      messages[i] = satellite.getMessage();
    }

    // Get location
    Location location = locationService.getLocation(distances);
    if (location == null) {
      throw new TopSecretException(HttpStatus.NOT_FOUND, "Location can not be defined");
    }

    // Get Message
    String message = messageService.getMessage(messages);
    if (message == null || message.isEmpty()) {
      throw new TopSecretException(HttpStatus.NOT_FOUND, "Message can not be defined");
    }

    return new SatellitesResponse(location, message);
  }

  @Override
  public String topSecretSplit(Satellite satellite) {
    SatellitesSingleton satellitesSingleton = SatellitesSingleton.getInstance();
    satellitesSingleton.getSatellites().put(satellite.getName(), satellite);
    return "Satellite has been saved successfully";
  }

  @Override
  public SatellitesResponse topSecretSplit() throws TopSecretException {
    SatellitesSingleton satellitesSingleton = SatellitesSingleton.getInstance();

    List<Satellite> satelliteList = new ArrayList(satellitesSingleton.getSatellites().values());
    if (satelliteList.size() < 3) {
      throw new TopSecretException(HttpStatus.PRECONDITION_REQUIRED,
          "There are not enough satellites information");
    }

    return this.topSecret(satelliteList);
  }
}
