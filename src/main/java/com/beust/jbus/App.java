package com.beust.jbus;

import java.beans.PropertyChangeEvent;

public class App {

  @Subscriber
  public void event1(ParentEvent ne) {
    System.out.println("App received ParentEvent " + ne);
  }

  @Subscriber(categories = "Prop1")
  public void category(PropertyChangeEvent evt) {
    System.out.println("App received a PCE, name:" + evt.getPropertyName());
  }

  //  @Subscriber
//  public void event2(NotifyEvent ne) {
//    System.out.println("event2: " + ne);
//  }

  public static void main(String[] args) {
    JBus jbus = new JBus();
    jbus.register(new App());
    jbus.register(new App2());
    jbus.post(new NotifyEvent("Parent", "notify")); // should be received by both
    jbus.post(new Notify2Event("Parent", "notify2")); // only received by App

    jbus.post(new PropertyChangeEvent(new App(), "Prop1", "before", "after"), new String[] { "Prop2" });
    jbus.post(new PropertyChangeEvent(new App(), "Prop2", "before", "after"));
  }
}
