package in.ashwanik.programming.design.messaging;

public class Message<T> {

	private String topic;
	private String sender;
	private String receiver;
	private long sentOn;
	private long receivedOn;
	
	
	private T payload;

	public T getPayload() {
		return payload;
	}

	public long getReceivedOn() {
		return receivedOn;
	}

	public String getReceiver() {
		return receiver;
	}

	public String getSender() {
		return sender;
	}

	public long getSentOn() {
		return sentOn;
	}

	public String getTopic() {
		return topic;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public void setReceivedOn(long receivedOn) {
		this.receivedOn = receivedOn;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setSentOn(long sentOn) {
		this.sentOn = sentOn;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
