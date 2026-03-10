package com.your.mom.utils;

import java.util.HashMap;

public class Event
{
    @FunctionalInterface
    public interface Action
    {
        void accept();
    }

    private final HashMap<Object, Action> subscribers;

    public Event()
    {
        subscribers = new HashMap<Object, Action>();
    }

    public void subscribe(Object subscriber, Action action)
    {
        // identify the method subscription with unique reference to the subscribing object
        
        subscribers.put(subscriber, action);
    }

    public void unsubscribe(Object subscriber)
    {
        // identify the method subscription with unique reference to the subscribing object
        
        subscribers.remove(subscriber);
    }

    public void publish()
    {
        // get list of values from the map separately and then loop through them,
        // so that the subscribers remain addable and removable to the map throughout the loop
        
        for (Action action : subscribers.values())
        {
            action.accept();
        }
    }
}
