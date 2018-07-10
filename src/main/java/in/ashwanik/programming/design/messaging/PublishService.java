package in.ashwanik.programming.design.messaging;

import java.util.ArrayList;

public class PublishService {

	public static <T> void publish(Message<T> message) {

		ArrayList<Subscriber> subscribers = Broker.getInstance()
				.getSubscribersForTopic(message.getTopic());

		if (subscribers != null) {
			for (Subscriber subscriber : subscribers) {
				subscriber.receive(message);
			}
		} else {
			System.out
					.println("No subscriber for topic: " + message.getTopic());
		}

	}

}
