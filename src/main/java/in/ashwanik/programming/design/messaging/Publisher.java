package in.ashwanik.programming.design.messaging;

public class Publisher {

	private String name;

	public String getName() {
		return name;
	}

	public Publisher(String name) {
		this.name = name;
	}

	public <T> void publish(Message<T> message) {
		message.setSender(name);
		message.setSentOn(System.currentTimeMillis());
		PublishService.publish(message);
	}

}
