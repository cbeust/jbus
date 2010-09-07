package com.beust.jbus;

public class ParentEvent {
  
  private String m_message;

  public ParentEvent(String string) {
    m_message = string;
  }

  public String getMessage() {
    return m_message;
  }

  public String toString() {
    return "[Parent message:" + m_message + "]";
  }
}
