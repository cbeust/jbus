package com.beust.jbus;

public class NotifyEvent extends ParentEvent {

  private String m_notify;

  public NotifyEvent(String string, String notify) {
    super(string);
    m_notify = notify;
  }

  public String toString() {
    return "[Notify message:" + getMessage() + " notify:" + m_notify + "]";
  }

}
