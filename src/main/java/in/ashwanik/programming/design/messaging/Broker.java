package in.ashwanik.programming.design.messaging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Broker {

	private static Broker instance;

	public synchronized static Broker getInstance() {
		if (instance == null) {
			instance = new Broker();
			instance.subscribers = new HashMap<>();
		}
		return instance;
	}

	private Map<String, ArrayList<Subscriber>> subscribers;

	public ArrayList<Subscriber> getSubscribersForTopic(String topic) {
		synchronized (subscribers) {
			if ((topic != null && (topic.length() > 0))
					&& subscribers.containsKey(topic)) {
				return subscribers.get(topic);
			} else {
				return null;
			}
		}
	}

	public void addSubscriber(String topic, Subscriber subscriber) {
		synchronized (subscribers) {
			if (topic != null && (topic.length() > 0)) {

				if (subscribers.containsKey(topic)) {
					subscribers.get(topic).add(subscriber);
				} else {
					ArrayList<Subscriber> subscribersList = new ArrayList<Subscriber>();
					subscribersList.add(subscriber);
					subscribers.put(topic, subscribersList);
				}
			}
		}
	}

	public void removeSubscriber(String topic, Subscriber subscriber) {
		synchronized (subscribers) {
			if (topic != null && (topic.length() > 0)) {

				ArrayList<Subscriber> subscribersList = Broker.getInstance()
						.getSubscribersForTopic(topic);

				if (subscribersList != null) {

					for (int index = 0; index < subscribersList.size(); index++) {
						if (subscriber.getClass().equals(
								subscribersList.get(index).getClass())) {
							subscribersList.remove(index);
							break;
						}
					}
				}
			}
		}
	}
}
