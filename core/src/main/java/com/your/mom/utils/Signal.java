package com.your.mom.utils;

import java.util.HashMap;

public class Signal
{
    @FunctionalInterface
    public interface Action
    {
        void accept();
    }

    private final HashMap<Object, Action> subscribers;

    public Signal()
    {
        subscribers = new HashMap<Object, Action>();
    }

    public void subscribe(Object subscriber, Action action)
    {
        subscribers.put(subscriber, action);
    }

    public void unsubscribe(Object subscriber)
    {
        subscribers.remove(subscriber);
    }

    public void publish()
    {
        for (Action action : subscribers.values())
        {
            action.accept();
        }
    }
}
