package com.quasar.fire;

/**
 * Created by Carlos Restrepo on 6/11/2021.
 */
public final class TypeConverterUtility {

  private TypeConverterUtility() {
  }

  public static double[] floatArrayToDoubleArray(float[] input) {
    if (input == null || input.length == 0) {
      return null;
    }

    double[] output = new double[input.length];
    for (int x = 0; x < input.length; x++) {
      output[x] = input[x];
    }
    return output;
  }
}
