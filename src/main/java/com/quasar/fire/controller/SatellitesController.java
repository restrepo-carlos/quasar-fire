package com.quasar.fire.controller;

import com.quasar.fire.domain.entities.Satellite;
import com.quasar.fire.domain.request.SatellitesRequest;
import com.quasar.fire.domain.response.SatellitesResponse;
import com.quasar.fire.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Carlos Restrepo on 6/8/2021.
 */
@RestController
@RequestMapping("/satellites")
public class SatellitesController {

  @Autowired
  private SatelliteService satelliteService;

  @PostMapping("/topsecret")
  public ResponseEntity<SatellitesResponse> topSecret(
      @RequestBody SatellitesRequest satellitesRequest)
      throws Exception {
    return ResponseEntity.ok(satelliteService.topSecret(satellitesRequest.getSatellites()));
  }

  @PostMapping("/topsecret_split/{satellite_name}")
  public ResponseEntity<String> topSecretSplit(@RequestBody Satellite satellite,
      @PathVariable String satellite_name) {
    satellite.setName(satellite_name);
    return ResponseEntity.ok(satelliteService.topSecretSplit(satellite));
  }

  @GetMapping("/topsecret_split")
  public ResponseEntity<SatellitesResponse> topSecretSplit()
      throws Exception {
    return ResponseEntity.ok(satelliteService.topSecretSplit());
  }
}
