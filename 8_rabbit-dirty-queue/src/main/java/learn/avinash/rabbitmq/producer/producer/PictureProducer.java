package learn.avinash.rabbitmq.producer.producer;

import learn.avinash.rabbitmq.producer.entity.Picture;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PictureProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	public void sendMessage(Picture p) throws JsonProcessingException {
		var sb = new StringBuilder();
		sb.append(p.getSource());
		sb.append('.');
		
		if (p.getSize() > 4000) {
			sb.append("large");
		} else {
			sb.append("small");
		}
		sb.append('.');
		
		sb.append(p.getType());
		
		var routingKey = sb.toString();
		
		var json = objectMapper.writeValueAsString(p);
		rabbitTemplate.convertAndSend("x.picture2", routingKey, json);
	}
	
}
