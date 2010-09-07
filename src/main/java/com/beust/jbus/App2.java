package com.beust.jbus;

public class App2
{
  @Subscriber
  public void event2(NotifyEvent ne) {
    System.out.println("App2 received " + ne);
  }

}
