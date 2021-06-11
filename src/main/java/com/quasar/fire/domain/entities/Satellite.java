package com.quasar.fire.domain.entities;

/**
 * Created by Carlos Restrepo on 6/8/2021.
 */
public class Satellite {

  private String name;
  private float distance;
  private String[] message;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getDistance() {
    return distance;
  }

  public void setDistance(float distance) {
    this.distance = distance;
  }

  public String[] getMessage() {
    return message;
  }

  public void setMessage(String[] message) {
    this.message = message;
  }
}
