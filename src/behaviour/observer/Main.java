package behaviour.observer;

import java.util.ArrayList;
import java.util.List;

// Allows clients to subscribe to the publisher.
// Publisher can notify subscribers.

public class Main {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        publisher.subscribe(new SubscriberImpl("John"));
        publisher.subscribe(new SubscriberImpl("Stacy"));
        publisher.subscribe(new SubscriberImpl("Bekky"));
        publisher.subscribe(new SubscriberImpl("Alex"));

        publisher.notifySubscribers();
    }
}

interface Subscriber {

    void update();

}

class SubscriberImpl implements Subscriber {

    private String name;

    public SubscriberImpl(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("My name is: " + name + ". I have been notified.");
    }
}

class Publisher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void notifySubscribers() {
        subscribers.forEach(Subscriber::update);
    }
}