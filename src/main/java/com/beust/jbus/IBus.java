package com.beust.jbus;

public interface IBus
{

  public abstract void register(Object object);

  public abstract void unregister(Object object);

  public abstract void post(Object event);

  public abstract void post(Object event, String[] categories);

}