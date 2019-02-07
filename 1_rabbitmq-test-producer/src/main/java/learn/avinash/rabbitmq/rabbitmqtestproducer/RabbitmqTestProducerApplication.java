package learn.avinash.rabbitmq.rabbitmqtestproducer;

import learn.avinash.rabbitmq.rabbitmqtestproducer.enitity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableScheduling
public class RabbitmqTestProducerApplication implements CommandLineRunner {

	@Autowired
	private HelloRabbitProducer helloRabbitProducer;

     @Autowired
	 private EmployeeJsonProducer employeeJsonProducer;

	@Autowired
	private HumResourceJsonProducer humResourceJsonProducer;

	@Autowired
	private PictureProducer pictureProducer;

	@Autowired
	private MyPictureProducer mypictureProducer;

	private final List<String> SOURCES =  Arrays.asList("mobile", "web");

	// picture valid types
	private final List<String> TYPES =  Arrays.asList("jpg", "png", "svg");




	public static void main(String[] args) {
		SpringApplication.run(RabbitmqTestProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		helloRabbitProducer.sendHello("Avinash "  + Math.random());

		for(int i = 0; i < 5; i++){
			Employee e = new Employee("empid " + i , "Employeename " + i , new Date());
			employeeJsonProducer.sendMessage(e);

		}

		for(int i = 0; i < 5; i++){
			Employee e = new Employee("empid " + i , "Employeename " + i , new Date());
			humResourceJsonProducer.sendMessage(e);

		}

		for (int i = 0; i < 10; i++) {
			Picture p = new Picture();
			p.setName("Picture" + i);

			// random size between 1-9999
			p.setSize(ThreadLocalRandom.current().nextLong(1, 10000));

			// source from array, get from list, index 0-1
			p.setSource(SOURCES.get(i % SOURCES.size()));

			// type from array, get from list, index 0-2
			p.setType(TYPES.get(i % TYPES.size()));

			//pictureProducer.send(p);
			pictureProducer.sendMessage(p);
		}*/

		for (int i = 0; i < 1; i++) {
			Picture p = new Picture();
			p.setName("Picture" + i);

			// random size between 9001-9999
			p.setSize(ThreadLocalRandom.current().nextLong(9001, 10000));

			// source from array, get from list, index 0-1
			p.setSource(SOURCES.get(i % SOURCES.size()));

			// type from array, get from list, index 0-2
			p.setType(TYPES.get(i % TYPES.size()));

			mypictureProducer.sendMessage(p);
		}


	}
}

