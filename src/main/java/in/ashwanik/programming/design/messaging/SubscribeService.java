package in.ashwanik.programming.design.messaging;

public class SubscribeService {

	public static void subscribe(Subscriber subscriber, String topic) {
		Broker.getInstance().addSubscriber(topic, subscriber);
	}

	public static void unsubscribe(Subscriber subscriber, String topic) {
		Broker.getInstance().removeSubscriber(topic, subscriber);
	}

}
