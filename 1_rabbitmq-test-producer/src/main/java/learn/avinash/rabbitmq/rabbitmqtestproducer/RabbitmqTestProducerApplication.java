package learn.avinash.rabbitmq.rabbitmqtestproducer;

import learn.avinash.rabbitmq.rabbitmqtestproducer.enitity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class RabbitmqTestProducerApplication implements CommandLineRunner {

	@Autowired
	private HelloRabbitProducer helloRabbitProducer;

     @Autowired
	 private EmployeeJsonProducer employeeJsonProducer;

	@Autowired
	private HumResourceJsonProducer humResourceJsonProducer;



	public static void main(String[] args) {
		SpringApplication.run(RabbitmqTestProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloRabbitProducer.sendHello("Avinash "  + Math.random());

		for(int i = 0; i < 5; i++){
			Employee e = new Employee("empid " + i , "Employeename " + i , new Date());
			employeeJsonProducer.sendMessage(e);

		}

		for(int i = 0; i < 5; i++){
			Employee e = new Employee("empid " + i , "Employeename " + i , new Date());
			humResourceJsonProducer.sendMessage(e);

		}


	}
}

