package com.quasar.fire.service.impl;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.quasar.fire.TypeConverterUtility;
import com.quasar.fire.domain.entities.Location;
import com.quasar.fire.service.LocationService;
import java.util.stream.Stream;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Carlos Restrepo on 6/11/2021.
 */
@Service
public class LocationServiceImpl implements LocationService {

  @Value("${quasar-fire.satellites.quantity}")
  private int satellitesQuantity;

  @Autowired
  private Environment environment;

  @Override
  public Location getLocation(float... distances) {

    if (satellitesQuantity < 3) {
      return null;
    }

    // Get satellites position
    double[][] satellitesPosition = new double[satellitesQuantity][];
    for (int i = 0; i < satellitesQuantity; i++) {

      final String position = environment.getProperty("quasar-fire.satellites.positions." + i);
      if (position == null || position.trim().equals("")) {
        return null;
      }

      satellitesPosition[i] = Stream.of(StringUtils.split(position, ","))
          .mapToDouble(Double::valueOf)
          .toArray();
    }

    TrilaterationFunction trilaterationFunction = new TrilaterationFunction(satellitesPosition,
        TypeConverterUtility.floatArrayToDoubleArray(distances));
    NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction,
        new LevenbergMarquardtOptimizer());

    double[] location = nSolver.solve().getPoint().toArray();
    if (location != null) {
      return new Location((float) location[0], (float) location[1]);
    }
    return null;
  }
}
