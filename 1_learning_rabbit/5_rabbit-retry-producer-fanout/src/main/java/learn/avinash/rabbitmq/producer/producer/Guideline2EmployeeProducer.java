package learn.avinash.rabbitmq.producer.producer;

import learn.avinash.rabbitmq.producer.entity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Guideline2EmployeeProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	private ObjectMapper objectMapper = new ObjectMapper();

	public void sendMessage(Employee e) throws JsonProcessingException {
		var json = objectMapper.writeValueAsString(e);
		rabbitTemplate.convertAndSend("x.guideline2.work", "", json);
	}

}
