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
}
