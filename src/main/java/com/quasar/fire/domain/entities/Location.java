package com.quasar.fire.domain.entities;

/**
 * Created by Carlos Restrepo on 6/11/2021.
 */
public class Location {

  private float x;
  private float y;

  public Location(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return y;
  }

  public void setY(float y) {
    this.y = y;
  }
}
