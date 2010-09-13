package com.beust.jbus;

public interface IBus
{

  /**
   * Register this object to receive notifications. The object passed in parameter will
   * be searched for any method annotated with @{link @Subscriber} and each of
   * these methods will be invoked if an object posted on the bus matches its
   * parameter.
   */
  void register(Object object);

  /**
   * Unregister an object from the bus.
   */
  void unregister(Object object);

  /**
   * Post an object on the bus.
   */
  void post(Object event);

  /**
   * Post an object on the bus with the specified categories. Only subscribers
   * whose category pattern matches at least one of these categories will
   * be invoked.
   */
  void post(Object event, String[] categories);

}