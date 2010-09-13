package com.beust.jbus;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.beans.PropertyChangeEvent;

public class JBusTest
{
  private IBus _bus;
  private Sample1 _sample1;
  private Sample2 _sample2;

  @BeforeMethod
  public void before() {
    _bus = new JBus();
    _sample1 = new Sample1();
    _sample2 = new Sample2();
  }

  @Test
  public void exactEvents() {
    PropertyChangeEvent pce = new PropertyChangeEvent(this, "Prop", "before", "after");
    _bus.register(_sample1);
    _bus.register(_sample2);
    Assert.assertNull(_sample1.getPce());
    Assert.assertNull(_sample2.getPce());
    _bus.post(pce);
    assertEquals(_sample1.getPce(), this, "Prop", "before", "after");
    assertEquals(_sample2.getPce(), this, "Prop", "before", "after");
  }

  private void assertEquals(PropertyChangeEvent pce, Object source, String name, Object old,
      Object nnew) {
    Assert.assertTrue(pce.getSource() == source);
    Assert.assertEquals(pce.getPropertyName(), name);
    Assert.assertEquals(pce.getOldValue(), old);
    Assert.assertEquals(pce.getNewValue(), nnew);
  }

  public static void main(String[] args)
  {
    JBusTest jt = new JBusTest();
    jt.before();
    jt.exactEvents();
  }
}
