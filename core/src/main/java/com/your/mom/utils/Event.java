package com.your.mom.utils;

import java.util.HashMap;

public class Event<T> {
    @FunctionalInterface
    public interface Subscriber<T> {
        void accept(T t);
    }

    private HashMap<Object, Subscriber<T>> subscribers = new HashMap<>();

    public void publish(T message) {
        for (Subscriber<T> subscriber : subscribers.values()) {
            subscriber.accept(message);
        }
    }

    public void subscribe(Object key, Subscriber<T> subscriber) {
        subscribers.put(key, subscriber);
    }

    public void unsubscribe(Object key) {
        subscribers.remove(key);
    }
}
