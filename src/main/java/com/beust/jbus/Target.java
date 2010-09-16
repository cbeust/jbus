package com.beust.jbus;

import java.lang.reflect.Method;

public class Target {
  private Object _object;
  private Method _method;

  public Target(Object object, Method method)
  {
    _object = object;
    _method = method;
  }

  public Object getObject()
  {
    return _object;
  }

  public Method getMethod()
  {
    return _method;
  }

  public String[] getCategoryPatterns()
  {
    String[] result = new String[0];

    Subscriber s = _method.getAnnotation(Subscriber.class);
    if (s != null) result = s.categories();

    return result;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_method == null) ? 0 : _method.hashCode());
    result = prime * result + ((_object == null) ? 0 : _object.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Target other = (Target) obj;
    if (_method == null)
    {
      if (other._method != null)
        return false;
    } else if (!_method.equals(other._method))
      return false;
    if (_object == null)
    {
      if (other._object != null)
        return false;
    } else if (!_object.equals(other._object))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "[Target " + _object.getClass().getName() + "." + _method.getName() + "()]";
  }
}
