package com.beust.jbus;

import java.beans.PropertyChangeEvent;

/**
 * A holder for a value that posts events on the JBus when it gets modified.
 * 
 * @author "Cedric Beust"
 */
public class Property<T>
{
  private T _value;
  private String  _name;
  private JBus _bus;
  private Object _source;

  public Property(JBus bus, Object source, String name)
  {
    _bus = bus;
    _source = source;
    _name = name;
  }

  public T get()
  {
    return _value;
  }

  public String getName()
  {
    return _name;
  }

  public void set(Object source, T value)
  {
    T old = value;
    _value = value;
//    if (_source == source)
//    {
//      p("Same source, not posting");
//      return;
//    }

    if (old == null && value == null) return;
    if ((old != null && ! (old.equals(value))) || (! value.equals(old)))
    {
      _bus.post(new PropertyChangeEvent(_source, _name, old, _value));
    }
    else
    {
      p("Ignoring set to same value:" + value);
    }
  }

  private void p(String string)
  {
    System.out.println("[Property] " + string);
  }
}
