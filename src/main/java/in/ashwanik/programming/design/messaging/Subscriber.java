package in.ashwanik.programming.design.messaging;

import java.util.Date;

public class Subscriber {

	public String getName() {
		return name;
	}

	public Subscriber(String name) {
		this.name = name;
	}

	private String name;

	public <T> void receive(Message<T> message) {
		message.setReceiver(name);
		message.setReceivedOn(System.currentTimeMillis());
		System.out.println("Received message for " + message.getTopic()
				+ " with content " + message.getPayload().toString() + " at "
				+ new Date(message.getSentOn()));
	}
}
