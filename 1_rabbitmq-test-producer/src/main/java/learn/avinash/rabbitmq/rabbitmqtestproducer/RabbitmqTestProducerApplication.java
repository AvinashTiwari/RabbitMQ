package learn.avinash.rabbitmq.rabbitmqtestproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqTestProducerApplication implements CommandLineRunner {

	@Autowired
	private HelloRabbitProducer helloRabbitProducer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqTestProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloRabbitProducer.sendHello("Avinash "  + Math.random());
	}
}

