package learn.avinash.rabbit;

import learn.avinash.rabbit.producer.HelloRabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RabbitmqProducerApplication implements CommandLineRunner {
	
	@Autowired
	private HelloRabbitProducer helloRabbitProducer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloRabbitProducer.sendHello("Timotius " + Math.random());
	}

}
