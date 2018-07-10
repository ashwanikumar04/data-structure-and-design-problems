package in.ashwanik.programming.design.messaging;

import java.util.Random;

public class App {

	public static void main(String[] args) throws InterruptedException {

		Subscriber subscriber1 = new Subscriber("Sub2");
		SubscribeService.subscribe(subscriber1, "topic1");

		Subscriber subscriber2 = new Subscriber("Sub2");
		SubscribeService.subscribe(subscriber2, "topic2");
		
		Subscriber subscriber3 = new Subscriber("Sub3");
		SubscribeService.subscribe(subscriber3, "topic3");
		
		Thread publisherThread = new Thread(new Runnable() {

			@Override
			public void run() {
				Random random = new Random();
				while (true) {
					Publisher publisher = new Publisher("Pub1");
					Message<String> message = new Message<String>();
					message.setTopic("topic" + random.nextInt(5));
					message.setPayload("Message for topic: "
							+ message.getTopic());
					publisher.publish(message);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		publisherThread.start();
		publisherThread.join();

	}

}
