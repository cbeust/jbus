package com.beust.jbus;

public class Notify2Event extends ParentEvent {

  private String m_notify;

  public Notify2Event(String string, String notify) {
    super(string);
    m_notify = notify;
  }

  public String toString() {
    return "[Notify2 message:" + getMessage() + " notify:" + m_notify + "]";
  }

}
