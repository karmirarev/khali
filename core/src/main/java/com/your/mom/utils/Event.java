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
        // identify the subscription with unique reference to the subscribing object
        subscribers.put(subscriber, action);
    }

    public void unsubscribe(Object subscriber)
    {
        // identify the subscription with unique reference to the subscribing object
        subscribers.remove(subscriber);
    }

    public void invoke()
    {
        // get values before the loop, so the list remains mutable throughout the loop
        for (Action subscriberAction : subscribers.values())
        {
            subscriberAction.accept();
        }
    }
}
