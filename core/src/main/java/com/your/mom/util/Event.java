package com.your.mom.util;

import java.util.HashMap;

public class Event<T> {
    @FunctionalInterface
    public interface Subscriber<T> {
        void accept(T t);
    }

    private final T message;

    private HashMap<Object, Subscriber<T>> subscribers = new HashMap<>();

    public Event(T message) {
        this.message = message;
    }

    public void publish() {
        for (Subscriber<T> subscriber : subscribers.values()) {
            subscriber.accept(message);
        }
    }

    public void subscribe(Object poop, Subscriber<T> subscriber) {
        subscribers.put(poop, subscriber);
    }

    public void unsubscribe(Object poop) {
        subscribers.remove(poop);
    }
}
