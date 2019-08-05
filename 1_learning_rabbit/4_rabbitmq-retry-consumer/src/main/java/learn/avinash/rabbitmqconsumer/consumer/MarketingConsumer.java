package learn.avinash.rabbitmqconsumer.consumer;

import java.io.IOException;

import learn.avinash.rabbitmqconsumer.entity.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MarketingConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();

	@RabbitListener(queues = "q.hr.marketing")
	public void listen(String message)
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		var e = objectMapper.readValue(message, Employee.class);
		System.out.println("On marketing : " + e);
	}

}
