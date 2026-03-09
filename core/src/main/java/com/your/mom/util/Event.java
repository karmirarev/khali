package com.your.mom.util;

import java.util.ArrayList;
import java.util.HashMap;

public class Event<T> {
    @FunctionalInterface
    public interface Subscriber<T> {
        void accept(T t);
    }

    private ArrayList<Subscriber<T>> subscribers = new ArrayList<>();
    // private Hashmap<> subscribers = new HashMap<>();
    private final T message;

    public Event(T message) {
        this.message = message;
    }

    public void publish() {
        for (Subscriber<T> subscriber : subscribers) {
            subscriber.accept(message);
        }
    }

    public void subscribe(Subscriber<T> subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber<T> subscriber) {
        subscribers.remove(subscriber);
    }
}
