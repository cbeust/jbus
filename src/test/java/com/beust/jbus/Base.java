package com.beust.jbus;

import java.beans.PropertyChangeEvent;


public class Base {
  private PropertyChangeEvent _pce;

  @Subscriber
  public void pce(PropertyChangeEvent pce) {
    _pce = pce;
  }

  public PropertyChangeEvent getPce() {
    return _pce;
  }
}
