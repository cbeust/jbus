package com.beust.jbus;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.beans.PropertyChangeEvent;

public class JBusTest
{
  private IBus _bus;
  private Sample1 _sample1;

  @BeforeMethod
  public void before() {
    _bus = new JBus();
    _sample1 = new Sample1();
  }

  @Test
  public void exactEvents() {
    PropertyChangeEvent pce = new PropertyChangeEvent(this, "Prop", "before", "after");
    _bus.register(_sample1);
    Assert.assertNull(_sample1.getPce());
    _bus.post(pce);
    assertEquals(_sample1.getPce(), this, "Prop", "before", "after");
  }

  private void assertEquals(PropertyChangeEvent pce, Object source, String name, Object old,
      Object nnew) {
    assertEquals(pce, new PropertyChangeEvent(source, name, old, nnew));
  }

  private void assertEquals(PropertyChangeEvent pce, PropertyChangeEvent pce2) {
    Assert.assertTrue(pce.getSource() == pce2.getSource());
    Assert.assertEquals(pce.getPropertyName(), pce2.getPropertyName());
    Assert.assertEquals(pce.getOldValue(), pce2.getOldValue());
    Assert.assertEquals(pce.getNewValue(), pce2.getNewValue());
  }

  public static void main(String[] args)
  {
    JBusTest jt = new JBusTest();
    jt.before();
    jt.exactEvents();
  }
}
